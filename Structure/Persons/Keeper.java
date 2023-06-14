package Structure.Persons;

public class Keeper extends Person{
    private int experienceInYears;
    private int maxRoomsKeep;

    public Keeper(String personName, String personSurname, int pesel, int experienceInYears, int maxRoomsKeep) {
        super(personName, personSurname, pesel);
        this.experienceInYears = experienceInYears;
        this.maxRoomsKeep = maxRoomsKeep;
    }
}
