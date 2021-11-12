package com.h2sm.springjpahibernate.shell;

import com.h2sm.springjpahibernate.entities.Client;
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

    @ShellMethod(value = "modify client", key = {"mod-cli"}) //YYYY-MM-DD
    public void modifyClient(@ShellOption(value = "--id") int id) {
        service.update(id);

    }

    @ShellMethod(value = "add client", key = {"add-cli"})
    public void addClient(@ShellOption String fullName,
                          @ShellOption String passport,
                          @ShellOption String phoneNumber,
                          @ShellOption String dateOfBirth) {
        service.save(new Client(fullName, passport, phoneNumber, dateOfBirth));
    }

}
