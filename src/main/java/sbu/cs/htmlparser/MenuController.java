package sbu.cs.htmlparser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    @FXML
    void displaySortedByArea(ActionEvent event) throws IOException {

        SortedController.countries = Parser.sortByArea();
        SortedController.title = "Sorted By Area";
        displaySortedScene(event);


    }

    @FXML
    void displaySortedByName(ActionEvent event) throws IOException {

        SortedController.countries = Parser.sortByName();
        SortedController.title = "Sorted By Name";
        displaySortedScene(event);

    }

    @FXML
    void displaySortedByPopulation(ActionEvent event) throws IOException {

        SortedController.countries = Parser.sortByPopulation();
        SortedController.title = "Sorted By Population";
        displaySortedScene(event);

    }

    void displaySortedScene(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/htmlparser/sorted-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
    }

}
