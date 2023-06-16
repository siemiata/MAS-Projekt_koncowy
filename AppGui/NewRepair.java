package AppGui;

import Structure.Association.Repair;
import Structure.Rooms.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class NewRepair {

    public static void newRep(){
       repairsList =  readRoomsFromFile("Data/repairs.txt");
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
                repairsList.add(new Repair(Integer.parseInt(roomId),name,Integer.parseInt(maxPeople)));
                writeRoomsToFile(repairsList,"Data/repairs.txt");

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

    public static ArrayList<Repair> repairsList= new ArrayList<>();

    public static ArrayList<Repair> readRoomsFromFile(String filePath) {
        ArrayList<Repair> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                int repairID = Integer.parseInt(st.nextToken());
                String date = st.nextToken();
                int repairCost = Integer.parseInt(st.nextToken());

                repairsList.add(new Repair(repairID,date,repairCost));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repairsList;
    }

    public static void writeRoomsToFile(ArrayList<Repair> repairs, String filePath) {
        try (PrintWriter pw = new PrintWriter(filePath)) {
            for (Repair repair : repairs) {
                pw.println(repair.getRepairID() + ";" + repair.getRepairDate() + ";" + repair.getRepairCost());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
