package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Methods {
    public static void saveRoom(String fileName, String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

