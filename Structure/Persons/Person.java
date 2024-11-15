package Structure.Persons;

public abstract class Person {
    private String personName;
    private String personSurname;
    private int pesel;

    public Person(String personName, String personSurname, int pesel) {
        this.personName = personName;
        this.personSurname = personSurname;
        this.pesel = pesel;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public int getPesel() {
        return pesel;
    }
}
