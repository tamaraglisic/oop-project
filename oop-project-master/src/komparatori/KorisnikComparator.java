package komparatori;

import java.util.Comparator;

import model.Korisnik;

public class KorisnikComparator implements Comparator<Korisnik>{
	
	private String parametar;

	
	
	public KorisnikComparator() {
		super();
	}

	public KorisnikComparator(String parametar) {
		super();
		this.parametar = parametar;
	}

	public String getParametar() {
		return parametar;
	}

	public void setParametar(String parametar) {
		this.parametar = parametar;
	}

	@Override
	public int compare(Korisnik k1, Korisnik k2) {
		if (this.getParametar().equals("ime")) {
			String ime1 = k1.getIme();
			String ime2 = k2.getIme();
			return ime1.compareTo(ime2);
		}
		else if (this.getParametar().equals("prezime")) {
			String prezime1 = k1.getPrezime();
			String prezime2 = k2.getPrezime();
			return prezime1.compareTo(prezime2);
			
		}
		else if (this.getParametar().equals("korisnickoIme")) {
			String kIme1 = k1.getKorisnickoIme();
			String kIme2 = k2.getKorisnickoIme();
			return kIme1.compareTo(kIme2);
		}
		else if (this.getParametar().equals("tip")) {
			String tip1 = k1.getTipKorisnika();
			String tip2 = k2.getTipKorisnika();
			return tip1.compareTo(tip2);
		}
		
		
		return 0;
	}
	
	
	
	

}
