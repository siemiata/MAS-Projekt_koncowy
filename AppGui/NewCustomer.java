package AppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCustomer {

    public static void newCust(){
        JFrame frame = new JFrame("Nowy klient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(9, 2));

        JLabel roomIdLabel = new JLabel("ID klienta:");
        JTextField roomIdField = new JTextField();
        panel.add(roomIdLabel);
        panel.add(roomIdField);

        JLabel nameLabel = new JLabel("Imie:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel maxPeopleLabel = new JLabel("Nazwisko:");
        JTextField maxPeopleField = new JTextField();
        panel.add(maxPeopleLabel);
        panel.add(maxPeopleField);

        JLabel pesel = new JLabel("Pesel:");
        JTextField peselField = new JTextField();
        panel.add(pesel);
        panel.add(peselField);

        JLabel cardNumber = new JLabel("Numer karty:");
        JTextField cardNumberField = new JTextField();
        panel.add(cardNumber);
        panel.add(cardNumberField);

        JLabel login = new JLabel("Login:");
        JTextField loginField = new JTextField();
        panel.add(login);
        panel.add(loginField);

        JLabel password = new JLabel("Hasło:");
        JTextField passwordField = new JTextField();
        panel.add(password);
        panel.add(passwordField);

        JButton saveButton = new JButton("Zapisz");
        JButton exitButton = new JButton("Wyjście");
        exitButton.addActionListener(e -> frame.dispose());
        panel.add(exitButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomId = roomIdField.getText();
                String name = nameField.getText();
                String maxPeople = maxPeopleField.getText();

                System.out.println("ID naprawy " + roomId);
                System.out.println("Data: " + name);
                System.out.println("Koszt: " + maxPeople);
                JOptionPane.showMessageDialog(frame, "Poprawnie dodano klienta", "Sukces !", JOptionPane.OK_OPTION);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
