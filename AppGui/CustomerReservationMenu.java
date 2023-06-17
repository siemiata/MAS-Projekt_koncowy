package AppGui;

import Structure.Association.Reservation;
import Structure.Persons.Customer;
import Structure.Rooms.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static AppGui.CustomerLogin.loggedUser;

public class CustomerReservationMenu {

    public static ArrayList<Reservation> reservationList = new ArrayList<>();

    public static ArrayList<Reservation> readRoomsFromFile(String filePath) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                int reservationID = Integer.parseInt(st.nextToken());
                String date = st.nextToken();
                int days = Integer.parseInt(st.nextToken());
                String nick = st.nextToken();
                reservations.add(new Reservation(reservationID, date, days, nick));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public void createFrame(){
        reservationList = readRoomsFromFile("Data/reservation.txt");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        System.out.println(loggedUser);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Rezerwacji");
        model.addColumn("Data");
        model.addColumn("Ilość dni");
        model.addColumn("Nickname");

        for (Reservation room : reservationList) {
            if(room.getNickname().equals(loggedUser))
            model.addRow(new Object[]{room.getReservationID(), room.getReservationDate(), room.getDaysCount(), room.getNickname()});
        }

        JTable table = new JTable(model);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }


}
