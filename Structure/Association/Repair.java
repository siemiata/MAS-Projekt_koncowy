package Structure.Association;

import Structure.Persons.Keeper;
import Structure.Rooms.Room;

import java.util.Date;

public class Repair {
    private int repairID;
    private Date repairDate;
    private int repairCost;
    private Keeper keeper;
    private Room room;

    public Repair(int repairID, Date repairDate, int repairCost, Keeper keeper, Room room) {
        this.repairID = repairID;
        this.repairDate = repairDate;
        this.repairCost = repairCost;
        this.keeper = keeper;
        this.room = room;
    }
}
