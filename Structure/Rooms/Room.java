package Structure.Rooms;

import Structure.Bathrooms.Bathroom;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomID;
    private String name;
    private int maxPeople;
    private int standard;
    private RoomType roomType;
    private FamilySize familySize;
    private List<Bathroom> bathrooms = new ArrayList<>();

    public Room(int roomID, String name, int maxPeople, int standard, RoomType roomType, FamilySize familySize) {
        this.roomID = roomID;
        this.name = name;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.roomType = roomType;
        this.familySize = familySize;
    }

    public void addBathroom(Bathroom bathroom)throws Exception{
        if(!bathrooms.contains(bathroom)){
            bathrooms.add(bathroom);
        }
    }

}
