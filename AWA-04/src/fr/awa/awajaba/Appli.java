/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Pair;

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
            
        //    @Override
        //    public void handle(ActionEvent event) {
       //         System.out.println("Hello World!");
      //      }
      //  });
        
    //    StackPane root = new StackPane();
     //   root.getChildren().add(btn);
        
     //   Scene scene = new Scene(root, 300, 250);
        
     //   primaryStage.setTitle("Hello World!");
      //  primaryStage.setScene(scene);
      //  primaryStage.show();
        
        

        // Set the button types.
        

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setMinSize(400, 200); 

       //Setting the padding  
        grid.setPadding(new Insets(10, 10, 10, 10)); 

       //Setting the vertical and horizontal gaps between the columns 
        grid.setVgap(5); 
        grid.setHgap(5);       

       //Setting the Grid alignment 
       grid.setAlignment(Pos.CENTER); 

       //Arranging all the nodes in the grid 
   
        
        
        
        
        
        
       

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        Button loginBtn = new Button("Login");
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(username.getText().equals("admin") && password.getText().equals("azerty") ){
                    Alert dlgOK = new Alert(AlertType.CONFIRMATION);
                    dlgOK.setTitle("Authentification");
                    dlgOK.setHeaderText("L'authentification avec success...");
                    dlgOK.setContentText(username.getText()+" est bien Connecter...");
                    dlgOK.showAndWait();
                    
                }
                else{
                    Alert dlgOK = new Alert(AlertType.ERROR);
                    dlgOK.setTitle("Authentification");
                    dlgOK.setHeaderText("Echec à l'authentification");
                    dlgOK.setContentText("Nom de connexion ou mot de Passe Incorrect!!");
                    dlgOK.showAndWait();
                    username.clear();
                    password.clear();
                }
            }
        });
       
        
        Button CBtn = new Button("annuler");
        CBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                username.clear();
                password.clear();
            }
            
        });
        
        
        grid.add(loginBtn ,0, 2);
        grid.add(CBtn ,1, 2);
        
        Scene scene = new Scene(grid);
        
        primaryStage.setTitle("Login");
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
