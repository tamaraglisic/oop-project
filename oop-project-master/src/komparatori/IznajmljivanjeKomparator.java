package komparatori;

import java.util.Comparator;
import java.util.Date;
import model.Iznajmljivanje;

public class IznajmljivanjeKomparator implements Comparator<Iznajmljivanje> {
	
	private String parametar;
	
	
	
	public IznajmljivanjeKomparator() {
		super();
	}

	public IznajmljivanjeKomparator(String parametar) {
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
	public int compare(Iznajmljivanje izn1, Iznajmljivanje izn2) {
		if (this.getParametar().equals("brSobe")) {
			String br1 = izn1.getSoba().getBroj();
			String br2 = izn2.getSoba().getBroj();
			return br1.compareTo(br2);
		}
		else if(this.getParametar().equals("tipobe")) {
			String tip1 = izn1.getSoba().getTip().getNaziv();
			String tip2 = izn2.getSoba().getTip().getNaziv();
			return tip1.compareTo(tip2);
		}
		else if(this.getParametar().equals("tipIznajmljivanja")) {
			
		}
		else if(this.getParametar().equals("datumPocetka")) {
			Date datum1 = izn1.getDatumPocetka();
			Date datum2 = izn2.getDatumPocetka();
			return datum1.compareTo(datum2);
			
		}
		else if(this.getParametar().equals("datumZavrsetka")) {
			Date datum1 = izn1.getDatumZavrsetka();
			Date datum2 = izn2.getDatumZavrsetka();
			return datum1.compareTo(datum2);
		}
		return 0;
	}

	
	
}
