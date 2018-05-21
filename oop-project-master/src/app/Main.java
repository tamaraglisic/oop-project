package app;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import dao.IznajmljivanjeDAO;
import dao.KorisnikDAO;
import dao.RacunDAO;
import dao.SobaDAO;
import dao.StavkaCenovnikaDAO;
import dao.TipSobeDAO;
import model.Korisnik;
import model.Menadzer;




public class Main {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
	public static Scanner inputScanner = new Scanner(System.in);
	
	

	public static void main(String[] args) throws IOException, ParseException {
		
		IznajmljivanjeDAO.ucitajIznajmljivanja();
		StavkaCenovnikaDAO.ucitajCenovnik();
		KorisnikDAO.ucitajKorisnike();
		RacunDAO.ucitajRacune();
		SobaDAO.ucitajSobe();
		TipSobeDAO.ucitajTipSobe();
		while (true) {
			Korisnik currentUser = Menu.start();

			if (currentUser instanceof Menadzer){
				System.out.println("Prijavljeni ste kao MENADZER "+currentUser.getIme() + " " + currentUser.getPrezime());
			}
			else {
				System.out.println("Prijavljeni ste kao RECEPCIONER "+currentUser.getIme()+" "+currentUser.getPrezime());
				Handle.openRecepcioner(currentUser);
			}
		}

	}

}
