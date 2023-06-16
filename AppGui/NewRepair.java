package AppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewRepair {

    public static void newRep(){
        JFrame frame = new JFrame("Nowa naprawa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel roomIdLabel = new JLabel("ID naprawy:");
        JTextField roomIdField = new JTextField();
        panel.add(roomIdLabel);
        panel.add(roomIdField);

        JLabel nameLabel = new JLabel("Data:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel maxPeopleLabel = new JLabel("Koszt:");
        JTextField maxPeopleField = new JTextField();
        panel.add(maxPeopleLabel);
        panel.add(maxPeopleField);

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
                JOptionPane.showMessageDialog(frame, "Poprawnie dodano naprawę", "Sukces !", JOptionPane.OK_OPTION);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
