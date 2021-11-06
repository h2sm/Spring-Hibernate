package com.h2sm.springjpahibernate.shell;

import com.h2sm.springjpahibernate.database.ClientService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class CommandShell {
    private ClientService service;
   @ShellMethod(value = "get client", key = {"get"})
    public void get(@ShellOption int id){
        var x = service.findClientByID(id);
        x.ifPresent(System.out::println);
    }

}
