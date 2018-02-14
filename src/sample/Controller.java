package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private loginModel model = new loginModel();
    //import object from scene builder
    @FXML
    private Label dbStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.model.isDatabaseconnecttion()) {
            this.dbStatus.setText("Connect to DB");
        }else{
            this.dbStatus.setText("Not Connect to DB");
        }

    }
} //class
