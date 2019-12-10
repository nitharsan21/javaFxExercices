/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba;

import com.awa.awajaba.modeles.ModeleAwajaba;
import com.awa.awajaba.entites.Repas;
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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    public Boolean isSelectedRB(List<RadioButton> l){
        return true;
    }
     
    
    public Scene ListRStage(List<Repas> r, Scene scene1,Stage primaryStage) {
    
        TableView tableView = new TableView();

        TableColumn<LocalDate, Repas> date = new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Boolean, Repas> soir = new TableColumn<>("Soir");
        soir.setCellValueFactory(new PropertyValueFactory<>("soir"));
       
        TableColumn<String, Repas> specialite = new TableColumn<>("Specialite");
        specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        
        TableColumn<Integer, Repas> nbc = new TableColumn<>("nbCouverts");
        nbc.setCellValueFactory(new PropertyValueFactory<>("nbCouvert"));
        
        TableColumn<Boolean, Repas> bio = new TableColumn<>("Bio");
        bio.setCellValueFactory(new PropertyValueFactory<>("bio"));
        
        TableColumn<Boolean, Repas> vegen = new TableColumn<>("Vegen");
        vegen.setCellValueFactory(new PropertyValueFactory<>("vegen"));
        
        TableColumn<Integer, Repas> paf = new TableColumn<>("Prix");
        paf.setCellValueFactory(new PropertyValueFactory<>("paf"));
        
        
        
        tableView.getColumns().add(date);
        tableView.getColumns().add(soir);
        tableView.getColumns().add(specialite);
        tableView.getColumns().add(nbc);
        tableView.getColumns().add(bio);
        tableView.getColumns().add(vegen);
        tableView.getColumns().add(paf);
        
       
        ObservableList<Repas> list = FXCollections.observableArrayList(r);
        tableView.setItems(list);
        
        
        Button retour = new Button("Retour");
        retour.setOnAction((ActionEvent event)->{
                primaryStage.setTitle("Repas!");
                primaryStage.setScene(scene1);
                primaryStage.show();
            
        });

        VBox vbox = new VBox();
        vbox.getChildren().add(tableView);
        vbox.getChildren().add(retour);
        
        Scene scene = new Scene(vbox, 500, 400);
      

       return scene;        
       
       
       
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        List<Repas> repas = new ArrayList<Repas>();
        
        ModeleAwajaba m = ModeleAwajaba.getModele();
       
        GridPane grid = new GridPane();
        
        //Setting the padding  
        grid.setPadding(new Insets(10, 10, 10, 10)); 

       //Setting the vertical and horizontal gaps between the columns 
        grid.setVgap(10); 
        grid.setHgap(10);    
        
        
        Label function = new Label("Programmation d'un Repas :");
        function.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        
        Label date = new Label("Date :");
        GridPane.setHalignment(date, HPos.RIGHT);
        grid.add(date,0,0);
        
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now().plusDays(1));
        datePicker.setShowWeekNumbers(true);
        datePicker.setDayCellFactory(d ->
           new DateCell() {
               @Override public void updateItem(LocalDate item, boolean empty) {
                   super.updateItem(item, empty);
                   setDisable(item.isAfter(LocalDate.MAX) || item.isBefore(LocalDate.now()));
               }});
        
        grid.add(datePicker,1,0);
        
        Label journee = new Label("Journée :");
        GridPane.setHalignment(journee, HPos.RIGHT);
        grid.add(journee,0,1);
        
        ToggleGroup group = new ToggleGroup();
        
        RadioButton rbm = new RadioButton("Matin");
        rbm.setUserData("matin");
        rbm.setToggleGroup(group);
        RadioButton rbs = new RadioButton("Soir");
        rbs.setUserData("soir");
        rbs.setToggleGroup(group);
        
        if(m.getRepas().isSoir()){
            rbs.setSelected(true);
            
        }
        else{
            rbm.setSelected(true);
        }
        
        HBox h1 = new HBox();
        h1.setPadding(new Insets(10));
        h1.setSpacing(10);
        h1.getChildren().addAll(rbm,rbs);
            
        grid.add(h1,1,1);
        
        
        Label specialite = new Label("Specialite :");
        GridPane.setHalignment(specialite, HPos.RIGHT);
        grid.add(specialite,0,2);
        
        ComboBox<String> comboBox = new ComboBox<String>();
        ObservableList<String> list = FXCollections.observableArrayList("Régionale","Orientale","Asiatique","Africane");
        comboBox.setItems(list);
        //comboBox.getSelectionModel().select(1);
        grid.add(comboBox,1,2);
        
        
        
        Label nbCouverts = new Label("NbCouverts :");
        GridPane.setHalignment(nbCouverts, HPos.RIGHT);
        grid.add(nbCouverts,0,3);
        
        final Spinner<Integer> spinner = new Spinner<Integer>();
       
        int initialValue = m.getRepas().getNbCouvert();
      
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,50,initialValue);
        spinner.setValueFactory(valueFactory);
        grid.add(spinner,1,3);
        
        Label bio = new Label("Bio :");
        GridPane.setHalignment(bio, HPos.RIGHT);
        grid.add(bio,0,4);
        
        CheckBox checkBoxBio = new CheckBox();
        if(m.getRepas().isBio()){
            checkBoxBio.setSelected(true);
        }
        
        grid.add(checkBoxBio, 1, 4);
        
        Label vegan = new Label("Vegan :");
        GridPane.setHalignment(vegan, HPos.RIGHT);
        grid.add(vegan,0,5);
        
        CheckBox checkBoxVegan = new CheckBox();
        if(m.getRepas().isVegen()){
            checkBoxVegan.setSelected(true);
        }
        
        grid.add(checkBoxVegan, 1, 5);
        
        
        Label paf = new Label("Frais(€) :");
        GridPane.setHalignment(paf, HPos.RIGHT);
        grid.add(paf,0,6);
        
        TextField fieldtextPAF = new TextField();
        
        fieldtextPAF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    fieldtextPAF.setText(oldValue);
                }
            }
        });
        fieldtextPAF.setText(String.valueOf(m.getRepas().getPaf()));
        grid.add(fieldtextPAF,1,6);
        
        HBox hboutton = new HBox();
        hboutton.setPadding(new Insets(10));
        hboutton.setSpacing(15);
        
        BooleanBinding bb = new BooleanBinding() {
        {
        super.bind(
                comboBox.valueProperty());
        }

            @Override
            protected boolean computeValue() {
                if(comboBox.getValue() == null){
                    return true;
                }
                return false;
                        
            }
        };
        
        
        Button valider = new Button("Valider");
        valider.disableProperty().bind(bb);
        
         valider.setOnAction((ActionEvent event) -> {
                Repas r = new Repas();
                
                r.setBio(checkBoxBio.isSelected());
                r.setDate(datePicker.getValue());
                r.setNbCouvert(spinner.getValue());
                r.setPaf(Integer.valueOf(fieldtextPAF.getText()));
                if(group.getSelectedToggle().getUserData() == "soir"){
                    r.setSoir(true);
                }
                else{
                    r.setSoir(false);
                }
                r.setSpecialite(comboBox.getValue());
                r.setVegen(checkBoxVegan.isSelected());
            
                System.out.println(r.toString());
                System.out.println();
                
                repas.add(r);
                r = null;
                
            
        });
        
        
        Button reset = new Button("Ré-initialiser");
        valider.setAlignment(Pos.CENTER_LEFT);
        reset.setAlignment(Pos.CENTER_RIGHT);
        hboutton.getChildren().addAll(valider,reset);
        
        reset.setOnAction((ActionEvent event) -> {
           
            checkBoxBio.setSelected(m.getRepas().isBio());
            checkBoxVegan.setSelected(m.getRepas().isVegen());
            datePicker.setValue(LocalDate.now().plusDays(1));
            SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,50,m.getRepas().getNbCouvert());
            spinner.setValueFactory(valueFactory1);
            fieldtextPAF.setText(String.valueOf(m.getRepas().getPaf()));
           
            if(m.getRepas().isSoir()){
                rbs.setSelected(true);

            }
            else{
                rbm.setSelected(true);
            }
            comboBox.setValue(null);
           
          
        });
        
        
        Button listB = new Button("Lists des Reservation");
        HBox Rhbox = new HBox();

        Rhbox.getChildren().add(listB);
        
       
        
        VBox Vbox = new VBox();
        Vbox.setPadding(new Insets(10));
        Vbox.setSpacing(10);
        
        Vbox.getChildren().add(function);
        Vbox.getChildren().add(grid);
        Vbox.getChildren().add(hboutton);
        Vbox.getChildren().add(Rhbox);
        Scene scene = new Scene(Vbox, 400, 500);
        
        
        listB.setOnAction((ActionEvent event) -> {
                primaryStage.setTitle("Lists des Reservation");
                primaryStage.setScene(ListRStage(repas, scene,primaryStage));
                primaryStage.show();
            
           
            
        });
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
