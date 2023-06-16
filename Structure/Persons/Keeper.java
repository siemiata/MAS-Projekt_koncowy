package Structure.Persons;

import Structure.Association.Repair;
import Structure.Rooms.Room;

import java.util.ArrayList;

public class Keeper extends Person{
    private int experienceInYears;
    private int maxRoomsKeep;
    private ArrayList<Repair> repairs;
    private ArrayList<Room> rooms;

    public Keeper(String personName, String personSurname, int pesel, int experienceInYears, int maxRoomsKeep) {
        super(personName, personSurname, pesel);
        this.experienceInYears = experienceInYears;
        this.maxRoomsKeep = maxRoomsKeep;
        this.repairs = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

}
