package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import app.Main;
import komparatori.CenovnikKomparator;
import model.StavkaCenovnika;
import model.TipSobe;

public class StavkaCenovnikaDAO {
	
	public static Collection<StavkaCenovnika> cenovnik = new ArrayList<StavkaCenovnika>();

	
	public static void ucitajCenovnik() throws IOException, ParseException {
		BufferedReader f = new BufferedReader(new FileReader("./cenovnik.txt"));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			Date datumKreiranja = Main.sdf.parse(tokens[0]);
			double dnevniBoravak = Double.parseDouble(tokens[1]);
			double nocenje = Double.parseDouble(tokens[2]);
			double vikendPoskupljenje = Double.parseDouble(tokens[3]);
			String[] tokensTipSobe = tokens[4].split(";");
			TipSobe soba = new TipSobe(tokensTipSobe[0], Integer.parseInt(tokensTipSobe[1]));
			boolean active = Boolean.parseBoolean(tokens[5]);
			StavkaCenovnika cena = new StavkaCenovnika(datumKreiranja, dnevniBoravak, nocenje, vikendPoskupljenje, soba, active);
			
			cenovnik.add(cena);
		}
		f.close();
	}
	
	public static void sortirajCenovnik() {
		ArrayList<StavkaCenovnika> lista = new ArrayList<StavkaCenovnika>();
		for (StavkaCenovnika s: cenovnik) {
			lista.add(s);
		}
		Collections.sort(lista, new CenovnikKomparator());
	
	}

	public static void aktuelniCenovnik() {
		for (StavkaCenovnika s: cenovnik) {
			if (s.isActive()) {
				System.out.println(s);
			}
		}

	}
}
