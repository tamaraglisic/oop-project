package model;

public class Soba {
	
	private String broj;
	private boolean tv;
	private boolean miniBar;
	private TipSobe tip;
	private boolean active;
	
	
	
	public Soba() {
		super();
	}
	
	public Soba(Soba s) {
		this.broj = s.broj;
		this.tv = s.tv;
		this.miniBar = s.miniBar;
		this.tip = s.tip;
		this.active = s.active;
	}
	
	public Soba(String broj, boolean tv, boolean miniBar, TipSobe tip, boolean active) {
		super();
		this.broj = broj;
		this.tv = tv;
		this.miniBar = miniBar;
		this.tip = tip;
		this.active = active;
	}
	
	public Soba (String broj, boolean tv, boolean miniBar, String naziv, int brojKreveta, boolean active) {
		this.broj = broj;
		this.tv = tv;
		this.miniBar = miniBar;
		this.tip = new TipSobe(naziv, brojKreveta);
		this.active = active;
	}
	public Soba(String broj, boolean tv, boolean miniBar, TipSobe tip) {
		super();
		this.broj = broj;
		this.tv = tv;
		this.miniBar = miniBar;
		this.tip = tip;
		this.active = true;
	
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		
		String daliimaminibar;
		String daliimatv;
		
		if (this.isTv()) {
			daliimatv = "Da";
		}else {
			daliimatv = "Ne";
		}
		if (this.isMiniBar()) {
			daliimaminibar = "Da";
		}else {
			daliimaminibar = "Ne";
		}
		

		String out = this.getBroj() + " " + this.getTip() + " TV " + daliimatv + " mini bar " + daliimaminibar;
		return out;
	}
	
}
