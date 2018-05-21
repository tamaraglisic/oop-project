package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import app.Main;
import komparatori.RacuniKomparator;
import model.Iznajmljivanje;
import model.Racun;

public class RacunDAO {
	
	public static String filePath = "./racuni.txt";
	public static HashMap<String, Racun> racuni = new HashMap<String, Racun>();
	
	
	public static void ucitajRacune() throws IOException, ParseException {
		BufferedReader f = new BufferedReader(new FileReader(filePath));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			Date datumIzdavanja = Main.sdf.parse(tokens[0]);
			double cena = Double.parseDouble(tokens[1]);
			String[] tokensOsoba = tokens[2].split(";");
			String ime = tokensOsoba[0];
			String prezime = tokensOsoba[1];
			String brLicneKarte = tokensOsoba[2];
			String racunId = tokens[3];
			Iznajmljivanje izn = new Iznajmljivanje(IznajmljivanjeDAO.iznajmljeno.get(racunId));
			Racun r = new Racun(datumIzdavanja, cena, ime, prezime, brLicneKarte, izn);
			
			racuni.put(racunId, r);
		}
		f.close();
	}
	
	public static void upisiRacun(Racun r) throws IOException {
		
		PrintWriter prw = new PrintWriter(new FileWriter(filePath, true));
		String upis = Main.sdf.format(r.getDatumIzdavanja()) + "|" + r.getCena() + "|"
					+ r.getPlatilac().getIme() + ";" + r.getPlatilac().getPrezime() + ";"
					+ r.getPlatilac().getBrLicneKarte();
		prw.println(upis);
		
		prw.flush();
		prw.close();
	}
	public static void sortDatumIzdavanja() {
		Collection<Racun> values = racuni.values();
		ArrayList<Racun> listValues = new ArrayList<Racun>();
		for(Racun r: values) {
			listValues.add(r);
		}
		Collections.sort(listValues, new RacuniKomparator("datumIzdavanja"));
		for (Racun r: listValues) {
			System.out.println(r);
		}
	}
	public static void sortPlatilac() {
		Collection<Racun> values = racuni.values();
		ArrayList<Racun> listValues = new ArrayList<Racun>();
		for(Racun r: values) {
			listValues.add(r);
		}
		Collections.sort(listValues, new RacuniKomparator("platilac"));
		for (Racun r: listValues) {
			System.out.println(r);
		}
	}
	public static void sortCena() {
		Collection<Racun> values = racuni.values();
		ArrayList<Racun> listValues = new ArrayList<Racun>();
		for(Racun r: values) {
			listValues.add(r);
		}
		Collections.sort(listValues, new RacuniKomparator("cena"));
		for (Racun r: listValues) {
			System.out.println(r);
		}
	}
	public static void sortBrSobe() {
		Collection<Racun> values = racuni.values();
		ArrayList<Racun> listValues = new ArrayList<Racun>();
		for(Racun r: values) {
			listValues.add(r);
		}
		Collections.sort(listValues, new RacuniKomparator("brSobe"));
		for (Racun r: listValues) {
			System.out.println(r);
		}
	}
	public static void sortTipSobe() {
		Collection<Racun> values = racuni.values();
		ArrayList<Racun> listValues = new ArrayList<Racun>();
		for(Racun r: values) {
			listValues.add(r);
		}
		Collections.sort(listValues, new RacuniKomparator("tipSobe"));
		for (Racun r: listValues) {
			System.out.println(r);
		}
	}

	
}

