package com.h2sm.springjpahibernate.shell;

import com.h2sm.springjpahibernate.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

@ShellComponent
@RequiredArgsConstructor
public class CommandShell {
    private final ClientService service;

    @ShellMethod(value = "get client", key = {"get-cli"})
    public void getClient(@ShellOption int id) {
        var x = service.findClientByID(id);
        ;
//        x.ifPresent(System.out::println);
        System.out.println(x);
    }

    @ShellMethod(value = "delete client", key = {"del-cli"})
    public void deleteClient(@ShellOption int id,
                             @ShellOption boolean sure) {
        if (sure) service.deleteClientByID(id);
        else System.out.println("You are not sure what ya doing, so no deleting this time");

    }

    @ShellMethod(value = "modify client", key = {"mod-cli"}) //YYYY-MM-DD
    public void modifyClient(@ShellOption(value = "--id") int id) {
        //service.modifyClient(id, valToChange, valToChange);

    }

    @ShellMethod(value = "add client", key = {"add-cli"})
    public void addClient(@ShellOption(arity = 3) String[] fullName,
                          @ShellOption String passport,
                          @ShellOption String phoneNumber,
                          @ShellOption String dateOfBirth) {
        var x = Arrays.stream(fullName).toList();

        //service.addClient(fullName,passport,phoneNumber,dateOfBirth);
    }

}
