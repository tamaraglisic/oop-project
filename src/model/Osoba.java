package model;

public class Osoba {
	
	protected String ime;
	protected String prezime;
	protected String brLicneKarte;
	
	public Osoba() {
		super();
	}
	public Osoba(String ime, String prezime, String brLicneKarte) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brLicneKarte = brLicneKarte;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrLicneKarte() {
		return brLicneKarte;
	}
	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}
	
	
	
	@Override
	public String toString() {
		String out = this.getIme() + " " + this.getPrezime() + " " + this.getBrLicneKarte();
		return out;
	}
	
}
