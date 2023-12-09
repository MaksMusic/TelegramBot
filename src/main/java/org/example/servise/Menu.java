package org.example.servise;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class Menu {
    private File fileMenu = new File("C:\\Users\\Admin\\IdeaProjects\\TelegramBot\\src\\main\\resources\\Menu.txt");
    private File fileHello = new File("C:\\Users\\Admin\\IdeaProjects\\TelegramBot\\src\\main\\resources\\Hello.txt");
    public String responseMenu(Message request) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String menu = "";
        try {
            menu += Files.readAllLines(fileMenu.toPath()).stream().map(String::trim).collect(Collectors.joining("\n"));
            return menu;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
//        try {
//            List<String> lines = Files.readAllLines(fileHello.toPath(), StandardCharsets.UTF_8);
//            for (String line : lines) {
//                String[] words = line.split(",");
//                for (String word : words) {
//                    if (word.trim().equalsIgnoreCase(text)) {
//                        return "И тебе привет";
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
