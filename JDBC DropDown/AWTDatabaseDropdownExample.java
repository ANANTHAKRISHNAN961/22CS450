import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AWTDatabaseDropdownExample {
    private Frame frame;
    private JComboBox<String> countryDropdown;
    private JComboBox<String> stateDropdown;
    private JComboBox<String> cityDropdown;
    private Connection connection;

    public AWTDatabaseDropdownExample() {
        frame = new Frame("Database Dropdown Example");

        countryDropdown = new JComboBox<>();
        stateDropdown = new JComboBox<>();
        cityDropdown = new JComboBox<>();

        connectToDatabase();
        populateCountryDropdown();

        countryDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryDropdown.getSelectedItem();
                if (selectedCountry != null) {
                    System.out.println("Selected country: " + selectedCountry);
                    populateStateDropdown(selectedCountry);
                } else {
                    System.out.println("No country selected");
                }
            }
        });

        stateDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedState = (String) stateDropdown.getSelectedItem();
                if (selectedState != null) {
                    System.out.println("Selected state: " + selectedState);
                    populateCityDropdown(selectedState);
                } else {
                    System.out.println("No state selected");
                }
            }
        });

        Panel panel = new Panel(new GridLayout(3, 2));
        panel.add(new Label("Country:"));
        panel.add(countryDropdown);
        panel.add(new Label("State:"));
        panel.add(stateDropdown);
        panel.add(new Label("City:"));
        panel.add(cityDropdown);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "anand";
            String password = "krish";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateCountryDropdown() {
        try {
            String query = "SELECT distinct country_name FROM countries";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Check if the result set is empty
            if (!resultSet.next()) {
                System.out.println("No countries retrieved from the database.");
                return; // Exit the method if no countries are retrieved
            }

            // Iterate over the result set to retrieve country names
            do {
                String countryName = resultSet.getString("COUNTRY_NAME");
                System.out.println("Retrieved country: " + countryName);
                countryDropdown.addItem(countryName);
            } while (resultSet.next());

            resultSet.close();
            statement.close();
            System.out.println("Country dropdown populated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateStateDropdown(String country) {
        try {
            String query = "SELECT distinct state_name FROM countries WHERE country_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();

            stateDropdown.removeAllItems(); // Clear existing items

            while (resultSet.next()) {
                String stateName = resultSet.getString("STATE_NAME");
                stateDropdown.addItem(stateName);
                System.out.println("Added state: " + stateName);
            }

            resultSet.close();
            statement.close();
            System.out.println("State dropdown populated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateCityDropdown(String state) {
        try {
            String query = "SELECT distinct city_name FROM countries WHERE state_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, state);
            ResultSet resultSet = statement.executeQuery();

            cityDropdown.removeAllItems(); // Clear existing items

            while (resultSet.next()) {
                String cityName = resultSet.getString("CITY_NAME");
                cityDropdown.addItem(cityName);
                System.out.println("Added city: " + cityName);
            }

            resultSet.close();
            statement.close();
            System.out.println("City dropdown populated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AWTDatabaseDropdownExample();
    }
}