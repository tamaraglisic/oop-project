package model;



public class Korisnik extends Osoba {
	
	private String korisnickoIme;
	private String lozinka;
	
	public Korisnik() {
		super();
		
	}
	
	public Korisnik (String korisnickoIme, String lozinka) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}
	
	public Korisnik(String ime, String prezime, String brLicneKarte, String korisnickoIme, String lozinka) {
		super(ime, prezime, brLicneKarte);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public boolean prijava(String korisnickoIme, String lozinka){
		if (this.getKorisnickoIme().equals(korisnickoIme) && 
			this.getLozinka().equals(lozinka)) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
}
