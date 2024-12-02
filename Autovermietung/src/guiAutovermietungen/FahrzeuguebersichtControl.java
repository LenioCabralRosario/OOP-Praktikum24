package guiAutovermietungen;

import business.AutovermietungModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class FahrzeuguebersichtControl implements Observer {
	

		private FahrzeuguebersichtView fahrzeuguebersichtView;
		private AutovermietungModel autosModel;
		
		public FahrzeuguebersichtControl(Stage primaryStage){
			
	 		this.autosModel = AutovermietungModel.getInstance(null);	
	 		autosModel.observers.add(this);
			this.fahrzeuguebersichtView 
			 	= new FahrzeuguebersichtView(this, primaryStage,
				autosModel);
		}

	
	@Override
	public void update() {
		fahrzeuguebersichtView.zeigeAutosAn();
	}

}
