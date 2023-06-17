package Structure.Persons;

import Structure.Association.Reservation;

import java.util.ArrayList;

public class Customer extends Person{

    private int numberCreditCard;
    private ArrayList<Reservation> reservations;
    private String login;
    private String password;

    public Customer(String personName, String personSurname, int pesel, int numberCreditCard, String login, String password) {
        super(personName, personSurname, pesel);
        this.numberCreditCard = numberCreditCard;
        this.reservations = new ArrayList<>();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getNumberCreditCard() {
        return numberCreditCard;
    }
}
