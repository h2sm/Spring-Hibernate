package com.h2sm.springjpahibernate.services.functionality;

import com.h2sm.springjpahibernate.entities.Client;
import com.h2sm.springjpahibernate.services.console.ConsoleUI;
import lombok.RequiredArgsConstructor;

public class CRUDFunctions{
    public static Client updateClient(Client entity){
        var ui = new ConsoleUI();
        ui.say("Дайте имя");
        entity.setFullName(ui.read());
        ui.say("дайте паспорт");
        entity.setPassport(ui.read());
        return entity;
    }
}
