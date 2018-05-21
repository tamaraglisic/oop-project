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
import komparatori.IznajmljivanjeKomparator;
import model.Iznajmljivanje;
import model.Osoba;
import model.Soba;
import model.TipSobe;



public class IznajmljivanjeDAO {
	
	
	public static HashMap<String, Iznajmljivanje> iznajmljeno = new HashMap<String, Iznajmljivanje>();
	public static String filePath = "./iznajmljivanje.txt";
	
	public static void ucitajIznajmljivanja() throws IOException, ParseException {
		BufferedReader f = new BufferedReader(new FileReader(filePath));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			Date datumPocetka = Main.sdf.parse(tokens[0]);
			Date datumZavrsetka = Main.sdf.parse(tokens[1]);
			String[] soba = tokens[2].split(";");
			String broj = soba[0];
			boolean tv = Boolean.parseBoolean(soba[1]);
			boolean miniBar = Boolean.parseBoolean(soba[2]);
			String[] tipSobe = soba[3].split("#");
			String naziv = tipSobe[0];
			int brojKreveta = Integer.parseInt(tipSobe[1]);
			TipSobe tip = new TipSobe(naziv, brojKreveta);
			Soba s = new Soba(broj, tv, miniBar, tip);
			Collection<Osoba> gosti = new ArrayList<Osoba>();
			String[] osobe = tokens[3].split(";");
			
			for (int i = 0; i < osobe.length; i++) {
				String[] podaci = osobe[i].split("#");
				String ime = podaci[0];
				String prezime = podaci[1];
				String brLicneKarte = podaci[2];
				Osoba g = new Osoba(ime, prezime, brLicneKarte);
				gosti.add(g);
			}
			boolean active = Boolean.parseBoolean(tokens[4]);
			Iznajmljivanje izn = new Iznajmljivanje(datumPocetka, datumZavrsetka, s, gosti, active);
			String iznID = Main.sdf.format(datumPocetka) +s.getBroj();
			iznajmljeno.put(iznID, izn);
			
		}
		f.close();
	}

	public static void upisiIznajmljivanje(Iznajmljivanje i) throws IOException {
		
		PrintWriter prw = new PrintWriter(new FileWriter(filePath, true));
		String upis = Main.sdf.format(i.getDatumPocetka()) + "|" + Main.sdf.format(i.getDatumZavrsetka()) +"|"
					+i.getSoba().getBroj() + ";" + i.getSoba().isTv() + ";"+ i.getSoba().isMiniBar() + ";"
					+ i.getSoba().getTip().getNaziv() + "#" + i.getSoba().getTip().getBrKreveta() + "|";
		for (Osoba o: i.getGosti()) {
			if (i.getGosti().toArray()[i.getGosti().size() - 1] == o) { //ako je poslednja osoba ne dodaje ";" na kraj
				upis += o.getIme() + "#" + o.getPrezime() + "#" + o.getBrLicneKarte();
			}else {
				upis += o.getIme() + "#" + o.getPrezime() + "#" + o.getBrLicneKarte() + ";";
			}
			
		}
		upis += "|" + i.isActive();
		prw.println(upis);
		prw.flush();
		prw.close();
	}

	public static void sortBrSobe() {
		Collection<Iznajmljivanje> values = iznajmljeno.values();
		ArrayList<Iznajmljivanje> listValues = new ArrayList<Iznajmljivanje>();
		for (Iznajmljivanje i: values) {
			listValues.add(i);
		}
		Collections.sort(listValues, new IznajmljivanjeKomparator("brSobe"));
		for (Iznajmljivanje i: listValues) {
			if (i.isActive()) {
				System.out.println(i);
			}
		}
	}
	public static void sortTipSobe() {
		Collection<Iznajmljivanje> values = iznajmljeno.values();
		ArrayList<Iznajmljivanje> listValues = new ArrayList<Iznajmljivanje>();
		for (Iznajmljivanje i: values) {
			listValues.add(i);
		}
		Collections.sort(listValues, new IznajmljivanjeKomparator("tipSobe"));
		for (Iznajmljivanje i: listValues) {
			if (i.isActive()) {
				System.out.println(i);
			}
		}
	}
	public static void sortDatumPocetka() {
		Collection<Iznajmljivanje> values = iznajmljeno.values();
		ArrayList<Iznajmljivanje> listValues = new ArrayList<Iznajmljivanje>();
		for (Iznajmljivanje i: values) {
			listValues.add(i);
		}
		Collections.sort(listValues, new IznajmljivanjeKomparator("datumPocetka"));
		for (Iznajmljivanje i: listValues) {
			if (i.isActive()) {
				System.out.println(i);
			}
		}
	}
	public static void sortDatumZavrsetka() {
		Collection<Iznajmljivanje> values = iznajmljeno.values();
		ArrayList<Iznajmljivanje> listValues = new ArrayList<Iznajmljivanje>();
		for (Iznajmljivanje i: values) {
			listValues.add(i);
		}
		Collections.sort(listValues, new IznajmljivanjeKomparator("datumZavrsetka"));
		for (Iznajmljivanje i: listValues) {
			if (i.isActive()) {
				System.out.println(i);
			}
		}
	}

}
