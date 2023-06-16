package AppGui;

import javax.swing.*;
import java.awt.*;

public class CustomerChoose {

    public static void createCustomerWindow() {
        JFrame frame = new JFrame("Panel klienta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton addButton = new JButton("Nowy klient");
        addButton.addActionListener(e -> newCust());
        panel.add(addButton);

        JButton deleteButton = new JButton("Zarejestrowany klient");
        deleteButton.addActionListener(e -> oldCust(frame));
        panel.add(deleteButton);

        JButton exitButton = new JButton("Wyjście");
        exitButton.addActionListener(e -> frame.dispose());
        panel.add(exitButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static void newCust() {
        NewCustomer newCustomer = new NewCustomer();
        newCustomer.newCust();
    }

    private static void oldCust(JFrame frame) {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.showCustomerLoginDialog(frame);
    }


}
