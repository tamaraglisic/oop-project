package model;

import java.util.Collection;
import java.util.Date;

import app.Main;

public class Iznajmljivanje {
	
	private Date datumPocetka;
	private Date datumZavrsetka;
	private Soba soba;
	private Collection<Osoba> gosti;
	private boolean active;
	
	public Iznajmljivanje() {
		super();
	}
	
	public Iznajmljivanje(Iznajmljivanje izn) {
		this.datumPocetka = izn.datumPocetka;
		this.datumZavrsetka = izn.datumZavrsetka;
		this.soba = izn.soba;
		this.gosti = izn.gosti;
		this.active = izn.active;
	}
	
	public Iznajmljivanje(Date datumPocetka, Date datumZavrsetka, Soba soba, Collection<Osoba> gosti, boolean active) {
		super();
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.soba = soba;
		this.gosti = gosti;
		this.active = true;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public Date getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(Date datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}
	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public Collection<Osoba> getGosti() {
		return gosti;
	}
	public void setGosti(Collection<Osoba> gosti) {
		this.gosti = gosti;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		String out = Main.sdf.format(this.getDatumPocetka()) + " - " + Main.sdf.format(this.getDatumZavrsetka()) + " " + this.getSoba().getBroj() + " " + this.getSoba().getTip() + "\n";
		for (Osoba o: this.gosti){
			out += "    ";
			out += o + "\n";
		}
		return out;
	}
	
	
	

}
