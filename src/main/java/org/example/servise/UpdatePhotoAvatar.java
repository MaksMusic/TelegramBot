package org.example.servise;

import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UpdatePhotoAvatar {


    // Получите ссылку на изображение для аватара бота
    private static final String PHOTO_URL = "https://www.iphones.ru/wp-content/uploads/2016/01/02-Java-Browser-Plug.jpg";


    public SetChatPhoto setPhotoAvatar() {
        SetChatPhoto setChatPhotoRequest = new SetChatPhoto();

        try {
            URL url = new URL(PHOTO_URL);
            InputStream inputStream = url.openStream();
            setChatPhotoRequest.setPhoto(new InputFile().setMedia(inputStream, "avatar.jpg"));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return setChatPhotoRequest;
    }
}
