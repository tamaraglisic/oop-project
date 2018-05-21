package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import komparatori.KorisnikComparator;
import model.Iznajmljivanje;
import model.Korisnik;
import model.Menadzer;
import model.Racun;
import model.Recepcioner;

public class KorisnikDAO {
	
	private static String filePath = "./korisnici.txt";
	public static Collection<Korisnik> korisnici = new ArrayList<Korisnik>();
	
	public static void ucitajKorisnike() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(filePath));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			String ime = tokens[0];
			String prezime = tokens[1];
			String brLicneKarte = tokens[2];
			String korisnickoIme = tokens[3];
			String lozinka = tokens[4];
			String uloga = tokens[5];
			if (uloga.equalsIgnoreCase("menadzer")) {
				Menadzer k = new Menadzer(ime, prezime, brLicneKarte, korisnickoIme, lozinka, uloga);
				korisnici.add(k);
			}else if (uloga.equalsIgnoreCase("recepcioner")) {
				
				Recepcioner k = new Recepcioner(ime, prezime, brLicneKarte, korisnickoIme, lozinka, uloga);
				
				try {
					String[] tokensIzn = tokens[6].split(";");
					for (String iznID: tokensIzn) {
						Iznajmljivanje izn = new Iznajmljivanje(IznajmljivanjeDAO.iznajmljeno.get(iznID));
						k.dodajIznajmljivanje(izn);
					}
				}
				catch (IndexOutOfBoundsException e) {}
				
				try {
					String[] tokensRacun = tokens[7].split(";");
					for (String racunID: tokensRacun) {
						Racun r = new Racun(RacunDAO.racuni.get(racunID));
						k.dodajRacun(r);
					}	
				}
				catch (IndexOutOfBoundsException e) {}
				
				korisnici.add(k);
			}
		}f.close();
	}
	
	public static void sortIme() {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();
		for (Korisnik k: korisnici) {
			lista.add(k);
		}
		Collections.sort(lista, new KorisnikComparator("ime"));
		for (Korisnik k: lista) {
			System.out.println(k);
		}
	}
	public static void sortPrezime() {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();
		for (Korisnik k: korisnici) {
			lista.add(k);
		}
		Collections.sort(lista, new KorisnikComparator("prezime"));
		for (Korisnik k: lista) {
			System.out.println(k);
		}
	}
	
	public static void sortKorisnickoIme() {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();
		for (Korisnik k: korisnici) {
			lista.add(k);
		}
		Collections.sort(lista, new KorisnikComparator("korisnickoIme"));
		for (Korisnik k: lista) {
			System.out.println(k);
		}
	}
	public static void sortTip() {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();
		for (Korisnik k: korisnici) {
			lista.add(k);
		}
		Collections.sort(lista, new KorisnikComparator("tip"));
		for (Korisnik k: lista) {
			System.out.println(k);
		}
	}
}
