package main;

import guiAutovermietungen.AutovermietungControl;
import guiAutovermietungen.AutovermietungView;
import guiAutovermietungen.FahrzeuguebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new AutovermietungControl(primaryStage);
		Stage fensterFahrzeuguebersicht = new Stage();
		new FahrzeuguebersichtControl(fensterFahrzeuguebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
