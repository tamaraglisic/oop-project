package komparatori;

import java.util.Comparator;
import java.util.Date;

import model.StavkaCenovnika;

public class CenovnikKomparator implements Comparator<StavkaCenovnika>{

	@Override
	public int compare(StavkaCenovnika o1, StavkaCenovnika o2) {
		Date datum1 = o1.getDatumKreiranja();
		Date datum2 = o2.getDatumKreiranja();
		return datum1.compareTo(datum2);
	}
	
	

}
