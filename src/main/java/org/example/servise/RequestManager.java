package org.example.servise;

import org.example.dataBase.DataBase;
import org.example.entity.SessionUser;
import org.telegram.telegrambots.meta.api.objects.Message;

public class RequestManager {
    private DataBase dataBase = DataBase.getInstance();
    private RegistrationSessionUser registrationSessionUser = new RegistrationSessionUser();
    private AuthorizationSessionUser authorizationSessionUser = new AuthorizationSessionUser();


    public String getResponse(Message messageRequest) {
        // получить юзера который совершил запрос если он есть в бд
        SessionUser sessionUser = authorizationSessionUser.getUserOrNull(messageRequest.getChatId());

        //есть ли юзер в бд и писал ли юзер свой логин при регистрации
        if (sessionUser != null && sessionUser.getLogin() != null) {
            return new Menu().responseMenu(messageRequest);

        } else {
           return registrationSessionUser.registration(messageRequest,sessionUser);
        }

    }


}
