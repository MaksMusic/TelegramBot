package org.example.servise;

import org.example.dataBase.DataBase;
import org.example.entity.SessionUser;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;

public class RegistrationSessionUser {
    private DataBase dataBase = DataBase.getInstance();

    public String registration(Message request, SessionUser sessionUser) {
        if (sessionUser == null){
            SessionUser sessionUserNew = SessionUser.builder()
                    .id(request.getChatId())
                    .requestMessage(new ArrayList<>())
                    .build();

            dataBase.getSessionUsers().add(sessionUserNew);
            return "Привет, мы еще не знакомы \nПридумай login я тебя запомню";
        }else {
            addLoginToNewUser(request, sessionUser);
            return sessionUser.getLogin() + " ты зарегистрировался";
        }
    }

    private static void addLoginToNewUser(Message request, SessionUser sessionUser) {
        if (sessionUser.getLogin() == null){
            sessionUser.setLogin(request.getText());
        }
    }
}
