package org.example.dataBase;

import org.example.entity.SessionUser;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

//Singleton

public final class DataBase {
    private static DataBase dataBase = new DataBase();
    private List<SessionUser> sessionUsers = new ArrayList<>();

    public static DataBase getInstance(){
        if (dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public List<SessionUser> getSessionUsers() {
        return sessionUsers;
    }


    private DataBase() {}
}
