package model;

import java.util.Date;

import app.Main;

public class StavkaCenovnika {
	private Date datumKreiranja;
	private double dnevniBoravak;
	private double nocenje;
	private double vikendPoskupljenje;
	private TipSobe tipSobe;
	private boolean active;
	
	
	
	public StavkaCenovnika() {
		super();
	}
	
	public StavkaCenovnika (StavkaCenovnika sc) {
		this.datumKreiranja = sc.datumKreiranja;
		this.dnevniBoravak = sc.dnevniBoravak;
		this.nocenje = sc.nocenje;
		this.vikendPoskupljenje = sc.vikendPoskupljenje;
		this.tipSobe = sc.tipSobe;
		this.active = sc.active;
		
	}
	
	public StavkaCenovnika(Date datumKreiranja, double dnevniBoravak, double nocenje, double vikendPoskupljenje,
			TipSobe tipSobe, boolean active) {
		
		super();
		this.datumKreiranja = datumKreiranja;
		this.dnevniBoravak = dnevniBoravak;
		this.nocenje = nocenje;
		this.vikendPoskupljenje = vikendPoskupljenje;
		this.tipSobe = tipSobe;
		this.active = active;
		
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public double getDnevniBoravak() {
		return dnevniBoravak;
	}
	public void setDnevniBoravak(double dnevniBoravak) {
		this.dnevniBoravak = dnevniBoravak;
	}
	public double getNocenje() {
		return nocenje;
	}
	public void setNocenje(double nocenje) {
		this.nocenje = nocenje;
	}
	public double getVikendPoskupljenje() {
		return vikendPoskupljenje;
	}
	public void setVikendPoskupljenje(double vikendPoskupljenje) {
		this.vikendPoskupljenje = vikendPoskupljenje;
	}
	public TipSobe getTipSobe() {
		return tipSobe;
	}
	public void setTipSobe(TipSobe tipSobe) {
		this.tipSobe = tipSobe;
	}

	@Override
	public String toString() {
		
		return String.format(Main.sdf.format(this.getDatumKreiranja()) + " Dnevni boravak: " + this.getDnevniBoravak() + " Nocenje: " + this.getNocenje()
								+ " Vikend poskupljenje: " + this.getVikendPoskupljenje()  + " tip sobe: " + this.getTipSobe());
	}
	
	
	
	
}
