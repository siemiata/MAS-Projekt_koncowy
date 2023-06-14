package Structure.Persons;

public class Customer extends Person{

    private int numberCreditCard;

    public Customer(String personName, String personSurname, int pesel, int numberCreditCard) {
        super(personName, personSurname, pesel);
        this.numberCreditCard = numberCreditCard;
    }
}
