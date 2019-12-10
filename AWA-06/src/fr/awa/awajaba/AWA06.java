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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.awa.awajaba.modeles.ModeleAwajaba;
import java.awt.event.MouseEvent;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
public class AWA06 extends Application {
    
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
        
       
        
        final Spinner<Integer> spinner = new Spinner<Integer>();
       
        int initialValue = m.getEvaluation().getNote();
      
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,initialValue);
        spinner.setValueFactory(valueFactory);
        
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
        root.getChildren().add(spinner);
        
        Label function = new Label("Notation d'une convive :");
        function.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        GridPane.setHalignment(function,HPos.LEFT);
         GridPane.setHalignment(spinner,HPos.LEFT);
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
        
        
        
        
        Label bloque = new Label("Bloque :");
        GridPane.setHalignment(bloque, HPos.RIGHT);
        grid.add(bloque, 0, 3);
        
        CheckBox checkBox = new CheckBox();
        if(m.getEvaluation().isBloque()){
            checkBox.setVisible(true);
        }
        
        grid.add(checkBox, 1, 3);
        
        
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
           m.getEvaluation().setNote(Integer.parseInt(spinner.getValue().toString()));
           m.getEvaluation().setCommentaire(ta.getText());
           m.getEvaluation().setBloque(checkBox.isSelected());
           System.out.println(m.getEvaluation().getNote());
           System.out.println(m.getEvaluation().getCommentaire());
           System.out.println(m.getEvaluation().isBloque());
           
        });
        
        btnr.setOnAction((ActionEvent event) -> {
           // spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5,initialValue));
            spinner.getValueFactory().setValue(m.getEvaluation().getNote());
            ta.clear();
            checkBox.setSelected(m.getEvaluation().isBloque());
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
