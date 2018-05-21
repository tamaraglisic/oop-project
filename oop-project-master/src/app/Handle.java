package app;



import dao.IznajmljivanjeDAO;
import dao.RacunDAO;
import dao.SobaDAO;
import dao.StavkaCenovnikaDAO;
import dao.TipSobeDAO;
import model.Korisnik;


public class Handle {
	
	
	public static int provera(int donjaGranica, int gornjaGranica) {
		System.out.println("Izaberite opciju --> ");
		int i;
		while (true) {
			try {
				String izbor = Main.inputScanner.nextLine();
				i = Integer.parseInt(izbor);
				if (donjaGranica<= i && i<gornjaGranica) break;
				else {
					System.out.println("Nekorektan unos pokusajte ponovo!\n --> ");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Nekorektan unos pokusajte ponovo!\n--> ");
			}
		}
		return i;
	}
	
	public static void openRecepcioner(Korisnik currentUser) {
		while (true) {
			Menu.recepcionerMenu();
			int i = provera(0, 6);
			if (i == 0) break;
//			else if (i == 1) openIznajmljivanje();
//			else if (i == 2) OpenIzdavanjeRacuna();
			else if (i == 3) openPretraga();
			else if (i == 4) openSortiranje();
			else if (i == 5) StavkaCenovnikaDAO.aktuelniCenovnik();
		}
		
	}
	
	public static void openPretraga() {
		while (true) {
			Menu.pretragaMenu();
			int i = provera(0, 5);
			if (i == 0) break;
			else if (i == 1) ;
			else if (i == 2) ;
			else if (i == 3) ;
			else if (i == 4) ;
			
		}
	}
	public static void openSortiranje() {
		while (true) {
			Menu.sortMenu();
			int i = provera(0, 5);
			if (i == 0) break;
			else if (i == 1) {
				while (true) {
					Menu.sortIznajmljivanja();
					i = provera(0, 8);
					if (i == 0) break;
					else if(i == 1) IznajmljivanjeDAO.sortBrSobe();
					else if (i == 2) IznajmljivanjeDAO.sortTipSobe();
					else if (i == 3) ;//po tipu iznajmljivanja
					else if (i == 4) IznajmljivanjeDAO.sortDatumPocetka();
					else if (i == 5) IznajmljivanjeDAO.sortDatumZavrsetka();
					else if (i == 6) ; 
					else if (i == 7) ;
				}
			}
			else if (i == 2) {
				while (true) {
					Menu.sortRacuna();
					i = provera(0, 6);
					if (i == 0) break;
					else if (i == 1) RacunDAO.sortDatumIzdavanja();
					else if (i == 2) RacunDAO.sortCena();
					else if (i == 3) RacunDAO.sortBrSobe();
					else if (i == 4) RacunDAO.sortTipSobe();
					else if (i == 5) RacunDAO.sortPlatilac();
				}
			}
			else if (i == 3) {
				while (true) {
					Menu.sortSoba();
					i = provera(0, 3);
					if (i == 0) break;
					else if (i == 1) SobaDAO.sortBroj();
					else if (i == 2) SobaDAO.sortTip();
				}
			}	
			else if (i == 4) {
				while (true) {
					Menu.sortTipSoba();
					i = provera(0, 3);
					if (i == 0) break;
					else if (i == 1) TipSobeDAO.sortNaziv();
					else if (i == 2) TipSobeDAO.sortBrojKreveta();
				}
			}
			
		}
	}

}
