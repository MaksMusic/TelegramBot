package org.example.loggi;

import org.telegram.telegrambots.meta.api.objects.Message;

public class Logger {


    public void printRequestInformationToLogger(Message message) {
        String greenColor = "\u001B[32m";
        String resetColor = "\u001B[0m";

        System.out.println(greenColor + "Запрос" + resetColor);
        System.out.println("ID User:" + message.getChatId());
        System.out.println("message: " + message.getText() +"\n");
        System.out.println("-----------------");
    }
}
