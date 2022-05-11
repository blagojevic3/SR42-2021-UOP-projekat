package model;
import java.time.LocalDate;

/**
 * 
 */
public class Iznajmljivanje {

    protected LocalDate datum_iznajmljivanja;
    protected LocalDate datum_vracanja;
    
    public Iznajmljivanje() {
    	
    	this.datum_iznajmljivanja = null;
		this.datum_vracanja = null;
    }
    
	public Iznajmljivanje(LocalDate datum_iznajmljivanja, LocalDate datum_vracanja) {
		super();
		this.datum_iznajmljivanja = datum_iznajmljivanja;
		this.datum_vracanja = datum_vracanja;
	}

	public LocalDate getDatum_iznajmljivanja() {
		return datum_iznajmljivanja;
	}

	public void setDatum_iznajmljivanja(LocalDate datum_iznajmljivanja) {
		this.datum_iznajmljivanja = datum_iznajmljivanja;
	}

	public LocalDate getDatum_vracanja() {
		return datum_vracanja;
	}

	public void setDatum_vracanja(LocalDate datum_vracanja) {
		this.datum_vracanja = datum_vracanja;
	}
    
    

}