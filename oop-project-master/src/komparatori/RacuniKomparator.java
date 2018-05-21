package komparatori;


import java.util.Comparator;
import java.util.Date;

import model.Racun;

public class RacuniKomparator implements Comparator<Racun> {

	private String parametar;
	
		
	public RacuniKomparator() {
		super();
	}


	public RacuniKomparator(String parametar) {
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
	public int compare(Racun r1, Racun r2) {
		
		if (this.getParametar().equals("datumIzdavanja")) {
			Date datum1 = r1.getDatumIzdavanja();
			Date datum2 = r2.getDatumIzdavanja();
			return datum1.compareTo(datum2);
			
		}
		
		else if (this.getParametar().equals("cena")) {
			double cena1 = r1.getCena();
			double cena2 = r2.getCena();
			return (int)(cena1*100 - cena2*100);
		}
		
		else if (this.getParametar().equals("brSobe")) {
			String br1 = r1.getIzn().getSoba().getBroj();
			String br2 = r2.getIzn().getSoba().getBroj();
			return br1.compareTo(br2);
		
		}
		else if (this.getParametar().equals("tipSobe")) {
			String tip1 = r1.getIzn().getSoba().getTip().getNaziv();
			String tip2 = r2.getIzn().getSoba().getTip().getNaziv();
			return tip1.compareTo(tip2);
		}
		else if (this.getParametar().equals("platilac")) {
			String ime1 = r1.getPlatilac().getIme();
			String ime2 = r2.getPlatilac().getIme();
			return ime1.compareTo(ime2);
		}
		
		
		return 0;
	}
	
	

}
