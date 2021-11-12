package com.h2sm.springjpahibernate.services.functionality;

import com.h2sm.springjpahibernate.entities.Client;
import com.h2sm.springjpahibernate.services.console.ConsoleUI;

public class UpdateFunction {
    public static Client updateClient(Client entity) {
        var ui = new ConsoleUI();
        ui.say("Обновите имя");
        entity.setFullName(ui.read());
        ui.say("Обновите паспорт");
        entity.setPassport(ui.read());
        return entity;
    }
}
