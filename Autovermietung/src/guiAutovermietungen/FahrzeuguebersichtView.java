package guiAutovermietungen;

import business.AutovermietungModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class FahrzeuguebersichtView {
	
	private FahrzeuguebersichtControl
 	fahrzeuguebersichtControl;
	private AutovermietungModel autosModel;	
	
	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();
	private Label lblAnzeigeAutos     
	= new Label("Anzeige Autos");
	private TextArea txtAnzeigeAutos  = new TextArea();
	
	private Button btnAnzeigeAutos = new Button("Anzeige");
	//-------Ende Attribute der grafischen Oberflaeche-------

	public FahrzeuguebersichtView(
	FahrzeuguebersichtControl 
	FahrzeuguebersichtControl, 
 	Stage primaryStage, 
	AutovermietungModel autosModel){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Fahrzeugen");
		primaryStage.show();
		this.fahrzeuguebersichtControl 
		= fahrzeuguebersichtControl;
	this.autosModel = autosModel;
	this.initKomponenten();
	this.initListener();
	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeAutos.setLayoutX(310);
    		lblAnzeigeAutos.setLayoutY(40);
    		lblAnzeigeAutos.setFont(font);
    		lblAnzeigeAutos.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeAutos);           
// Textbereich	
        	txtAnzeigeAutos.setEditable(false);
     		txtAnzeigeAutos.setLayoutX(310);
    		txtAnzeigeAutos.setLayoutY(90);
     		txtAnzeigeAutos.setPrefWidth(220);
    		txtAnzeigeAutos.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeAutos);        	
        	// Button
          	btnAnzeigeAutos.setLayoutX(310);
        	btnAnzeigeAutos.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeAutos); 
   }
   
   private void initListener() {
	    btnAnzeigeAutos.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeAutosAn();
	        	} 
   	    });
    }
   
    public void zeigeAutosAn(){
    		if(autosModel.getAv() != null){
    			txtAnzeigeAutos.setText(
    				autosModel.getAv()
 				.gibAutovermietungZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Auto aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}


