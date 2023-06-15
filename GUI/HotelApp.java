package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelApp extends JFrame {

    private List<Pokoj> pokoje = new ArrayList<>();
    private JPanel panel;
    private JTable tabela;
    private JButton rezerwujButton;

    public HotelApp() {
        super("Hotel");


        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data/Rooms.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String nazwa = parts[1];
                int maxOsob = Integer.parseInt(parts[2]);
                int standard = Integer.parseInt(parts[3]);
                boolean pokojStandardowy = Boolean.parseBoolean(parts[4]);
                boolean pokojSpecialny = Boolean.parseBoolean(parts[5]);
                boolean duzaRodzina = Boolean.parseBoolean(parts[6]);
                boolean malaRodzina = Boolean.parseBoolean(parts[7]);
                String dodatkoweInformacje = parts.length > 8 ? parts[8] : "";
                Pokoj pokoj = new Pokoj(id, nazwa, maxOsob, standard, pokojStandardowy, pokojSpecialny, duzaRodzina, malaRodzina, dodatkoweInformacje);
                pokoje.add(pokoj);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        panel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID pokoju", "Nazwa", "Max ilość osób", "Standard 1-5", "Pokój standardowy", "Pokój specialny", "Duża rodzina", "Mała rodzina", "Dodatkowe informacje", "Rezerwacja"};
        Object[][] data = new Object[pokoje.size()][columnNames.length];
        for (int i = 0; i < pokoje.size(); i++) {
            Pokoj pokoj = pokoje.get(i);
            data[i][0] = pokoj.getId();
            data[i][1] = pokoj.getNazwa();
            data[i][2] = pokoj.getMaxOsob();
            data[i][3] = pokoj.getStandard();
            data[i][4] = pokoj.isPokojStandardowy();
            data[i][5] = pokoj.isPokojSpecialny();
            data[i][6] = pokoj.isDuzaRodzina();
            data[i][7] = pokoj.isMalaRodzina();
            data[i][8] = pokoj.getDodatkoweInformacje();
            data[i][9] = new JCheckBox();
        }
        tabela = new JTable(data, columnNames);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(8).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane, BorderLayout.CENTER);

        rezerwujButton = new JButton("Rezerwuj");
        rezerwujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabela.getSelectedRow();
                if (selectedRow >= 0) {
                    int id = (int) tabela.getValueAt(selectedRow, 0);
                    String nazwa = (String) tabela.getValueAt(selectedRow, 1);
                    int maxOsob = (int) tabela.getValueAt(selectedRow, 2);
                    int standard = (int) tabela.getValueAt(selectedRow, 3);
                    boolean pokojStandardowy = (boolean) tabela.getValueAt(selectedRow, 4);
                    boolean pokojSpecialny = (boolean) tabela.getValueAt(selectedRow, 5);
                    boolean duzaRodzina = (boolean) tabela.getValueAt(selectedRow, 6);
                    boolean malaRodzina = (boolean) tabela.getValueAt(selectedRow, 7);
                    String dodatkoweInformacje = (String) tabela.getValueAt(selectedRow, 8);
                    boolean rezerwacja = ((JCheckBox) tabela.getValueAt(selectedRow, 9)).isSelected();
                    if (rezerwacja) {
                        JFrame frame = new JFrame("Rezerwacja pokoju");
                        JPanel panel = new JPanel(new GridLayout(5, 2));
                        panel.add(new JLabel("ID pokoju:"));
                        panel.add(new JLabel(Integer.toString(id)));
                        panel.add(new JLabel("Nazwa:"));
                        panel.add(new JLabel(nazwa));
                        panel.add(new JLabel("Max ilość osób:"));
                        panel.add(new JLabel(Integer.toString(maxOsob)));
                        panel.add(new JLabel("Standard 1-5:"));
                        panel.add(new JLabel(Integer.toString(standard)));
                        panel.add(new JLabel("Imię:"));
                        JTextField imieField = new JTextField();
                        panel.add(imieField);
                        panel.add(new JLabel("Nazwisko:"));
                        JTextField nazwiskoField = new JTextField();
                        panel.add(nazwiskoField);
                        panel.add(new JLabel("PESEL:"));
                        JTextField peselField = new JTextField();
                        panel.add(peselField);
                        panel.add(new JLabel("Numer karty kredytowej:"));
                        JTextField numerKartyField = new JTextField();
                        panel.add(numerKartyField);
                        JButton potwierdzButton = new JButton("Potwierdź rezerwację");
                        potwierdzButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String imie = imieField.getText();
                                String nazwisko = nazwiskoField.getText();
                                String pesel = peselField.getText();
                                String numerKarty = numerKartyField.getText();
                                System.out.println("Dane klienta:");
                                System.out.println("Imię: " + imie);
                                System.out.println("Nazwisko: " + nazwisko);
                                System.out.println("PESEL: " + pesel);
                                System.out.println("Numer karty kredytowej: " + numerKarty);
                                System.out.println("Dane pokoju:");
                                System.out.println("ID pokoju: " + id);
                                System.out.println("Nazwa: " + nazwa);
                                System.out.println("Max ilość osób: " + maxOsob);
                                System.out.println("Standard 1-5: " + standard);
                                System.out.println("Pokój standardowy: " + pokojStandardowy);
                                System.out.println("Pokój specjalny: " + pokojSpecialny);
                                System.out.println("Duża rodzina: " + duzaRodzina);
                                System.out.println("Mała rodzina: " + malaRodzina);
                                System.out.println("Dodatkowe informacje: " + dodatkoweInformacje);
                                JOptionPane.showMessageDialog(frame, "Zarezerwowano pokój !");
                                frame.dispose();
                            }
                        });
                        panel.add(potwierdzButton);
                        frame.add(panel);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(HotelApp.this, "Nie zaznaczono rezerwacji !");
                    }
                } else {
                    JOptionPane.showMessageDialog(HotelApp.this, "Nie wybrano pokoju !");
                }
            }
        });
        panel.add(rezerwujButton, BorderLayout.SOUTH);

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class Pokoj {
        private int id;
        private String nazwa;
        private int maxOsob;
        private int standard;
        private boolean pokojStandardowy;
        private boolean pokojSpecialny;
        private boolean duzaRodzina;
        private boolean malaRodzina;
        private String dodatkoweInformacje;

        public Pokoj(int id, String nazwa, int maxOsob, int standard, boolean pokojStandardowy, boolean pokojSpecialny, boolean duzaRodzina, boolean malaRodzina, String dodatkoweInformacje) {
            this.id = id;
            this.nazwa = nazwa;
            this.maxOsob = maxOsob;
            this.standard = standard;
            this.pokojStandardowy = pokojStandardowy;
            this.pokojSpecialny = pokojSpecialny;
            this.duzaRodzina = duzaRodzina;
            this.malaRodzina = malaRodzina;
            this.dodatkoweInformacje = dodatkoweInformacje;
        }

        public int getId() {
            return id;
        }

        public String getNazwa() {
            return nazwa;
        }

        public int getMaxOsob() {
            return maxOsob;
        }

        public int getStandard() {
            return standard;
        }

        public boolean isPokojStandardowy() {
            return pokojStandardowy;
        }

        public boolean isPokojSpecialny() {
            return pokojSpecialny;
        }

        public boolean isDuzaRodzina() {
            return duzaRodzina;
        }

        public boolean isMalaRodzina() {
            return malaRodzina;
        }

        public String getDodatkoweInformacje() {
            return dodatkoweInformacje;
        }
    }
}
