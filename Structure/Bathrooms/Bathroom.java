package Structure.Bathrooms;

import Structure.Rooms.Room;

public class Bathroom {
    private int numberOfSinks;
    private boolean dryerAttached;
    private SprayType sprayType;
    private Room room;

    public Bathroom(int numberOfSinks, boolean dryerAttached, SprayType sprayType, Room room) {
        this.numberOfSinks = numberOfSinks;
        this.dryerAttached = dryerAttached;
        this.sprayType = sprayType;
        this.room = room;
    }

    public static Bathroom createBathroom(int numberOfSinks, boolean dryerAttached, SprayType sprayType, Room room) throws Exception {
        if (room == null){
            throw new Exception("The given room does not exist!");
        }
        Bathroom bathroom = new Bathroom(numberOfSinks, dryerAttached, sprayType, room);
        room.addBathroom(bathroom);
        return bathroom;
    }
}
