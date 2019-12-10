/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awa.awajaba;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.awa.awajaba.modeles.ModeleAwajaba;
import java.awt.event.MouseEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/**
 *
 * @author developpeur
 */
public class Appli extends Application {
    
    @Override
    public void start(Stage primaryStage) throws InstantiationException, IllegalAccessException {
        
        ModeleAwajaba m = ModeleAwajaba.getModele();
        
        VBox main1 = new VBox(); 
        main1.setPadding(new Insets(10));
        main1.setSpacing(10);
        Button btnv = new Button();
        btnv.setText("Valider");
        
       
        
        Button btnr = new Button();
        btnr.setText("Annuler");
        
       
        
        
        ToggleGroup group = new ToggleGroup();
        RadioButton rb0 = new RadioButton("0");
        rb0.setToggleGroup(group);
        rb0.setUserData(0);
        rb0.setOnMousePressed((MouseEvent)-> {
          rb0.setSelected(true);
           
        });
        
        
        RadioButton rb1 = new RadioButton("1");
        rb1.setToggleGroup(group);
        rb1.setUserData(1);
        rb1.setOnMousePressed((MouseEvent)-> {
          rb1.setSelected(true);
           
        });

        
        RadioButton rb2 = new RadioButton("2");
        rb2.setToggleGroup(group);
        rb2.setUserData(2);
        rb2.setOnMousePressed((MouseEvent)-> {
          rb1.setSelected(true);
          rb2.setSelected(true);
           
        });
        
       

        RadioButton rb3 = new RadioButton("3");
        rb3.setToggleGroup(group);
        rb3.setUserData(3);
        rb3.setOnMousePressed((MouseEvent)-> {
            rb1.setSelected(true);
            rb2.setSelected(true);
            rb3.setSelected(true);
           
        });
        
        
        RadioButton rb4 = new RadioButton("4");
        rb4.setToggleGroup(group);
        rb4.setUserData(4);
        rb4.setOnMousePressed((MouseEvent)-> {
            rb1.setSelected(true);
            rb2.setSelected(true);
            rb3.setSelected(true);
            rb4.setSelected(true);
           
        });
        
       

        RadioButton rb5 = new RadioButton("5");
        rb5.setToggleGroup(group);
        rb5.setUserData(5);
        rb5.setOnMousePressed((MouseEvent)-> {
            rb1.setSelected(true);
            rb2.setSelected(true);
            rb3.setSelected(true);
            rb4.setSelected(true);
            rb5.setSelected(true);
           
        });
        
       
        
        
         switch (m.getEvalRepas().getNote()) {
             case 1:
                 rb1.setSelected(true);
                 break;
             case 2:
                 rb2.setSelected(true);
                 break;
             case 3:
                rb3.setSelected(true);
                 break; 
             case 4:
                 rb4.setSelected(true);
                 break;
             case 5:
                 rb5.setSelected(true);
                 break;
             default: 
                 rb0.setSelected(true);
                 break;
    
            
         }
        
      //   group.
        
        
        TextArea ta =new TextArea();
                

        GridPane grid = new GridPane();
        grid.setMinSize(400, 200); 

       //Setting the padding  
        grid.setPadding(new Insets(10, 10, 10, 10)); 

       //Setting the vertical and horizontal gaps between the columns 
        grid.setVgap(5); 
        grid.setHgap(5);       

        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(rb0,rb1,rb2,rb3,rb4,rb5);
        
        Label function = new Label("Evaluation de Voter Repas :");
        function.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        GridPane.setHalignment(function,HPos.LEFT);
        HBox h1 = new HBox();
        h1.setPadding(new Insets(10));
        h1.setSpacing(10);
        
        
        Label note = new Label("Note :");

        GridPane.setHalignment(note,HPos.RIGHT);
        
        grid.add(note, 0, 0);
        
        grid.add(root,1,0);
       

        Label commentaire = new Label("Commentaire :");
        GridPane.setHalignment(commentaire, HPos.RIGHT);
        grid.add(commentaire, 0, 1);
        ta.setPrefHeight(50);
        ta.setPrefWidth(300);
        grid.add(ta, 1, 1,2,2); 
        
        VBox root1 = new VBox();
        root1.setPadding(new Insets(15));
        root1.setSpacing(25);
        root1.getChildren().addAll(btnv,btnr);
        
        grid.add(root1, 3,1 );
        
       //Setting the vertical and horizontal gaps between the columns 
        grid.setVgap(25); 
        grid.setHgap(25); 
        
        main1.getChildren().add(function);
        main1.getChildren().add(grid);
        Scene scene = new Scene(main1);
        
        primaryStage.setTitle("Evaluation d'un Repas");
        primaryStage.setScene(scene);
        primaryStage.show();
       
        btnv.setOnAction((ActionEvent event) -> {
           m.getEvalRepas().setNote(Integer.parseInt(group.getSelectedToggle().getUserData().toString()));
           m.getEvalRepas().setCommentaire(ta.getText());
           
           System.out.println(m.getEvalRepas().getNote());
           System.out.println(m.getEvalRepas().getCommentaire());
           
        });
        
        btnr.setOnAction((ActionEvent event) -> {
            group.selectToggle(rb2);
            ta.clear();
        }
        );
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
