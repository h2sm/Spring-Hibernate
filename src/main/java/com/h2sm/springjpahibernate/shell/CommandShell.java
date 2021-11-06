package com.h2sm.springjpahibernate.shell;

import com.h2sm.springjpahibernate.database.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class CommandShell {
    private final ClientService service;

    @ShellMethod(value = "get client", key = {"get"})
    public void get(@ShellOption int id) {
        var x = service.findClientByID(id);
        x.ifPresent(System.out::println);
    }

}
