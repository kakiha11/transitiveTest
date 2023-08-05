package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UrbanExplorer {

    /** The list of cities */
    private ArrayList<City> cities;

    /** The ListView containing the names of cities */
    private ListView<String> listView;

    /**
     * Constructor for the UrbanExplorer class.
     * Initializes an ArrayList of City objects, and a ListView for displaying city names.
     */
    public UrbanExplorer() {
        cities = new ArrayList<City>();
        listView = new ListView<String>();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage, and shows the main scene on the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("Urban Explorer");
        showMainScene(primaryStage);
    }

    /**
     * Displays the main scene of the application.
     * It sets up the layout, scene, and stage, and then displays the stage.
     *
     * @param primaryStage The primary stage on which the scene is set and shown.
     */
    public void showMainScene(Stage primaryStage) {
        TextField inputField = new TextField();
        Button addButton = new Button("Add City");
        addButton.setOnAction(event -> addCity(inputField));

        VBox layout = new VBox(10, inputField, addButton, listView);
        Scene mainScene = new Scene(layout, 300, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Adds a new city to the list of cities.
     * It first retrieves the city name from the provided TextField input.
     * If the input is not empty, it creates a new City object with the
     * input as the city name, adds it to the cities list, sorts the list,
     * refreshes the list view, and clears the input field.
     *
     * @param inputField TextField that contains the name of the city to be added.
     */
    public void addCity(TextField inputField) {
        String newCity = inputField.getText();

        if (!newCity.isEmpty()) {
            cities.add(new City(newCity));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the cities in the 'cities' list based on their names.
     */
    public void sortCities() {
        

    }

    /**
     * Refreshes the list of cities displayed in the listView.
     * It first clears the current items in the listView, then iterates over
     * the 'cities' list, adding the name of each city to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (City city : cities) {
            listView.getItems().add(city.getName());
        }
    }

}
