package model;

public class Soba {
	
	private String broj;
	private boolean tv;
	private boolean miniBar;
	private TipSobe tip;
	
	public Soba() {
		super();
	}
	
	public Soba(Soba s) {
		this.broj = s.broj;
		this.tv = s.tv;
		this.miniBar = s.miniBar;
		this.tip = s.tip;
	}
	
	public Soba(String broj, boolean tv, boolean miniBar, TipSobe tip) {
		super();
		this.broj = broj;
		this.tv = tv;
		this.miniBar = miniBar;
		this.tip = tip;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public boolean isMiniBar() {
		return miniBar;
	}
	public void setMiniBar(boolean miniBar) {
		this.miniBar = miniBar;
	}
	public TipSobe getTip() {
		return tip;
	}
	public void setTip(TipSobe tip) {
		this.tip = tip;
	}
	
	
}
