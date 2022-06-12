package model;

import enumeracije.Pol;

public class Administrator extends Zaposleni {

	public Administrator() {
		super();
	}

	public Administrator(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, String plata,
			String korisnicko_ime, String lozinka, boolean obrisan) {
		super(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime, lozinka, obrisan);
		
	}
	public Administrator(String id, String ime, String prezime, String jmbg, String adresa, Pol pol, String plata, 
			String korisnicko_ime, String lozinka) {
		
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
		this.plata = plata;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
				
		
	}

    
    

}