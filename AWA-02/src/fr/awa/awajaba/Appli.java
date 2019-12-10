/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author developpeur
 */
public class Appli extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Button btn = new Button();
       // btn.setText("Say 'Hello World'");
       // btn.setOnAction(new EventHandler<ActionEvent>() {
            
       //     @Override
        //    public void handle(ActionEvent event) {
        //        System.out.println("Hello World!");
       //     }
       // });
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        
       // Scene scene = new Scene(root, 300, 250);
        
       // primaryStage.setTitle("Hello World!");
       // primaryStage.setScene(scene);
       // primaryStage.show();
       
       Label lblValuer = new Label("0");
       Button btnInc = new Button("Incrémenter");
       
       btnInc.setOnAction(new EventHandler<ActionEvent>(){
          
          @Override
            public void handle(ActionEvent event) {
                int i = Integer.parseInt(lblValuer.getText()) +1 ;
                lblValuer.setText(String.valueOf(i) );
            }
       });
       

       
       Button btnQuitter = new Button("Quitter");
       
       btnQuitter.setOnAction(new EventHandler<ActionEvent>(){
          
          @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
       });
       
       
       VBox root = new VBox();
       
       root.getChildren().add(lblValuer);
       root.getChildren().add(btnInc);
       root.getChildren().add(btnQuitter);
       
       Scene scene = new Scene(root, 300, 250);
       
       primaryStage.setTitle(" AWA-VBox ");
       primaryStage.setScene(scene);
       primaryStage.show();
               
       
       
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
