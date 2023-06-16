package AppGui;

import AppGui.KeeperLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchAppClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Zielony Zakątek");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JButton opiekunButton = new JButton("OPIEKUN");
        opiekunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keeperLogin(frame);
            }
        });

        JButton klientButton = new JButton("KLIENT");
        klientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerLogin();
            }
        });

        JButton wyjscieButton = new JButton("WYJŚCIE");
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(opiekunButton);
        frame.add(klientButton);
        frame.add(wyjscieButton);

        frame.setVisible(true);
    }

    private static void keeperLogin(JFrame parentFrame) {
        System.out.println("Uruchomiono metodę keeperLogin()");
        KeeperLogin keeperLogin = new KeeperLogin();
        keeperLogin.showKeeperLoginDialog(parentFrame);
    }

    private static void customerLogin() {
        System.out.println("Uruchomiono metodę customerLogin()");
        // Tutaj dodaj logikę dla logowania klienta
    }
}
