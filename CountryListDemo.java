package Swings_5;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryListDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Country List");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // List of countries
        String countries[] = {
            "USA", "India", "Vietnam", "Canada", "Denmark",
            "France", "Great Britain", "Japan", "Africa",
            "Greenland", "Singapore"
        };

        // Capitals corresponding to countries
        String capitals[] = {
            "Washington D.C.", "New Delhi", "Hanoi", "Ottawa", "Copenhagen",
            "Paris", "London", "Tokyo", "No single capital",
            "Nuuk", "Singapore"
        };

        // Create JList
        JList<String> countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add selection listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    int index = countryList.getSelectedIndex();

                    if (index != -1) {
                        System.out.println("Capital of " + countries[index] + " is " + capitals[index]);
                    }
                }
            }
        });

        // Add JList inside scroll pane
        JScrollPane scrollPane = new JScrollPane(countryList);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        frame.add(scrollPane);
        frame.setVisible(true);
    }
}