/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
/**
 *
 * @author user2
 */
class browser extends Pane {

        browser() {
            WebView view = new WebView();
            WebEngine engine = view.getEngine();
            TextField txt = new TextField();
            Button bt = new Button("Go");
            GridPane gridPane = new GridPane();
            gridPane.setConstraints(txt, 1, 0, 17, 2);
            gridPane.getChildren().add(txt);
            gridPane.setConstraints(bt,18,0);
            //GridPane.setConstraints(bt, 1, 2, 20, 20);
            gridPane.getChildren().add(bt);
            gridPane.setConstraints(view, 2, 2, 10, 10);
            
            
            gridPane.getChildren().add(view);
            getChildren().add(gridPane);
            EventHandler<ActionEvent> enter = new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent event) {
                    engine.load(txt.getText().startsWith("http://") ? txt.getText() :
                            "http://" + txt.getText());
                }
            };
            bt.setOnAction(enter);
            txt.setOnAction(enter);
          
        }
    }
public class Web extends Application {

  
     @Override public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        root=new browser();
        stage.setScene(new Scene(root, 1024, 768));
        root.setStyle("-fx-background-color: #000000;");
        stage.show();
        
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}
