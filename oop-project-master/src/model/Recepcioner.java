package model;

import java.util.ArrayList;

public class Recepcioner extends Korisnik {
	
	private ArrayList<Iznajmljivanje> listaIzn;
	private ArrayList<Racun> listaRacuna;

	public Recepcioner() {
		super();
	}

	public Recepcioner(String ime, String prezime, String brLicneKarte, String korisnickoIme, String lozinka, String tipKorisnika, ArrayList<Iznajmljivanje> listaIzn, ArrayList<Racun> listaRacuna) {
		super(ime, prezime, brLicneKarte, korisnickoIme, lozinka, tipKorisnika);
		this.listaIzn = listaIzn;
		this.listaRacuna = listaRacuna;
	
	}
	public Recepcioner(String ime, String prezime, String brLicneKarte, String korisnickoIme, String lozinka, String tipKorisnika) {
		super(ime, prezime, brLicneKarte, korisnickoIme, lozinka, tipKorisnika);
		this.listaIzn = new ArrayList<Iznajmljivanje>();
		this.listaRacuna = new ArrayList<Racun>();
	}

	public ArrayList<Iznajmljivanje> getListaIzn() {
		return listaIzn;
	}

	public void setListaIzn(ArrayList<Iznajmljivanje> listaIzn) {
		this.listaIzn = listaIzn;
	}

	public ArrayList<Racun> getListaRacuna() {
		return listaRacuna;
	}

	public void setListaRacuna(ArrayList<Racun> listaRacuna) {
		this.listaRacuna = listaRacuna;
	}

	
	
	public void dodajIznajmljivanje (Iznajmljivanje i) {
		this.listaIzn.add(i);
	}
	public void dodajRacun (Racun r) {
		this.listaRacuna.add(r);
	}

	
	

}
