package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseMessages {
    private File fileHello = new File("C:\\Users\\Admin\\IdeaProjects\\TelegramBot\\src\\main\\resources\\Hello.txt");
    private File fileMenu = new File("C:\\Users\\Admin\\IdeaProjects\\TelegramBot\\src\\main\\resources\\Menu.txt");

    public String responseMenu(){
        String menu = "";
        try {
          menu += Files.readAllLines(fileMenu.toPath()).stream().map(String::trim).collect(Collectors.joining("\n"));
          return menu;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String response(String text) {
        try {
            List<String> lines = Files.readAllLines(fileHello.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] words = line.split(",");
                for (String word : words) {
                    if (word.trim().equalsIgnoreCase(text)) {
                        return "И тебе привет";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
