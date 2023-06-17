package AppGui;

import Structure.Rooms.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LookUpRooms {
    public static ArrayList<Room> roomsList = new ArrayList<>();

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

    public void createFrame(){
        roomsList = readRoomsFromFile("Data/rooms.txt");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pokoju");
        model.addColumn("Nazwa");
        model.addColumn("Maksymalna liczba osób");
        model.addColumn("Standard");

        for (Room room : roomsList) {
            model.addRow(new Object[]{room.getRoomID(), room.getName(), room.getMaxPeople(), room.getStandard()});
        }

        JTable table = new JTable(model);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }


}
