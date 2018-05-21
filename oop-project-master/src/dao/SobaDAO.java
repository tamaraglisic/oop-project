package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import komparatori.SobaKomparator;
import model.Soba;

public class SobaDAO {
	
	public static Collection<Soba> sobe = new ArrayList<Soba>();
	public static String filePath = "./sobe.txt";
	
	public static void ucitajSobe() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(filePath));
		String temp;
		while((temp = f.readLine()) != null) {
			String[] tokens = temp.split("\\|");
			String broj = tokens[0];
			String[] tokensTipSobe = tokens[1].split(";");
			String naziv = tokensTipSobe[0];
			int brojKreveta = Integer.parseInt(tokensTipSobe[1]);
			boolean tv = Boolean.parseBoolean(tokens[2]);
			boolean miniBar = Boolean.parseBoolean(tokens[3]);
			boolean active = Boolean.parseBoolean(tokens[4]);
			Soba s = new Soba(broj, tv, miniBar, naziv, brojKreveta, active);
			sobe.add(s);
		}
		f.close();
	}
	public static void upisiSobu(Soba s) throws IOException {
		PrintWriter prw = new PrintWriter(new FileWriter(filePath, true));
		String upis =  s.getBroj() + "|" + s.getTip().getNaziv() + ";" + s.getTip().getBrKreveta() + "|"
						+ s.isTv() + "|" +s.isMiniBar() + "|" + s.isActive();
		prw.println(upis);
		prw.flush();
		prw.close();
				
	}
	public static void sortBroj() {
		ArrayList<Soba> lista = new ArrayList<Soba>();
		for (Soba s: sobe) {
			lista.add(s);
		}
		Collections.sort(lista, new SobaKomparator("brojSobe"));
		for (Soba s: lista) {
			System.out.println(s);
		}
	}
	
	public static void sortTip() {
		ArrayList<Soba> lista = new ArrayList<Soba>();
		for (Soba s: sobe) {
			lista.add(s);
		}
		Collections.sort(lista, new SobaKomparator("tipSobe"));
		for (Soba s: lista) {
			System.out.println(s);
		}
	}
}
