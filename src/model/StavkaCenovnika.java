package model;

import java.util.Date;

public class StavkaCenovnika {
	private Date datumKreiranja;
	private double dnevniBoravak;
	private double nocenje;
	private double vikendPoskupljenje;
	private TipSobe tipSobe;
	
	
	
	public StavkaCenovnika() {
		super();
	}
	
	public StavkaCenovnika (StavkaCenovnika sc) {
		this.datumKreiranja = sc.datumKreiranja;
		this.dnevniBoravak = sc.dnevniBoravak;
		this.nocenje = sc.nocenje;
		this.vikendPoskupljenje = sc.vikendPoskupljenje;
		this.tipSobe = sc.tipSobe;
		
	}
	
	public StavkaCenovnika(Date datumKreiranja, double dnevniBoravak, double nocenje, double vikendPoskupljenje,
			TipSobe tipSobe) {
		super();
		this.datumKreiranja = datumKreiranja;
		this.dnevniBoravak = dnevniBoravak;
		this.nocenje = nocenje;
		this.vikendPoskupljenje = vikendPoskupljenje;
		this.tipSobe = tipSobe;
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
	
	
	
	
}
