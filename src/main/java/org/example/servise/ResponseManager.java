package org.example.servise;

import org.example.dataBase.DataBase;
import org.example.entity.SessionUser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ResponseManager {
    private DataBase dataBase = DataBase.getInstance();
    private RegistrationSessionUser registrationSessionUser = new RegistrationSessionUser();
    private AuthorizationSessionUser authorizationSessionUser = new AuthorizationSessionUser();


    public String getResponse(Message request) {
        SendMessage response = new SendMessage();
        response.setChatId(request.getChatId());

        // получить юзера который совершил запрос если он есть в бд
        SessionUser sessionUser = authorizationSessionUser.getUserOrNull(request.getChatId());

        if (sessionUser != null && sessionUser.getLogin() != null) {
            return new Menu().responseMenu(request);

        } else {
           return registrationSessionUser.registration(request,sessionUser);
        }

    }


}
