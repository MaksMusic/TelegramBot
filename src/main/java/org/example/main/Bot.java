package org.example.main;

import org.example.loggi.Logger;
import org.example.servise.RequestManager;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public Bot(String botToken) {
        super(botToken);
    }

    private RequestManager requestManager = new RequestManager();
    private Logger logger = new Logger();

    private static final String TOKEN = "6015181556:AAEfV-g5MuVVooWEMBU4oG9HRPQLa_D3JbM";
    private static final String NAME = "Java_city_bot";

    @Override
    public void onUpdateReceived(Update update) {
        // В этом методе обрабатывается полученное сообщение
        // Здесь вы можете добавить свою логику обработки сообщений
        Message message = update.getMessage();
        if (message.hasText()) {
            responseSend(message);
        }
    }


    private void responseSend(Message messageRequest) {

        SendMessage response = new SendMessage();
        response.setChatId(messageRequest.getChatId());
        response.setText(messageRequest.getText());

        //логирование запроса
        logger.printRequestInformationToLogger(messageRequest);

        //получить ответ на запрос
        String textResponse = requestManager.getResponse(messageRequest);

        //ответ пользователю который сделал запрос
        send(response, textResponse);


    }


    private void send(SendMessage sendMessage, String text) {
        try {
            //присвоить текст в ответ
            sendMessage.setText(text);
            //отправить
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return NAME;
    }
}
