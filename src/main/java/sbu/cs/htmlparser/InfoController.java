package sbu.cs.htmlparser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InfoController {
    public static Country country;

    @FXML
    private Label countryArea;

    @FXML
    private Label countryCapital;

    @FXML
    private Label countryName;

    @FXML
    private Label countryPopulation;

    @FXML
    private void returnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/htmlparser/sorted-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    public void setCountry() {
        countryName.setText(country.getName());
        countryCapital.setText(country.getCapital());
        countryArea.setText("" + country.getArea());
        countryPopulation.setText("" + country.getPopulation());
    }

}
