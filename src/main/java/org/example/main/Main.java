package org.example.main;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public  class Main {
    private static final String TOKEN = "6015181556:AAEfV-g5MuVVooWEMBU4oG9HRPQLa_D3JbM";
    public static void main(String[] args) {

        try {
            // Создание объекта TelegramBotsApi для взаимодействия с Telegram API, используя сеанс по умолчанию (DefaultBotSession)
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Создание Бота который реализует функциональность  бота
            Bot botBot = new Bot(TOKEN);

            // Регистрация созданного бота (mainBot) в Telegram с использованием TelegramBotsApi
            telegramBotsApi.registerBot(botBot);

            // Обработка исключения TelegramApiException, которое может возникнуть при работе с Telegram API
        } catch (TelegramApiException e) {
            // Вывод информации об исключении (трассировка стека) в консоль
            e.printStackTrace();
        }
    }

}
