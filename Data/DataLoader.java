package Data;

import Structure.Association.Reservation;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DataLoader {

    public static List<Reservation> readReservationsFromFile(String filePath) {
        List<Reservation> reservations = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length == 4) {
                    int reservationID = Integer.parseInt(parts[0]);
                    Date reservationDate = parseDate(parts[1]);
                    int daysCount = Integer.parseInt(parts[2]);
                    String nickname = parts[3];

                    Reservation reservation = new Reservation(reservationID, reservationDate, daysCount, nickname);
                    reservations.add(reservation);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    private static Date parseDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }



}
