package model;


/**
 * 
 */
public class Zanr {

    protected String oznaka;
    protected String naziv;
    protected String opis;
    protected boolean obrisan;
    
    public Zanr() {
    	this.oznaka = "";
    	this.naziv = "";
		this.opis = "";
		this.obrisan = false;
    }
    
	public Zanr(String oznaka, String naziv, String opis, boolean obrisan) {
		super();
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.opis = opis;
		this.obrisan = obrisan;
	}
	public Zanr(String oznaka, String naziv, String opis) {
		
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.opis = opis;

	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOznaka() {
		return oznaka;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "\nOznaka: " + oznaka+
				"\nNaziv"+
				"\nOpis: " + opis+
				"\nObrisan:"+ obrisan;

						  
						  
	}
}