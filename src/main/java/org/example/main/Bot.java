package org.example.main;

import org.example.loggi.Logger;
import org.example.servise.ResponseManager;
import org.example.servise.UpdatePhotoAvatar;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {
    private ResponseManager responseManager = new ResponseManager();
    private Logger logger = new Logger();

    private static final String TOKEN = "6015181556:AAEfV-g5MuVVooWEMBU4oG9HRPQLa_D3JbM";
    private static final String NAME = "Java_city_bot";

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // В этом методе обрабатывается полученное сообщение
        // Здесь вы можете добавить свою логику обработки сообщений
        Message message = update.getMessage();
        if (message.hasText()) {
            responseSend(message);
        }
    }


    private void responseSend(Message message) {
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId());
        response.setText(message.getText());

        //логирование запроса
        logger.printRequestInformationToLogger(message);

        //получить ответ на запрос
        String textResponse = responseManager.getResponse(message);

        //ответ пользователю который сделал запрос
        replayToRequest(response, textResponse);


    }


    private static void sleep(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void replayToRequest(SendMessage response, String text) {
        try {
            //присвоить текст в ответ
            response.setText(text);
            //отправить
            execute(response);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return NAME;
    }

    private void updateAvatar(Bot botBot) {
        try {
            UpdatePhotoAvatar updatePhotoAvatar = new UpdatePhotoAvatar();
            execute(updatePhotoAvatar.setPhotoAvatar());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
