package AppGui;

import GUI.Methods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewRoom{

        public static void createAndShowGUI(){
            JFrame frame = new JFrame("Room Info");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel(new GridLayout(5, 2));

            JLabel roomIdLabel = new JLabel("ID pokoju:");
            JTextField roomIdField = new JTextField();
            panel.add(roomIdLabel);
            panel.add(roomIdField);

            JLabel nameLabel = new JLabel("Nazwa:");
            JTextField nameField = new JTextField();
            panel.add(nameLabel);
            panel.add(nameField);

            JLabel maxPeopleLabel = new JLabel("Max ilość osób:");
            JTextField maxPeopleField = new JTextField();
            panel.add(maxPeopleLabel);
            panel.add(maxPeopleField);

            JLabel standardLabel = new JLabel("Standard:");
            JTextField standardField = new JTextField();
            panel.add(standardLabel);
            panel.add(standardField);

            JButton saveButton = new JButton("Zapisz");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String roomId = roomIdField.getText();
                    String name = nameField.getText();
                    String maxPeople = maxPeopleField.getText();
                    String standard = standardField.getText();

                    System.out.println("ID pokoju: " + roomId);
                    System.out.println("Nazwa: " + name);
                    System.out.println("Max ilość osób: " + maxPeople);
                    System.out.println("Standard: " + standard);
                }
            });

            panel.add(new JLabel());
            panel.add(saveButton);

            frame.getContentPane().add(panel);
            frame.setVisible(true);
        }
}
