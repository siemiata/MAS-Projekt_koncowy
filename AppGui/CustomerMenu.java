package AppGui;

import Data.DataLoader;
import Structure.Association.Reservation;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerMenu {
    public static List<Reservation> reservations = new ArrayList<>();

    public static void createCustomerWindow() {
        JFrame frame = new JFrame("Panel klienta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton addButton = new JButton("Przeglądaj pokoje");
        addButton.addActionListener(e -> lookRoom());
        panel.add(addButton);

        JButton deleteButton = new JButton("Moje rezerwacje");
        deleteButton.addActionListener(e -> myReservation());
        panel.add(deleteButton);

        JButton exitButton = new JButton("Wyjście");
        exitButton.addActionListener(e -> frame.dispose());
        panel.add(exitButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static void lookRoom() {

    }

    private static void myReservation() {

    }

}
