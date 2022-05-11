package model;

import enumeracije.Pol;

public class Zaposleni {

    protected String ime;
    protected String prezime;
	protected int jmbg;
    protected String adresa;
    protected Pol pol;
    protected String plata;
    protected String korisnicko_ime;
    protected String lozinka;
    protected int id;
    
    public Zaposleni() {
    	this.ime = "";
		this.prezime = "";
		this.jmbg = 0;
		this.adresa = "";
		this.pol = Pol.muski;
		this.plata = "";
		this.korisnicko_ime = "";
		this.lozinka = "";
		this.id = 0;
    }
    
    public Zaposleni(String ime, String prezime, int jmbg, String adresa, Pol pol, String plata,
			String korisnicko_ime, String lozinka, int id) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
		this.plata = plata;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public int getJmbg() {
		return jmbg;
	}
	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Pol getPol() {
		return pol;
	}
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	public String getPlata() {
		return plata;
	}
	public void setPlata(String plata) {
		this.plata = plata;
	}
	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}
	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	


}