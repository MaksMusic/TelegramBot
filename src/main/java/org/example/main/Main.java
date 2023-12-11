package org.example.main;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public  class Main {
    public static void main(String[] args) {

        System.out.println("start");
        try {
            // Создание объекта TelegramBotsApi для взаимодействия с Telegram API, используя сеанс по умолчанию (DefaultBotSession)
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Создание экземпляра класса Main, который предположительно реализует функциональность вашего бота
            Bot botBot = new Bot();

            // Регистрация созданного бота (mainBot) в Telegram с использованием TelegramBotsApi
            telegramBotsApi.registerBot(botBot);

            // Обработка исключения TelegramApiException, которое может возникнуть при работе с Telegram API
        } catch (TelegramApiException e) {
            // Вывод информации об исключении (трассировка стека) в консоль
            e.printStackTrace();
        }
    }

}
