package AppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRoom {

    public static void deleteR(){
        JFrame frame = new JFrame("Delete room");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel roomIdLabel = new JLabel("ID pokoju do usunięcia:");
        JTextField roomIdField = new JTextField();
        panel.add(roomIdLabel);
        panel.add(roomIdField);


        JButton saveButton = new JButton("Usuń");
        JButton exitButton = new JButton("Wyjście");
        exitButton.addActionListener(e -> frame.dispose());
        panel.add(exitButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomId = roomIdField.getText();

                System.out.println("ID pokoju: " + roomId);

                JOptionPane.showMessageDialog(frame, "Poprawnie usunięto pokój", "Sukces !", JOptionPane.OK_OPTION);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
