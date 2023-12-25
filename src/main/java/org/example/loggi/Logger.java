package org.example.loggi;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class Logger {


    public void printRequestInformationToLogger(Message message) {
        User user = message.getFrom();
        String greenColor = "\u001B[32m";
        String resetColor = "\u001B[0m";

        System.out.println(greenColor + "Запрос" + resetColor);
        System.out.println("ID User:" + message.getChatId());
        System.out.println("login :" + user.getUserName());
        System.out.println("message: " + message.getText() +"\n");
        System.out.println("-----------------");
    }
}
