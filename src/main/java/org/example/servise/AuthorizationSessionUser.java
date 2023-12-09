package org.example.servise;

import org.example.dataBase.DataBase;
import org.example.entity.SessionUser;

public class AuthorizationSessionUser {
    private DataBase dataBase = DataBase.getInstance();
    public SessionUser getUserOrNull(Long id) {
        return dataBase.getSessionUsers().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }
}
