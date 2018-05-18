package Motel;

public class TipSobe {
	private String naziv;
	private int brKreveta;
	
	
	
	public TipSobe() {
		super();
	}
	
	public TipSobe(TipSobe s) {
		this.naziv = s.naziv;
		this.brKreveta = s.brKreveta;
	}
	
	public TipSobe(String naziv, int brKreveta) {
		super();
		this.naziv = naziv;
		this.brKreveta = brKreveta;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getBrKreveta() {
		return brKreveta;
	}
	public void setBrKreveta(int brKreveta) {
		this.brKreveta = brKreveta;
	}

	@Override
	public String toString() {
		String out = this.getNaziv();
		return out;
	}
	
	
	
}
