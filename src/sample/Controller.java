package sample;

import Admin.adminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private loginModel model = new loginModel();
    //import object from scene builder
    @FXML
    private Label dbStatus;
    @FXML
    private Label loginStatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.model.isDatabaseconnecttion()) {
            this.dbStatus.setText("Connect to DB");
        }else{
            this.dbStatus.setText("Not Connect to DB");
        }

    } //initial
    @FXML
    public void Login(ActionEvent event){
        System.out.println(username.getText());
        System.out.println(password.getText());

        try {
            if (this.model.isLogin(username.getText(),password.getText())) {
                Stage stage = (Stage) this.btnLogin.getScene().getWindow();
                stage.close();
                //loginStatus.setText("Welcome to Our System");
                adminDashBoard();
            }else{
                loginStatus.setText("Your username or password is invalid");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    } //Login
    private void adminDashBoard() {
        try {
            Stage adminstage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/admin/adminDashBoard.fxml").openStream());
            adminController admincontroller = new adminController();

            Scene scene = new Scene(root);
            adminstage.setScene(scene);
            adminstage.setResizable(false);
            adminstage.setTitle("DashBoard");
            adminstage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }

} //class
