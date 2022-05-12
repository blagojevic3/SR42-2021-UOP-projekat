package model;


/**
 * 
 */
public class Zanr {

    protected double oznaka;
    protected String opis;
    
    public Zanr() {
    	this.oznaka = 0;
		this.opis = "";
    }
    
	public Zanr(double oznaka, String opis) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
	}

	public double getOznaka() {
		return oznaka;
	}

	public void setOznaka(double oznaka) {
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