package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import business.Autovermietung;

public class ConcreteCSVReaderProduct extends ReaderProduct {
	
	BufferedReader br;
	
	public ConcreteCSVReaderProduct() throws IOException {
		br = new BufferedReader(new FileReader("AutovermietungenAusgabe.csv"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] result = new String[5];
		String line = br.readLine();
		String servicesLine = br.readLine();
		int counter = 0;
		for(String str : line.split(";")) {
			result[counter++] = str;
		}
		result[4] = servicesLine;
		System.out.println(Arrays.toString(result));
		return result;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}

}
