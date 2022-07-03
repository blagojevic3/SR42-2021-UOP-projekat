package main;

import model.Administrator;
import model.Biblioteka;
import model.Bibliotekar;
import model.Clan;
import model.ClanskaKarta;
import model.Iznajmljivanje;
import model.Knjiga;
import model.PrimjerakKnjige;
import model.Zanr;
import enumeracije.Jezik;
import enumeracije.Pol;
import enumeracije.TipPoveza;
import gui.GlavniProzor;
import gui.LoginProzor;

public class ProjekatMain {
	
	public static String administratori_FAJL = "administratori.txt";
	public static String bibliotekari_FAJL = "bibliotekari.txt";
	public static String clanovi_FAJL = "clanovi.txt";
	public static String knjige_FAJL = "knjige.txt";
	public static String primjerci_FAJL = "primjerci.txt";
	public static String zanrovi_FAJL = "zanrovi.txt";
	public static String clanarine_FAJL = "clanarine.txt";
	public static String iznajmljivanja_FAJL = "iznajmljivanja.txt";
	
	

	public static void main(String[] args) {
		
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajAdministratore(administratori_FAJL);
		biblioteka.ucitajBibliotekare(bibliotekari_FAJL);
		biblioteka.ucitajClanove(clanovi_FAJL);
		biblioteka.ucitajKnjige(knjige_FAJL);
		biblioteka.ucitajPrimjerke(primjerci_FAJL);
		biblioteka.ucitajZanrove(zanrovi_FAJL);
		biblioteka.ucitajClanarine(clanarine_FAJL);
		biblioteka.ucitajIznajmljivanje(iznajmljivanja_FAJL);

		LoginProzor lp = new LoginProzor(biblioteka);
		lp.setVisible(true);

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
		for(Iznajmljivanje iznajmljivanje: biblioteka.getIznajmljivanja()) {
			System.out.println(iznajmljivanje+"\n");
		}
		for(ClanskaKarta clanarina: biblioteka.getClanarine()) {
			System.out.println(clanarina+"\n");
		}
	}
	

	

}
