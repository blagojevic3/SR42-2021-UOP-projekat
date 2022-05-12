package model;

import enumeracije.Pol;

/**
 * 
 */
public class Bibliotekar extends Zaposleni {

	public Bibliotekar() {
		super();
	}

	public Bibliotekar(String ime, String prezime, int jmbg, String adresa, Pol pol, String plata,
			String korisnicko_ime, String lozinka, String id) {
		super(ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime, lozinka, id);
		
	}

}