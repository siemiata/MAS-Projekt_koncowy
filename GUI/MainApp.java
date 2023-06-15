package GUI;

import Structure.Rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Aplikacja");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(300, 200);

            JPanel mainPanel = new JPanel();
            mainFrame.add(mainPanel);

            JButton browseRoomsButton = new JButton("Przeglądaj pokoje");
            browseRoomsButton.addActionListener(e -> {
                JFrame browseRoomsFrame = new JFrame("Przeglądaj pokoje");
                new HotelApp();
            });
            mainPanel.add(browseRoomsButton);

            JButton caretakerModeButton = new JButton("Tryb opiekun");
            caretakerModeButton.addActionListener(e -> {
                CaretakerModeFrame caretakerModeFrame = new CaretakerModeFrame();
                caretakerModeFrame.setVisible(true);
            });
            mainPanel.add(caretakerModeButton);

            JButton exitButton = new JButton("Zakończ program");
            exitButton.addActionListener(e -> System.exit(0));
            mainPanel.add(exitButton);

            mainFrame.setVisible(true);
        });
    }
}

class CaretakerModeFrame extends JFrame {
    private static final String CORRECT_LOGIN = "opiekun1";
    private static final String CORRECT_PASSWORD = "zdamMas";

    private JPanel mainPanel;
    private JPanel loginPanel;
    private JPanel buttonPanel;
    private JPanel loggedInPanel;

    public CaretakerModeFrame() {
        setTitle("Tryb opiekun");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        createLoginPanel();
        createLoggedInPanel();
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(new BorderLayout());
        mainPanel.add(loginPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Zaloguj się jako opiekun", SwingConstants.CENTER);
        loginPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel credentialsPanel = new JPanel(new GridLayout(2, 2));
        loginPanel.add(credentialsPanel, BorderLayout.CENTER);

        JLabel loginLabel = new JLabel("Login:");
        credentialsPanel.add(loginLabel);

        JTextField loginField = new JTextField();
        credentialsPanel.add(loginField);

        JLabel passwordLabel = new JLabel("Hasło:");
        credentialsPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        credentialsPanel.add(passwordField);

        buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JButton loginButton = new JButton("Zaloguj");
        buttonPanel.add(loginButton);
        setVisible(true);

        loginButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());

            if (CORRECT_LOGIN.equals(login) && CORRECT_PASSWORD.equals(password)) {
                loginPanel.setVisible(false);
                buttonPanel.setVisible(false);
                loggedInPanel.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Niepoprawny login lub hasło", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void createLoggedInPanel() {
        loggedInPanel = new JPanel();
        mainPanel.add(loggedInPanel, BorderLayout.CENTER);
        loggedInPanel.setVisible(false);

        JButton logoutButton = new JButton("Wyloguj");
        loggedInPanel.add(logoutButton);
        logoutButton.addActionListener(e -> {
            loggedInPanel.setVisible(false);
            loginPanel.setVisible(true);
            buttonPanel.setVisible(true);
        });

        JButton addRoomButton = new JButton("Dodaj nowy pokój");
        loggedInPanel.add(addRoomButton);
        addRoomButton.addActionListener(e -> {
            NewRoomCreatorFrame newRoomCreatorFrame = new NewRoomCreatorFrame();
            newRoomCreatorFrame.setVisible(true);
        });

        JButton removeRoomButton = new JButton("Usuń pokój");
        loggedInPanel.add(removeRoomButton);
        removeRoomButton.addActionListener(e ->{
            DeleteRoom deleteRoom = new DeleteRoom();
            deleteRoom.setVisible(true);
        });

        JButton searchRoomButton = new JButton("Wyszukaj pokój");
        loggedInPanel.add(searchRoomButton);
    }
}

class NewRoomCreatorFrame extends JFrame {
    private JTextField roomIdField;
    private JTextField roomNameField;
    private JTextField maxPeopleField;
    private JTextField roomStandardField;
    private JCheckBox standardCheckBox;
    private JCheckBox specialCheckBox;
    private JCheckBox largeFamilyCheckBox;
    private JCheckBox smallFamilyCheckBox;
    private JTextField additionalInfoField;

    public NewRoomCreatorFrame() {
        setTitle("Kreator nowego pokoju");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        mainPanel.add(formPanel, BorderLayout.CENTER);

        formPanel.add(new JLabel("ID Pokoju:"));
        roomIdField = new JTextField();
        formPanel.add(roomIdField);

        formPanel.add(new JLabel("Nazwa:"));
        roomNameField = new JTextField();
        formPanel.add(roomNameField);

        formPanel.add(new JLabel("Max Ilość Osób:"));
        maxPeopleField = new JTextField();
        formPanel.add(maxPeopleField);

        formPanel.add(new JLabel("Standard 1-5:"));
        roomStandardField = new JTextField();
        formPanel.add(roomStandardField);

        formPanel.add(new JLabel("Typ pokoju:"));
        JPanel checkBoxPanel = new JPanel();
        formPanel.add(checkBoxPanel);

        standardCheckBox = new JCheckBox("Standardowy");
        checkBoxPanel.add(standardCheckBox);
        standardCheckBox.addItemListener(new CheckBoxListener());

        specialCheckBox = new JCheckBox("Specjalny");
        checkBoxPanel.add(specialCheckBox);
        specialCheckBox.addItemListener(new CheckBoxListener());

        largeFamilyCheckBox = new JCheckBox("Duża rodzina");
        checkBoxPanel.add(largeFamilyCheckBox);
        largeFamilyCheckBox.addItemListener(new CheckBoxListener());

        smallFamilyCheckBox = new JCheckBox("Mała rodzina");
        checkBoxPanel.add(smallFamilyCheckBox);

        formPanel.add(new JLabel("Dodatkowe informacje:"));
        additionalInfoField = new JTextField();
        formPanel.add(additionalInfoField);
        additionalInfoField.setVisible(false);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JButton saveRoomButton = new JButton("Zapisz pokój");
        buttonPanel.add(saveRoomButton);
        saveRoomButton.addActionListener(e -> {
            String roomId = roomIdField.getText();
            String roomName = roomNameField.getText();
            String maxPeople = maxPeopleField.getText();
            String roomStandard = roomStandardField.getText();
            String additionalInfo = additionalInfoField.getText();

            System.out.println("ID Pokoju: " + roomId);
            System.out.println("Nazwa: " + roomName);
            System.out.println("Max Ilość Osób: " + maxPeople);
            System.out.println("Standard 1-5: " + roomStandard);
            System.out.println("Standardowy: " + standardCheckBox.isSelected());
            System.out.println("Specjalny: " + specialCheckBox.isSelected());
            System.out.println("Duża rodzina: " + largeFamilyCheckBox.isSelected());
            System.out.println("Mała rodzina: " + smallFamilyCheckBox.isSelected());
            System.out.println("Dodatkowe informacje: " + additionalInfo);

            String roomString = roomId + ";" + roomName + ";" + maxPeople + ";" + roomStandard + ";" + standardCheckBox.isSelected() + ";" + specialCheckBox.isSelected() + ";" + largeFamilyCheckBox.isSelected() + ";" + smallFamilyCheckBox.isSelected() + ";" + additionalInfo;

            Methods methods = new Methods();
            methods.saveRoom("Data/Rooms.txt", roomString);

            JOptionPane.showMessageDialog(this, "Zapisano nowy pokój", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private class CheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (standardCheckBox.isSelected() || specialCheckBox.isSelected() || largeFamilyCheckBox.isSelected()) {
                additionalInfoField.setVisible(true);
            } else {
                additionalInfoField.setVisible(false);
            }
        }
    }
}

class DeleteRoom extends JFrame {
    private JTextField roomIdField;

    public DeleteRoom() {
        setTitle("Usuwanie pokoju");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        mainPanel.add(formPanel, BorderLayout.CENTER);

        formPanel.add(new JLabel("ID Pokoju:"));
        roomIdField = new JTextField();
        formPanel.add(roomIdField);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JButton saveRoomButton = new JButton("Zapisz pokój");
        buttonPanel.add(saveRoomButton);
        saveRoomButton.addActionListener(e -> {
            String roomId = roomIdField.getText();

            System.out.println("Usunięto pokój : " + roomId);

            JOptionPane.showMessageDialog(this, "Usunięto pokój!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
        });
    }

}



