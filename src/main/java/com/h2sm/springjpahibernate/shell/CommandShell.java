package com.h2sm.springjpahibernate.shell;

import com.h2sm.springjpahibernate.entities.Client;
import com.h2sm.springjpahibernate.services.console.ConsoleUI;
import com.h2sm.springjpahibernate.services.database.ClientDBServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Arrays;

@ShellComponent
@RequiredArgsConstructor
public class CommandShell {
    private final ClientDBServiceImpl service;
    private final ConsoleUI ui;

    @ShellMethod(value = "getall clients", key = {"get-all"})
    public void getAllClients() {
        var x = service.getAll();
        x.forEach(System.out::println);
    }

    @ShellMethod(value = "get client", key = {"get-cli"})
    public void getClient(@ShellOption int id) {
        var x = service.getByID(id);
        x.ifPresent(System.out::println);
    }

    @ShellMethod(value = "delete client", key = {"del-cli"})
    public void deleteClient(@ShellOption int id,
                             @ShellOption boolean sure) {
        if (sure) service.delete(id);
        else System.out.println("You are not sure what ya doing, so no deleting this time");

    }

    @ShellMethod(value = "modify client", key = {"mod-cli"}) //YYYY-MM-DDmod-climid
    public void modifyClient(@ShellOption(value = "--id") int id) {
        var c = service.getByID(id);
        if (c.isPresent()) {
            var modifiedClient = getModifiedClient(c.get());
            System.out.println(modifiedClient + " modified in shell");
            service.update(modifiedClient);
        }

    }

    @ShellMethod(value = "add client", key = {"add-cli"})
    public void addClient(@ShellOption String fullName,
                          @ShellOption String passport,
                          @ShellOption String phoneNumber,
                          @ShellOption String dateOfBirth) {
        var c = new Client(fullName, passport, phoneNumber, dateOfBirth);
        service.save(c);
    }

    private Client getModifiedClient(Client c) {
        ui.say("Обновите имя");
        c.setFullName(ui.read());
        ui.say("Обновите паспорт");
        c.setPassport(ui.read());
        ui.say("обновите номер телефона");
        c.setPhoneNumber(ui.read());
        ui.say("обновите дату рождения: dd-MM-yyyy");
        c.setDate(ui.read());
        return c;
    }

}
