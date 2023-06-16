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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NewRoom{
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


        public static void createAndShowGUI(){
            roomsList = readRoomsFromFile("Data/rooms.txt");
            JFrame frame = new JFrame("Room Info");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel(new GridLayout(6, 2));

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
            JButton exitButton = new JButton("Wyjście");
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    writeRoomsToFile(roomsList, "Data/rooms.txt");
                    frame.dispose();
                }
            });
            panel.add(exitButton);
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

                    roomsList.add(new Room((Integer.parseInt(roomId)),name,(Integer.parseInt((maxPeople))),(Integer.parseInt(standard))));
                    System.out.println(roomsList);


                    JOptionPane.showMessageDialog(frame, "Poprawnie dodano pokój", "Sukces !", JOptionPane.OK_OPTION);
                }
            });

            panel.add(new JLabel());
            panel.add(saveButton);

            frame.getContentPane().add(panel);
            frame.setVisible(true);
        }
}
