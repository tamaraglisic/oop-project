package komparatori;

import java.util.Comparator;

import model.Soba;

public class SobaKomparator implements Comparator<Soba>{
	private String parametar;
	
	

	
	public SobaKomparator() {
		super();
	}

	public SobaKomparator(String parametar) {
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
	public int compare(Soba s1, Soba s2) {
		if (this.getParametar().equals("brojSobe")) {
			String broj1 = s1.getBroj();
			String broj2 = s2.getBroj();
			return broj1.compareTo(broj2);
		}
		else if (this.getParametar().equals("tipSobe")) {
			String naziv1 = s1.getTip().getNaziv();
			String naziv2 = s2.getTip().getNaziv();
			return naziv1.compareTo(naziv2);
		}
		
		return 0;
	}
	
	

}
