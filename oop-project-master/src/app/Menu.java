package app;

import java.util.Scanner;


import dao.KorisnikDAO;
import model.Korisnik;

public class Menu {
	
	public static Scanner inputScanner = new Scanner(System.in);

	
	public static Korisnik start() {
		System.out.println("Dobro dosli. Prijava korisnika:\n"
							+ "0 za izlaz\n"
							+ "Unesite korisnicko ime --> ");
		
		String korisnickoIme = inputScanner.nextLine();
		if (korisnickoIme.equals("0")) {
			System.exit(0);
		}
		System.out.println("Unesite lozinku --> ");
		String lozinka = inputScanner.nextLine();
		Korisnik currentUser = new Korisnik();
		
		boolean found = false;
		for (Korisnik user: KorisnikDAO.korisnici){
			if (user.prijava(korisnickoIme, lozinka)){
				found = true;
				currentUser = user;
				break;
			}
		} 
		while (found == false){
			System.out.println("Pogresno korisnicko ime ili lozinka. Pokusajte ponovo \n0 za izlaz --> ");
			korisnickoIme = inputScanner.nextLine();
			if (korisnickoIme.equals("0")) {
				System.exit(0);
			}
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
		return currentUser;
		
	}
	
	public static void recepcionerMenu() {
		
		System.out.println("1. Iznajmljivanje sobe\n"
							+ "2. Izdavanje racuna\n"
							+ "3. Pretraga\n"
							+ "4. Sortiranje\n"
							+ "5. Aktuelni cenovnik\n"
							+ "0. Odjava\n");
	}
	
	public static void pretragaMenu() {
		
		System.out.println("1. Pretraga soba\n"
							+ "2. Pretraga iznajmljivanja\n"
							+ "3. Pretraga racuna\n"
							+ "4. Pretraga osoba\n"
							+ "0. Nazad");
	}
	
	
	public static void pretragaSoba() {
		System.out.println("1. Slobodne/Zauzete sobe\n"
							+ "2. Pretraga po broju sobe\n"
							+ "3. Pretraga po sadrzaju (TV/minibar)"
							+ "0. Nazad");
	}
	
	public static void pretragaIznajmljivanja() {
		System.out.println("1. Pretraga po broju sobe\n"
							+ "2. Pretraga po datumu pocetka\n"
							+ "3. Pretraga po datumu zavrsetka\n"
							+ "4. Pretraga po opsegu datuma\n"
							+ "5. Pretraga po broju licne karte gosta\n"
							+ "0. Nazad");
	}
	
	public static void pretragaRacuna() {
		System.out.println("1. Pretraga po datumu izdavanja\n"
							+ "2. Pretraga po opsegu datuma\n"
							+ "3. Pretraga po placenom iznosu\n"
							+ "4. Pretraga po placenom iznosu u opsegu\n"
							+ "5. Pretraga po broju sobe\n"
							+ "6. Pretraga po tipu sobe\n"
							+ "7. Pretraga po imenu i prezimenu platioca\n"
							+ "0. Nazad");
	}
	
	public static void pretragaKorisnika() {
		System.out.println("1. Pretraga po imenu i prezimenu\n"
							+ "2. Pretraga po korisnickom imenu\n"
							+ "0. Nazad");
	}
	
	public static void pretragaOsoba() {
		System.out.println("1. Pretraga po imenu i prezimenu\n"
							+ "2. Pretraga po broju licne karte\n"
							+ "0. Nazad");
	}
	
	public static void sortMenu() {
		System.out.println("1. Sortiranje iznajmljivanja\n"
							+ "2. Sortiranje racuna\n"
							+ "3. Sortiranje soba\n"
							+ "4. Sortiranje tipova soba\n"
							+ "0. Nazad");
	}
	
	public static void sortIznajmljivanja() {
		System.out.println("1. Sortiranje po  broju sobe\n"
							+ "2. Sortiranje po tipu sobe\n"
							+ "3. Sortiranje po tipu iznajmljivanja\n"
							+ "4. Sortiranje po datumu pocetka\n"
							+ "5. Sortiranje po datumu zavrsetka\n"
							+ "6. Sortiranje po broju sobe i datumu pocetka\n"
							+ "7. Sortiranje po broju sobe i datumu zavrsetka\n"
							+ "0. Nazad");
	}
	
	public static void sortRacuna() {
		System.out.println("1. Sortiranje po datumu izdavanja\n"
							+ "2. Sortiranje po placenom iznosu\n"
							+ "3. Sortiranje po broju sobe\n"
							+ "4. Sortiranje po tipu sobe\n"
							+ "5. Sortiranje po imenu i prezimenu platioca\n"
							+ "0. Nazad");
	}
	
	public static void sortSoba() {
		System.out.println("1. Sortiranje po broju sobe\n"
							+ "2. Sortiranje po tipu sobe\n"
							+ "0. Nazad");
	}
	
	public static void sortTipSoba() {
		System.out.println("1. Sortiranje po nazivu\n"
							+ "2. Sortiranje po broju kreveta\n"
							+ "3. Sortiranje po nazivu i broju kreveta\n"
							+ "0. Nazad");
	}
	
	public static void sortKorisnika() {
		System.out.println("1. Sortiranje po imenu i prezimenu\n"
							+ "2. Sortiranje po korisnickom imenu\n"
							+ "3. Sortiranje po tipu korisnika\n"
							+ "0. Nazad");
	}

}
