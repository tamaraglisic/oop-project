package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import model.Korisnik;
import model.Menadzer;
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
				Menadzer k = new Menadzer(ime, prezime, brLicneKarte, korisnickoIme, lozinka);
				korisnici.add(k);
			}else if (uloga.equalsIgnoreCase("recepcioner")) {
				Recepcioner k = new Recepcioner(ime, prezime, brLicneKarte, korisnickoIme, lozinka);
				korisnici.add(k);
			}
		}f.close();
	}

}
