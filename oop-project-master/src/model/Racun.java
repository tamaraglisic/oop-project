package model;

import java.util.Date;

import app.Main;

public class Racun {
	
	private Date datumIzdavanja;
	private double cena;
	private Osoba platilac;
	private Iznajmljivanje izn;
	
	
	public Racun() {
		super();
	}
	
	public Racun(Racun r) {
		this.datumIzdavanja = r.datumIzdavanja;
		this.cena = r.cena;
		this.platilac = r.platilac;
		this.izn = r.izn;
	}
	
	public Racun(Date datumIzdavanja,double cena, String ime, String prezime, String brLicneKarte, Iznajmljivanje izn ) {
		this.datumIzdavanja = datumIzdavanja;
		this.cena = cena;
		this.platilac = new Osoba(ime, prezime, brLicneKarte);
		this.izn = izn;

	}
	
	public Racun(Date datumIzdavanja, double cena, Osoba platilac, Iznajmljivanje izn) {
		super();
		this.datumIzdavanja = datumIzdavanja;
		this.cena = cena;
		this.platilac = platilac;
		this.izn = izn;
		
	}
	public Date getDatumIzdavanja() {
		return datumIzdavanja;
	}
	public void setDatumIzdavanja(Date datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}
	
	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Osoba getPlatilac() {
		return platilac;
	}
	public void setPlatilac(Osoba platilac) {
		this.platilac = platilac;
	}

	public Iznajmljivanje getIzn() {
		return izn;
	}

	public void setIzn(Iznajmljivanje izn) {
		this.izn = izn;
	}

	@Override
	public String toString() {
		return String.format(Main.sdf.format(this.getDatumIzdavanja()) + " " + this.getCena() + " " + this.getPlatilac()) + " " + this.getIzn();
	}
	
	

}
