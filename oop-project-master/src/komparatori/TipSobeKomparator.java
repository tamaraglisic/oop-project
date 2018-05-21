package komparatori;

import java.util.Comparator;

import model.TipSobe;

public class TipSobeKomparator implements Comparator<TipSobe>{

	private String parametar;
	
	
	
	
	public TipSobeKomparator() {
		super();
	}

	public TipSobeKomparator(String parametar) {
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
	public int compare(TipSobe s1, TipSobe s2) {
		
		if (this.getParametar().equals("naziv")) {
			String naziv1 = s1.getNaziv();
			String naziv2 = s2.getNaziv();
			return naziv1.compareTo(naziv2);
		}
		else if (this.getParametar().equals("brojKreveta")) {
			int broj1 = s1.getBrKreveta(); 
			int broj2 = s2.getBrKreveta();
			return broj1 - broj2;
 			
		}
		return 0;
	}
	
	

}
