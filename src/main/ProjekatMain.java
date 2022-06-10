package main;

import model.Administrator;
import model.Biblioteka;
import model.Bibliotekar;
import model.Clan;
import model.Knjiga;
import model.PrimjerakKnjige;
import model.Zanr;
import enumeracije.Jezik;
import enumeracije.Pol;
import enumeracije.TipPoveza;
import gui.GlavniProzor;

public class ProjekatMain {
	
	private static String administratori_FAJL = "administratori.txt";
	private static String bibliotekari_FAJL = "bibliotekari.txt";
	private static String clanovi_FAJL = "clanovi.txt";
	private static String knjige_FAJL = "knjige.txt";
	private static String primjerci_FAJL = "primjerci.txt";
	private static String zanrovi_FAJL = "zanrovi.txt";
	

	public static void main(String[] args) {
		
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajAdministratore(administratori_FAJL);
		biblioteka.ucitajBibliotekare(bibliotekari_FAJL);
		biblioteka.ucitajClanove(clanovi_FAJL);
		biblioteka.ucitajKnjige(knjige_FAJL);
		biblioteka.ucitajPrimjerke(primjerci_FAJL);
		biblioteka.ucitajZanrove(zanrovi_FAJL);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(biblioteka);
		System.out.println("----------------------------------------------");
		
		System.out.println("Primjeri...");
		Pol m = Pol.muski;
		Jezik eng = Jezik.engleski;
		TipPoveza t = TipPoveza.tvrd;

		
		Administrator administrator1 = new Administrator("001","Marko","Markovic","1002003004001","Adresa1",m, "3000rsd","marko123","123");
		biblioteka.dodajAdministratora(administrator1);
		
		Bibliotekar bibliotekar1 = new Bibliotekar("002","Petar","Petrovic","1002003004002","Adresa2",m, "30000rsd","petar123","1234");
		biblioteka.dodajBibliotekara(bibliotekar1);
		
		Clan clan1 = new Clan("003","Jelena","Markovic","1002003004003","Adresa3", true);
		biblioteka.dodajClana(clan1);
		
		Knjiga knjiga1 = new Knjiga("004","Knjiga1","OriginalnaKnjiga1",2020,"Ovo je opis knjige","Jovan", "Jovanovic");
		biblioteka.dodajKnjigu(knjiga1);
		
		PrimjerakKnjige primjerak1 = new PrimjerakKnjige("005",knjiga1,365,2021,eng,true,t);
		biblioteka.dodajPrimjerak(primjerak1);
		
		Zanr zanr1 = new Zanr("oznaka1","Ovo je opis zanra");
		biblioteka.dodajZanr(zanr1);
		
		
		System.out.println("Snimanje dodanih podataka...");
		biblioteka.snimiAdministratore(administratori_FAJL);
		biblioteka.snimiBibliotekare(bibliotekari_FAJL);
		biblioteka.snimiClanove(clanovi_FAJL);
		biblioteka.snimiKnjige(knjige_FAJL);
		biblioteka.snimiPrimjerke(primjerci_FAJL);
		biblioteka.snimiZanrove(zanrovi_FAJL);
			
		GlavniProzor gp = new GlavniProzor();
		gp.setVisible(true);
	}
	
	public static void ispisiSvePodatke(Biblioteka biblioteka) {
		for(Administrator administrator : biblioteka.getAdministratori()) {
			System.out.println(administrator + "\n");
		}
		
		for(Bibliotekar bibliotekar : biblioteka.getBibliotekari()) {
			System.out.println(bibliotekar + "\n");
		}
		for(Clan clan : biblioteka.getClanovi()) {
			System.out.println(clan + "\n");
		}
		for(Knjiga knjiga : biblioteka.getKnjige()) {
			System.out.println(knjiga + "\n");
		}
		for(PrimjerakKnjige primjerak : biblioteka.getPrimjerci()) {
			System.out.println(primjerak + "\n");
		}
		for(Zanr zanr : biblioteka.getZanrovi()) {
			System.out.println(zanr + "\n");
		}
	}
	

	

}
