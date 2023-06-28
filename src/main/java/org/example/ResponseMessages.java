package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ResponseMessages {
    private File file = new File("C:\\Users\\Admin\\IdeaProjects\\TelegramBot\\src\\main\\resources\\Hello.txt");


    public String response(String text) {
        try {
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
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
