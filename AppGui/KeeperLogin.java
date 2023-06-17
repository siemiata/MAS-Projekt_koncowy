package AppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KeeperLogin {

    public static void showKeeperLoginDialog(JFrame parentFrame) {
        JDialog loginDialog = new JDialog(parentFrame, "Logowanie opiekuna", true);
        loginDialog.setSize(500, 400);
        loginDialog.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Nazwa użytkownika:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Hasło:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Zaloguj");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());


                if(checkLogin(username,password) == true ){
                    System.out.println("Zalogowano");
                    KeeperMenu keeperMenu = new KeeperMenu();
                    keeperMenu.createWindow();
                    loginDialog.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(parentFrame, "Niepoprawny login lub hasło", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
                }

                System.out.println("Nazwa użytkownika: " + username + ", Hasło: " + password);
            }
        });

        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginDialog.dispose();
            }
        });

        loginDialog.add(usernameLabel);
        loginDialog.add(usernameField);
        loginDialog.add(passwordLabel);
        loginDialog.add(passwordField);
        loginDialog.add(loginButton);
        loginDialog.add(cancelButton);

        loginDialog.setLocationRelativeTo(parentFrame);
        loginDialog.setVisible(true);
    }
    public static boolean checkLogin(String login, String password) {
        boolean result = false;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("Data/keepers.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                String storedLogin = fields[fields.length - 2];
                String storedPassword = fields[fields.length - 1];

                if (login.equals(storedLogin) && password.equals(storedPassword)) {
                    result = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
