package Structure.Rooms;

public class Room {
    private int roomID;
    private String name;
    private int maxPeople;
    private int standard;
    private RoomType roomType;
    private FamilySize familySize;

    public Room(int roomID, String name, int maxPeople, int standard, RoomType roomType, FamilySize familySize) {
        this.roomID = roomID;
        this.name = name;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.roomType = roomType;
        this.familySize = familySize;
    }
}
