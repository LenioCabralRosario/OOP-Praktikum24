package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import business.Autovermietung;

public class ConcreteTXTReaderProduct extends ReaderProduct {
	
	BufferedReader br;
	
	public ConcreteTXTReaderProduct() throws IOException {
		br = new BufferedReader(new FileReader("Autovermietungen.txt"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] result = new String[5];
		String line = br.readLine();
		int i = 0;
		while(i < result.length) {
			result[i++] = line;
			line = br.readLine();
		}
		return result;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}

}
