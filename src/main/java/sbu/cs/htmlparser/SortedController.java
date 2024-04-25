package sbu.cs.htmlparser;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SortedController implements Initializable {
    public static List<Country> countries;

    public static String title;


    @FXML
    private ListView<String> myList;

    @FXML
    private Label myTitle;

    @FXML
    private void returnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/htmlparser/menu-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int i = 0;
        for (Country country : countries) {
            i++;
            myList.getItems().add(country.getName());
        }

        myTitle.setText(title);


        myList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                for (Country country : countries) {
                    if (Objects.equals(country.getName(), newValue)) {
                        InfoController.country = country;
                        break;
                    }
                }

                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sbu/cs/htmlparser/info-view.fxml")));
                    Stage stage = (Stage) myList.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
            }
        });
    }
}
