package model;


import enumeracije.TipKarte;

/**
 * 
 */
public class ClanskaKarta {

    protected String id;
    protected double cijena;
    protected TipKarte tipkarte;
    protected String datum_posljednje_uplate;
    protected int broj_mjeseci;
    protected boolean obrisan;
    
    public ClanskaKarta() {
    	this.id = "";
		this.cijena = 0;
		this.tipkarte = TipKarte.penzioneri;
		this.datum_posljednje_uplate = null;
		this.broj_mjeseci = 0;
		this.obrisan = false;
    }
    
	public ClanskaKarta(String id, double cijena, TipKarte tipkarte, String datum_posljednje_uplate, int broj_mjeseci, boolean obrisan) {
		super();
		this.id = id;
		this.cijena = cijena;
		this.tipkarte = tipkarte;
		this.datum_posljednje_uplate = datum_posljednje_uplate;
		this.broj_mjeseci = broj_mjeseci;
		this.obrisan = obrisan;
	}
	public ClanskaKarta(String id, double cijena, TipKarte tipkarte, String datum_posljednje_uplate, int broj_mjeseci) {
		this.id = id;
		this.cijena = cijena;
		this.tipkarte = tipkarte;
		this.datum_posljednje_uplate = datum_posljednje_uplate;
		this.broj_mjeseci = broj_mjeseci;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public TipKarte getTipkarte() {
		return tipkarte;
	}

	public void setTipkarte(TipKarte tipkarte) {
		this.tipkarte = tipkarte;
	}

	public String getDatum_posljednje_uplate() {
		return datum_posljednje_uplate;
	}

	public void setDatum_posljednje_uplate(String datum_posljednje_uplate) {
		this.datum_posljednje_uplate = datum_posljednje_uplate;
	}

	public int getBroj_mjeseci() {
		return broj_mjeseci;
	}

	public void setBroj_mjeseci(int broj_mjeseci) {
		this.broj_mjeseci = broj_mjeseci;
	}
    
	@Override
	public String toString() {
		return "\nBroj clanske karte: " + id+
				"\nCijena: " + cijena +
				"\nTip clanarine:" + tipkarte +
				"\nDatum posljednje uplate:" + datum_posljednje_uplate +
				"\nBroj mjeseci: " + broj_mjeseci+
				"\nObrisan:"+ obrisan;
						  				  
	}
    

}