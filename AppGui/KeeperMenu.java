package AppGui;

import javax.swing.*;
import java.awt.*;

public class KeeperMenu {
    public static void createWindow() {
        JFrame frame = new JFrame("Zarządzanie pokojami");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));

        JButton addButton = new JButton("Dodaj pokój");
        addButton.addActionListener(e -> newRoom());
        panel.add(addButton);

        JButton deleteButton = new JButton("Usuń pokój");
        deleteButton.addActionListener(e -> deleteRoom());
        panel.add(deleteButton);

        JButton lookButton = new JButton("Przeglądaj pokoje");
        lookButton.addActionListener(e -> lookRoom());
        panel.add(lookButton);

        JButton repairButton = new JButton("Wprowadź naprawę");
        repairButton.addActionListener(e -> insertRepair());
        panel.add(repairButton);

        JButton exitButton = new JButton("Wyjście");
        exitButton.addActionListener(e -> frame.dispose());
        panel.add(exitButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static void newRoom() {
        NewRoom room = new NewRoom();
        room.createAndShowGUI();
    }

    private static void deleteRoom() {
        // Implementacja metody deleteRoom()
    }

    private static void lookRoom(){

    }
    private static void insertRepair(){

    }
}
