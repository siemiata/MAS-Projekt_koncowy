package AppGui;

import Structure.Association.Reservation;
import Structure.Persons.Customer;
import Structure.Rooms.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

import static AppGui.CustomerLogin.loggedUser;

public class ReservationPanel {
    public static ArrayList<Room> roomsList = new ArrayList<>();
    public static ArrayList<Reservation> reservationList = new ArrayList<>();
    static Date data = new Date();

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

    public void createFramePanel(){
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

        JPanel panel = new JPanel();
        JLabel textlabel = new JLabel("Wpisz numer pokoju");
        JTextField textField = new JTextField(10);
        panel.add(textlabel);
        panel.add(textField);

        JLabel textlabel2 = new JLabel("Wpisz ilość dni");
        JTextField textField2 = new JTextField(10);
        panel.add(textlabel2);
        panel.add(textField2);

        JButton button = new JButton("Rezerwuj");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserve();
                reservationList.add(new Reservation(0,String.valueOf(data),Integer.parseInt(String.valueOf(textField2.getText())),loggedUser));
                writeRoomsToFile(reservationList, "Data/reservation.txt");
                JOptionPane.showMessageDialog(frame, "Poprawnie zarezerwowano pokój " + textField.getText(), "Sukces !", JOptionPane.OK_OPTION);
            }
        });


        panel.add(button);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    public static void reserve(){
        ReserveMethod reserveMethod = new ReserveMethod();
       reservationList = reserveMethod.readRoomsFromFile("Data/reservation.txt");
    }
    public static void writeRoomsToFile(ArrayList<Reservation> custom, String filePath) {
        try (PrintWriter pw = new PrintWriter(filePath)) {
            int i=0;
            for (Reservation repair : custom) {
                pw.println(i+";"+repair.getReservationDate() + ";" + repair.getDaysCount() + ";" + repair.getNickname());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
