package model;



public class Korisnik extends Osoba {
	
	private String korisnickoIme;
	private String lozinka;
	private String tipKorisnika;
	
	public Korisnik() {
		super();
		
	}
	
	public Korisnik (String korisnickoIme, String lozinka, String tipKorisnika) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
	}
	
	public Korisnik(String ime, String prezime, String brLicneKarte, String korisnickoIme, String lozinka, String tipKorisnika) {
		super(ime, prezime, brLicneKarte);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
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
	
	public String getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
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
	@Override
	public String toString() {
		return String.format(this.getIme() + " " + this.getPrezime() + " " + this.getKorisnickoIme());
	}
	
}
