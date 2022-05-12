package model;


/**
 * 
 */
public class Zanr {

    protected String oznaka;
    protected String opis;
    
    public Zanr() {
    	this.oznaka = "";
		this.opis = "";
    }
    
	public Zanr(String oznaka, String opis) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
	}

	public String getOznaka() {
		return oznaka;
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
		return "/nOznaka: " + oznaka+
				"\nIme: " + opis;

						  
						  
	}
}