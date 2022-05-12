package model;

import enumeracije.Pol;

public class Administrator extends Zaposleni {

	public Administrator() {
		super();
	}

	public Administrator(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, String plata,
			String korisnicko_ime, String lozinka) {
		super(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime, lozinka);
		
	}

    
    

}