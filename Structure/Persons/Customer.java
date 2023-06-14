package Structure.Persons;

import Structure.Association.Reservation;

import java.util.ArrayList;

public class Customer extends Person{

    private int numberCreditCard;
    private ArrayList<Reservation> reservations;

    public Customer(String personName, String personSurname, int pesel, int numberCreditCard) {
        super(personName, personSurname, pesel);
        this.numberCreditCard = numberCreditCard;
        this.reservations = new ArrayList<>();
    }
}
