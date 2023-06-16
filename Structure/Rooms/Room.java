package Structure.Rooms;

import Structure.Association.Repair;
import Structure.Association.Reservation;
import Structure.Bathrooms.Bathroom;
import Structure.Persons.Keeper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room {
    private int roomID;
    private String name;
    private int maxPeople;
    private int standard;
    private RoomType roomType;
    private FamilySize familySize;
    private List<Bathroom> bathrooms = new ArrayList<>();
    private ArrayList<Reservation> reservations;
    private ArrayList<Repair> repairs;
    private Keeper keeper;

    public Room(int roomID, String name, int maxPeople, int standard) {
        this.roomID = roomID;
        this.name = name;
        this.maxPeople = maxPeople;
        this.standard = standard;
    }

    public Room(int roomID, String name, int maxPeople, int standard, RoomType roomType, FamilySize familySize, Keeper keeper) {
        this.roomID = roomID;
        this.name = name;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.roomType = roomType;
        this.familySize = familySize;
        this.reservations = new ArrayList<>();
        this.repairs = new ArrayList<>();
        this.keeper = keeper;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getName() {
        return name;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public int getStandard() {
        return standard;
    }

    public void addBathroom(Bathroom bathroom)throws Exception{
        if(!bathrooms.contains(bathroom)){
            bathrooms.add(bathroom);
        }
    }

}
