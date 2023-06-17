package AppGui;

import Structure.Association.Repair;
import Structure.Persons.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NewCustomer {

    public static ArrayList<Customer> customersList= new ArrayList<>();

    public static void newCust(){
        customersList = readRoomsFromFile("Data/customers.txt");
        System.out.println(customersList);
        JFrame frame = new JFrame("Nowy klient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel nameLabel = new JLabel("Imie:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel maxPeopleLabel = new JLabel("Nazwisko:");
        JTextField surnameField = new JTextField();
        panel.add(maxPeopleLabel);
        panel.add(surnameField);

        JLabel peselLabel = new JLabel("Pesel:");
        JTextField peselField = new JTextField();
        panel.add(peselLabel);
        panel.add(peselField);

        JLabel cardNumber = new JLabel("Numer karty:");
        JTextField cardNumberField = new JTextField();
        panel.add(cardNumber);
        panel.add(cardNumberField);

        JLabel login = new JLabel("Login:");
        JTextField loginField = new JTextField();
        panel.add(login);
        panel.add(loginField);

        JLabel password = new JLabel("Hasło:");
        JTextField passwordField = new JTextField();
        panel.add(password);
        panel.add(passwordField);

        JButton saveButton = new JButton("Zapisz");
        JButton exitButton = new JButton("Wyjście");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                writeRoomsToFile(customersList, "Data/customers.txt");
            }
        });
        panel.add(exitButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Imie: " + nameField.getText());
                System.out.println("Nazwisko: " + surnameField.getText());
                System.out.println("Pesel: " + peselField.getText());
                System.out.println("Karta: " + cardNumberField.getText());
                System.out.println("Login: " + loginField.getText());
                System.out.println("Hasło: " + passwordField.getText());
                customersList.add(new Customer(nameField.getText(),surnameField.getText(),Integer.parseInt(peselField.getText()),Integer.parseInt(cardNumberField.getText()), loginField.getText(), passwordField.getText()));
                JOptionPane.showMessageDialog(frame, "Poprawnie dodano klienta", "Sukces !", JOptionPane.OK_OPTION);
            }
        });

        panel.add(new JLabel());
        panel.add(saveButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }



    public static ArrayList<Customer> readRoomsFromFile(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                int customerID = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                String surname = st.nextToken();
                int pesel = Integer.parseInt(st.nextToken());
                int card = Integer.parseInt(st.nextToken());
                String login = st.nextToken();
                String password = st.nextToken();

                customers.add(new Customer(name,surname,pesel,card,login,password));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void writeRoomsToFile(ArrayList<Customer> custom, String filePath) {
        try (PrintWriter pw = new PrintWriter(filePath)) {
            int i=0;
            for (Customer repair : custom) {
                pw.println(i+";"+repair.getPersonName() + ";" + repair.getPersonSurname() + ";" + repair.getPesel()+ ";" + repair.getNumberCreditCard() + ";" + repair.getLogin()+ ";" + repair.getPassword());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
