package model;


/**
 * 
 */
public class ClanskaKarta {

    protected int broj;
    protected String cijena;
    protected String tipkarte;
    
    public ClanskaKarta() {
    	this.broj = 0;
		this.cijena = "";
		this.tipkarte = "";
    }
    
	public ClanskaKarta(int broj, String cijena, String tipkarte) {
		super();
		this.broj = broj;
		this.cijena = cijena;
		this.tipkarte = tipkarte;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getCijena() {
		return cijena;
	}

	public void setCijena(String cijena) {
		this.cijena = cijena;
	}

	public String getTipkarte() {
		return tipkarte;
	}

	public void setTipkarte(String tipkarte) {
		this.tipkarte = tipkarte;
	}
    
    

}