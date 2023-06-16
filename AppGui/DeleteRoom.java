package AppGui;

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
import java.util.StringTokenizer;

public class DeleteRoom {
    public static ArrayList<Room> roomsList= new ArrayList<>();

    public static ArrayList<Room> readRoomsFromFile(String filePath) {
        ArrayList<Room> rooms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                int roomID = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                int maxPeople = Integer.parseInt(st.nextToken());
                int standard = Integer.parseInt(st.nextToken());
                rooms.add(new Room(roomID, name, maxPeople, standard));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static void writeRoomsToFile(ArrayList<Room> rooms, String filePath) {
        try (PrintWriter pw = new PrintWriter(filePath)) {
            for (Room room : rooms) {
                pw.println(room.getRoomID() + ";" + room.getName() + ";" + room.getMaxPeople() + ";" + room.getStandard());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                int roomIdInt = Integer.parseInt(roomId);

                roomsList = readRoomsFromFile("Data/rooms.txt");
                roomsList.remove(roomIdInt);
                writeRoomsToFile(roomsList,"Data/rooms.txt");


                JOptionPane.showMessageDialog(frame, "Poprawnie usunięto pokój", "Sukces !", JOptionPane.OK_OPTION);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
