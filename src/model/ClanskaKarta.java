package model;
import java.time.LocalDate;

/**
 * 
 */
public class ClanskaKarta {

    protected int broj;
    protected double cijena;
    protected String tipkarte;
    protected LocalDate datum_posljednje_uplate;
    protected int broj_mjeseci;
    
    public ClanskaKarta() {
    	this.broj = 0;
		this.cijena = 0;
		this.tipkarte = "";
		this.datum_posljednje_uplate = null;
		this.broj_mjeseci = 0;
    }
    
	public ClanskaKarta(int broj, double cijena, String tipkarte, LocalDate datum_posljednje_uplate, int broj_mjeseci) {
		super();
		this.broj = broj;
		this.cijena = cijena;
		this.tipkarte = tipkarte;
		this.datum_posljednje_uplate = datum_posljednje_uplate;
		this.broj_mjeseci = broj_mjeseci;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public String getTipkarte() {
		return tipkarte;
	}

	public void setTipkarte(String tipkarte) {
		this.tipkarte = tipkarte;
	}

	public LocalDate getDatum_posljednje_uplate() {
		return datum_posljednje_uplate;
	}

	public void setDatum_posljednje_uplate(LocalDate datum_posljednje_uplate) {
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
		return "\nBroj clanske karte: " + broj+
				"\nCijena: " + cijena +
				"\nTip clanarine:" + tipkarte +
				"\nDatum posljednje uplate:" + datum_posljednje_uplate +
				"\nBroj mjeseci: " + broj_mjeseci;
						  				  
	}
    

}