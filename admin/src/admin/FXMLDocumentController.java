/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    TextField username1 = new TextField();
    @FXML
    PasswordField password1 = new PasswordField();
    @FXML
    Button exit1 = new Button();
    @FXML
    Button backsub = new Button();

    @FXML
    Button reset = new Button();
    @FXML
    Button login = new Button();

    @FXML
    Label lbl1 = new Label();
    @FXML
    Button logout = new Button();
    @FXML
    Button backreq = new Button();
    @FXML
    Button newsub = new Button();
    @FXML
    Button bloodreq = new Button();
    @FXML
    Button search = new Button();

    @FXML
    private void log_in(ActionEvent event) throws IOException {

        String s1 = username1.getText();
        String s2 = password1.getText();
        s1.trim();
        s2.trim();
        Stage stage;
        Parent root;

        boolean flag1 = false;

        if (event.getSource() == login) {
            if (s1.equalsIgnoreCase("admin") & s2.equalsIgnoreCase("1234")) {
                flag1 = true;
            } else {

                lbl1.setText("Wrong user name or password");
                username1.clear();
                password1.clear();
            }
        }
        if (flag1) {

            stage = (Stage) login.getScene().getWindow();

            root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void reseting(ActionEvent event) {

        lbl1.setText("Reseted");
        username1.clear();
        password1.clear();

    }

    @FXML
    private void searching(ActionEvent event) {

    }

    @FXML
    private void new_sub(ActionEvent event) throws IOException {
        Stage stage = (Stage) newsub.getScene().getWindow();
        Scene scene = new Scene(new Group());
        stage.setWidth(800);
        stage.setHeight(600);

        final ToggleGroup group = new ToggleGroup();
        RadioButton[] gridButtons = new RadioButton[4];
        for (int i = 0; i < 4; i++) {
            gridButtons[i] = new RadioButton();
            gridButtons[i].setToggleGroup(group);
            gridButtons[i].setUserData("A");
        }

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    System.out.println(group.getSelectedToggle().getUserData().toString());
                }
            }
        });

        HBox hbox = new HBox();
        VBox vbox = new VBox();
        for (int i = 0; i < 4; i++) {
            vbox.getChildren().add(gridButtons[i]);
        }

        vbox.setSpacing(10);

        hbox.getChildren().add(vbox);
        hbox.setSpacing(50);
        hbox.setPadding(new Insets(20, 10, 10, 20));

        ((Group) scene.getRoot()).getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
//       Stage primaryStage =(Stage) newsub.getScene().getWindow();
//           HBox hbox = new HBox();
//    VBox vbox = new VBox();
//        GridPane mainGrid= new GridPane();
//       RadioButton[] gridButtons = new RadioButton[4];
//    for(int i=0; i<4; i++) {
//       
//            gridButtons[i] = new RadioButton();
//            vbox.getChildren().add(gridButtons[i]);
//            
//            gridButtons[i].setText("1000");
//            gridButtons[i].minWidth(100.0);
//            gridButtons[i].setMnemonicParsing(false);
//            gridButtons[i].prefHeight(38.0);
//            gridButtons[i].prefWidth(100.0);
//            gridButtons[i].setTextAlignment(TextAlignment.CENTER);
//        }
//    
//         vbox.setSpacing(10);
//            hbox.setSpacing(50);
//    hbox.setPadding(new Insets(20, 10, 10, 20));
//        StackPane root = new StackPane();
//        root.getChildren().addAll(hbox);
//        
//        Scene scene = new Scene(root, 800, 600);
//     
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        
    }

    @FXML
    private void blood_req(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        if (event.getSource() == bloodreq) {
            //get reference to the button's stage         
            stage = (Stage) bloodreq.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Bloodrequest.fxml"));
        } else {
            stage = (Stage) backreq.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void loggingout(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == logout) {

            stage = (Stage) logout.getScene().getWindow();

            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        //create a new scene with root and set the stage
    }

    @FXML
    private void exiting(ActionEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
