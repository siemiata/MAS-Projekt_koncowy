package AppGui;

import Structure.Association.Reservation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReserveMethod {



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
}
