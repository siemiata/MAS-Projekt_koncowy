package Structure.Association;

import Structure.Persons.Keeper;
import Structure.Rooms.Room;

import java.util.Date;

public class Repair {
    private int repairID;
    private String repairDate;
    private int repairCost;
    private Keeper keeper;
    private Room room;

    public Repair(int repairID, String repairDate, int repairCost, Keeper keeper, Room room) {
        this.repairID = repairID;
        this.repairDate = repairDate;
        this.repairCost = repairCost;
        this.keeper = keeper;
        this.room = room;
    }

    public Repair(int repairID, String repairDate, int repairCost) {
        this.repairID = repairID;
        this.repairDate = repairDate;
        this.repairCost = repairCost;
    }

    public int getRepairID() {
        return repairID;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public int getRepairCost() {
        return repairCost;
    }
}
