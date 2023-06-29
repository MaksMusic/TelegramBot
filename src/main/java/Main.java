
import org.example.ResponseMessages;
import org.example.UpdatePhotoAvatar;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main extends TelegramLongPollingBot {
    private ResponseMessages responseMessages = new ResponseMessages();

    static String TOKEN = "6015181556:AAEfV-g5MuVVooWEMBU4oG9HRPQLa_D3JbM";
    static String NAME = "Java_city_bot";

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public  void onUpdateReceived(Update update) {
        // В этом методе обрабатывается полученное сообщение
        // Здесь вы можете добавить свою логику обработки сообщений
        Message message = update.getMessage();
        if (message.hasText()) {
            responseSend(message);
        }
    }


    private void responseSend(Message message){
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId());
        String answer = responseMessages.response(message.getText());

        try {
            response.setText(answer);
        }catch (NullPointerException e){
            response.setText("Ваша заявка обрабатывается ожидайте ответа");
        }


        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        try {
            response.setText(responseMessages.responseMenu());
            execute(response);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }


    }


    @Override
    public String getBotUsername() {
        return NAME;
    }

    private  void updateAvatar(Main mainBot){
        try {
            UpdatePhotoAvatar updatePhotoAvatar = new UpdatePhotoAvatar();
            execute(updatePhotoAvatar.setPhotoAvatar());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("start");
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            Main mainBot = new Main();
            telegramBotsApi.registerBot(mainBot);


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}