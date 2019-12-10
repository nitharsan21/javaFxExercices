/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import fr.awa.awajaba.entities.Specialite;
import fr.awa.awajaba.modeles.ModeleAwajaba;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author developpeur
 */
public class Appli extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        List<String> spec = new ArrayList<String>();
        spec.add("Régionale");
        spec.add("Orientale");
        spec.add("Asiatique");
        spec.add("Africaine");
       

        
        ModeleAwajaba m = ModeleAwajaba.getModele();
       
        GridPane grid = new GridPane();
        
        //Setting the padding  
        grid.setPadding(new Insets(10, 10, 10, 10)); 

       //Setting the vertical and horizontal gaps between the columns 
        grid.setVgap(10); 
        grid.setHgap(10);    
        
        
        Label function = new Label("Enregistrement d'un hôte :");
        function.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        
        Label identifiantL = new Label("Identifiant :");
        GridPane.setHalignment(identifiantL, HPos.RIGHT);
        grid.add(identifiantL,0,0);
        
        TextField identifiant = new TextField();
        identifiant.setText(String.valueOf(m.getHote().getIdentifiant()));
        identifiant.setEditable(false);
        grid.add(identifiant,1,0);
        
         
        Label nomL = new Label("Nom :");
        GridPane.setHalignment(nomL, HPos.RIGHT);
        grid.add(nomL,0,1);
        
        TextField nom = new TextField();
        nom.setText(m.getHote().getNom());
        nom.setEditable(false);
        grid.add(nom,1,1);
        
        
        Label prenomL = new Label("Prenom :");
        GridPane.setHalignment(prenomL, HPos.RIGHT);
        grid.add(prenomL,0,2);
        
        TextField prenom = new TextField();
        prenom.setText(m.getHote().getPrenom());
        prenom.setEditable(false);
        grid.add(prenom,1,2);
        
        
        
        Label adresseL = new Label("Email :");
        GridPane.setHalignment(adresseL, HPos.RIGHT);
        grid.add(adresseL,0,3);
        
        TextField adresse = new TextField();
        adresse.setText(m.getHote().getEmail());
        grid.add(adresse,1,3);
        
        Label specialite = new Label("Specialite :");
        GridPane.setHalignment(specialite, HPos.RIGHT);
        grid.add(specialite,0,4);
        
       
        
        
        ObservableList<String> Specialites = FXCollections.observableArrayList((spec));
        
 
        // Create a ListView
        ListView<String> listView = new ListView<String>(Specialites);
 
        // Only allowed to select single row in the ListView.
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
 
       
        
 
        
        grid.add(listView, 1, 4);
        
       
        HBox hboutton = new HBox();
        hboutton.setPadding(new Insets(10));
        hboutton.setSpacing(15);
        
        /*BooleanBinding bb = new BooleanBinding() {
        {
        super.bind(
                comboBox.valueProperty());
        }

            @Override
            protected boolean computeValue() {
                //if(comboBox.getValue() == null){
                    return true;
                }
                //return false;
                        
            }
        };*/
        
        
        Button valider = new Button("Valider");
        //valider.disableProperty().bind(bb);
        
         valider.setOnAction((ActionEvent event) -> {
               m.getHote().setIsHote(true);
               m.getHote().setEmail(adresse.getText());
               for(String i : listView.getSelectionModel().getSelectedItems()){
                   m.getHote().getSpecialites().add(new Specialite(i));
               }
               
               System.out.println(" nom : "+m.getHote().getNom()+", Prenom: "+ m.getHote().getPrenom()+" , Email :"+ m.getHote().getEmail() );
               System.out.println("Specialites :");
              for(Specialite i : m.getHote().getSpecialites()){
                System.out.println(i.getSepecialite());
              }
              System.out.println(m.getHote().toString());
            
        });
        
        
        Button reset = new Button("Ré-initialiser");
        valider.setAlignment(Pos.CENTER_LEFT);
        reset.setAlignment(Pos.CENTER_RIGHT);
        hboutton.getChildren().addAll(valider,reset);
        
        reset.setOnAction((ActionEvent event) -> {
           adresse.setText(m.getHote().getEmail());
           listView.getSelectionModel().clearSelection();
          
        });
        
        

        
        VBox Vbox = new VBox();
        Vbox.setPadding(new Insets(10));
        Vbox.setSpacing(10);
        
        Vbox.getChildren().add(function);
        Vbox.getChildren().add(grid);
        Vbox.getChildren().add(hboutton);
       
        Scene scene = new Scene(Vbox, 400, 500);
        
        primaryStage.setTitle("Repas!");
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
