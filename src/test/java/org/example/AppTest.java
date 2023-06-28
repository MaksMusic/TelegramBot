package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private File file = new File("C:\\Users\\Admin\\IdeaProjects\\TelegramBot\\src\\main\\java\\org\\example\\Hello.txt");
    /**
     * Rigorous Test :-)
     */

    @Test
    public void str(){
        String s = "Привет,привет,прив,ку,приветик,Приветик,hello,Hello,приветсвую";
        System.out.println(s.contains("привет"));
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        System.out.println(response("привет"));
    }


    public String response(String text) {
        try {
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            System.out.println(lines);
            for (String line : lines) {
                String[] words = line.split(",");
                for (String word : words) {

                    System.out.println(word.equalsIgnoreCase(text));
                    if (word.trim().equalsIgnoreCase(text)) {

                        //return "И тебе привет";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
