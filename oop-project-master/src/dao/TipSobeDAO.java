package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import komparatori.TipSobeKomparator;
import model.TipSobe;

public class TipSobeDAO {
	
	public static Collection<TipSobe> tipsobe = new ArrayList<TipSobe>();
	public static String filePath = "./tipsobe.txt";
	
	public static void ucitajTipSobe() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader(filePath));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			String naziv = tokens[0];
			int brojKreveta = Integer.parseInt(tokens[1]);
			TipSobe tipSobe = new TipSobe(naziv, brojKreveta);
			tipsobe.add(tipSobe);
		}
		f.close();
	}
	
	public static void sortNaziv() {
		ArrayList<TipSobe> lista = new ArrayList<TipSobe>();
		for (TipSobe s: tipsobe) {
			lista.add(s);
		}
		Collections.sort(lista, new TipSobeKomparator("naziv"));
		for (TipSobe s: lista) {
			System.out.println(s);
		}
	}
	
	public static void sortBrojKreveta() {
		ArrayList<TipSobe> lista = new ArrayList<TipSobe>();
		for (TipSobe s: tipsobe) {
			lista.add(s);
		}
		Collections.sort(lista, new TipSobeKomparator("brojKreveta"));
		for (TipSobe s: lista) {
			System.out.println(s);
		}
		
	}
	
}
