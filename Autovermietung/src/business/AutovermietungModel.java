package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import guiAutovermietungen.AutovermietungControl;
import io.ConcreteCSVReaderCreator;
import io.ConcreteTXTReaderCreator;
import io.ReaderCreator;
import io.ReaderProduct;
import ownUtil.Observable;
import ownUtil.Observer;

public class AutovermietungModel implements Observable {
	
	static AutovermietungControl avc;
	static AutovermietungModel avm;
	public Vector<Observer> observers = new Vector<Observer>();
	Autovermietung av;
	

	private AutovermietungModel(AutovermietungControl autovermietungControl) {
		this.avc = autovermietungControl;
		this.av = null;
	}
	
	public static AutovermietungModel getInstance(AutovermietungControl autovermietungControl) {
		if(avm == null) {
			avm = new AutovermietungModel(avc);
		} 
		return avm;
	}



	public Autovermietung getAv() {
		return av;
	}




	public void setAv(Autovermietung av) {
		this.av = av;
		notifyObservers();
	}



	/*
	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Autovermietungen.csv"));
      			String[] zeile = ein.readLine().split(";");
      			Autovermietung av = new Autovermietung(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				Float.parseFloat(zeile[2]), 
      				zeile[3], zeile[4].split("_"));
      				ein.close();
      				setAv(av);
      				avc.zeigeInformationsfensterAn("Die Autovermietungen wurden gelesen!");      
      		}
       		else{
	   			avc.zeigeInformationsfensterAn("Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			avc.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			avc.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
	*/
	
	public void leseAutovermietungAusDateiTXT() throws IOException {
			ReaderCreator rc = new ConcreteTXTReaderCreator();
			ReaderProduct reader = rc.factoryMethod();
			String[] line = reader.leseAusDatei();
			System.out.println(Arrays.toString(line));
			this.av = new Autovermietung(line[0], Float.parseFloat(line[1]), Float.parseFloat(line[2]), line[3], line[4].split("_"));
			reader.schliesseDatei();
			notifyObservers();
	}
	
	public void leseAutovermietungAusDateiCSV() throws IOException {
			ReaderCreator rc = new ConcreteCSVReaderCreator();
			ReaderProduct reader = rc.factoryMethod();
			String[] line = reader.leseAusDatei();
			System.out.println(Arrays.toString(line));
			this.av = new Autovermietung(line[0], Float.parseFloat(line[1]), Float.parseFloat(line[2]), line[3], line[4].split("_"));
			reader.schliesseDatei();
			notifyObservers();
	}
	
	public void schreibeAutovermietungenInCsvDatei() {
		if(getAv() != null) {
			try {
				System.out.println(getAv().gibAutovermietungZurueck(';'));
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("AutovermietungenAusgabe.csv", true));
				aus.write(av.gibAutovermietungZurueck(';'));
				System.out.println(av.gibAutovermietungZurueck(';'));
				aus.close();
				System.out.println(av.gibAutovermietungZurueck(';'));
	   			avc.zeigeInformationsfensterAn(
		   			"Die Autovermietungen wurden gespeichert!");
			}	
			catch(IOException exc){
				avc.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				System.out.println(exc.getMessage());
				avc.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			} 
			
		} else {
		avc.zeigeFehlermeldungsfensterAn(
				"Die Autovermietung wurde nicht gesetzt");
		}
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update();
		}
	}
	

}
