package model;
import java.time.LocalTime;



public class Biblioteka {

    protected String naziv;
    protected String adresa;
    protected int telefon;
    protected LocalTime radno_vrijeme;
    
    public Biblioteka() {
    	this.naziv = "";
		this.adresa = "";
		this.telefon = 0;
		this.radno_vrijeme = null;
    }
    
	public Biblioteka(String naziv, String adresa, int telefon, LocalTime radno_vrijeme) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radno_vrijeme = radno_vrijeme;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public LocalTime getRadno_vrijeme() {
		return radno_vrijeme;
	}

	public void setRadno_vrijeme(LocalTime radno_vrijeme) {
		this.radno_vrijeme = radno_vrijeme;
	}

    
}