package model;
import java.time.LocalDate;

/**
 * 
 */
public class UplataClanarine {

    protected LocalDate datum_posljednje;
    protected int broj_mjeseci;
    
    public UplataClanarine() {
    	this.datum_posljednje = null;
		this.broj_mjeseci = 0;
    }
    
	public UplataClanarine(LocalDate datum_posljednje, int broj_mjeseci) {
		super();
		this.datum_posljednje = datum_posljednje;
		this.broj_mjeseci = broj_mjeseci;
	}

	public LocalDate getDatum_posljednje() {
		return datum_posljednje;
	}

	public void setDatum_posljednje(LocalDate datum_posljednje) {
		this.datum_posljednje = datum_posljednje;
	}

	public int getBroj_mjeseci() {
		return broj_mjeseci;
	}

	public void setBroj_mjeseci(int broj_mjeseci) {
		this.broj_mjeseci = broj_mjeseci;
	}
    
    

}