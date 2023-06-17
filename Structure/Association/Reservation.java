package Structure.Association;

import Structure.Bathrooms.Bathroom;
import Structure.Persons.Customer;
import Structure.Persons.Keeper;
import Structure.Rooms.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private int reservationID;
    private String reservationDate;
    private int daysCount;
    private String nickname;
    private ReservationStatus reservationStatus;
    private List<Opinion> opinions = new ArrayList<>();
    private Customer customer;
    private Room room;

    public Reservation(int reservationID, String reservationDate, int daysCount, String nickname){
        this.reservationID = reservationID;
        this.reservationDate = reservationDate;
        this.daysCount = daysCount;
        this.nickname = nickname;
    }

    public Reservation(int reservationID, String reservationDate, int daysCount, ReservationStatus reservationStatus, Customer customer, Room room) {
        this.reservationID = reservationID;
        this.reservationDate = reservationDate;
        this.daysCount = daysCount;
        this.reservationStatus = reservationStatus;
        this.customer = customer;
        this.room = room;
    }

    public int getReservationID() {
        return reservationID;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public String getNickname() {
        return nickname;
    }

    public void addOpinion(Opinion opinion)throws Exception{
        if(!opinions.contains(opinion)){
            opinions.add(opinion);
        }
    }
}
