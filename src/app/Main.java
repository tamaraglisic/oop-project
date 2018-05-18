package app;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import dao.KorisnikDAO;
import model.Iznajmljivanje;
import model.Korisnik;
import model.Menadzer;
import model.Osoba;
import model.Recepcioner;
import model.Soba;
import model.StavkaCenovnika;
import model.TipSobe;

public class Main {
	
	public static Collection<StavkaCenovnika> cenovnik = new ArrayList<StavkaCenovnika>();
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
	public static Scanner inputScanner = new Scanner(System.in);
	public static Collection<Iznajmljivanje> iznajmljeno = new ArrayList<Iznajmljivanje>();
	
	public static void ucitajCenovnik() throws IOException, ParseException {
		BufferedReader f = new BufferedReader(new FileReader("./cenovnik.txt"));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			Date datumKreiranja = sdf.parse(tokens[0]);
			double dnevniBoravak = Double.parseDouble(tokens[1]);
			double nocenje = Double.parseDouble(tokens[2]);
			double vikendPoskupljenje = Double.parseDouble(tokens[3]);
			String[] tokensTipSobe = tokens[4].split(";");
			TipSobe soba = new TipSobe(tokensTipSobe[0], Integer.parseInt(tokensTipSobe[1]));
			StavkaCenovnika cena = new StavkaCenovnika(datumKreiranja, dnevniBoravak, nocenje, vikendPoskupljenje, soba);
			cenovnik.add(cena);
		}
		f.close();
	}
	
	public static void ucitajIznajmljivanja() throws IOException, ParseException {
		BufferedReader f = new BufferedReader(new FileReader("./iznajmljivanje.txt"));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			Date datumPocetka = sdf.parse(tokens[0]);
			Date datumZavrsetka = sdf.parse(tokens[1]);
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
			iznajmljeno.add(izn);
			
		}
		f.close();
	}
	
	public static void startniMeni() {
		System.out.println("1.");
	}

	public static void main(String[] args) throws IOException, ParseException {
		KorisnikDAO.ucitajKorisnike();
		ucitajCenovnik();
		ucitajIznajmljivanja();
		
		System.out.println("Dobro dosli. Prijava korisnika:\nUnesite korisnicko ime --> ");
	
		String korisnickoIme = inputScanner.nextLine();
		System.out.println("Unesite lozinku --> ");
		String lozinka = inputScanner.nextLine();
		Osoba currentUser = new Osoba();
		
		boolean found = false;
		for (Korisnik user: KorisnikDAO.korisnici){
			if (user.prijava(korisnickoIme, lozinka)){
				found = true;
				currentUser = user;
				break;
			}
		} 
		while (found == false){
			System.out.println("Pogresno korisnicko ime ili lozinka. Pokusajte ponovo --> ");
			korisnickoIme = inputScanner.nextLine();
			System.out.println("Unesite lozinku --> ");
			lozinka = inputScanner.nextLine();
			for (Korisnik user: KorisnikDAO.korisnici){
				if (user.prijava(korisnickoIme, lozinka)){
					found = true;
					currentUser = user;
					break;
				}
			}
			
		}
		
		if (currentUser.getClass().getSimpleName().equalsIgnoreCase("menadzer")){
			Menadzer cu = new Menadzer(currentUser);
			System.out.println("Prijavljeni ste kao MENADZER "+currentUser.getIme() + " " + currentUser.getPrezime());
		}
		else if (currentUser.getClass().getSimpleName().equalsIgnoreCase("recepcioner")) {
			Recepcioner cu = new Recepcioner(currentUser);
			System.out.println("Prijavljeni ste kao RECEPCIONER "+currentUser.getIme()+" "+currentUser.getPrezime());
		}
		System.out.println("\n");
		for (Iznajmljivanje i: iznajmljeno){
			if(i.isActive()){
				System.out.println(i);
			}
		}
		inputScanner.close();
	}

}
