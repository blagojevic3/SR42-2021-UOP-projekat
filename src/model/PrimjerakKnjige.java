package model;


/**
 * 
 */
public class PrimjerakKnjige {

    protected int broj_strana;
    protected int godina_stampanja;
    protected boolean iznajmljena;
    
    public PrimjerakKnjige() {
    	this.broj_strana = 0;
		this.godina_stampanja = 0;
		this.iznajmljena = false;
    }
    
	public PrimjerakKnjige(int broj_strana, int godina_stampanja, boolean iznajmljena) {
		super();
		this.broj_strana = broj_strana;
		this.godina_stampanja = godina_stampanja;
		this.iznajmljena = iznajmljena;
	}

	public int getBroj_strana() {
		return broj_strana;
	}

	public void setBroj_strana(int broj_strana) {
		this.broj_strana = broj_strana;
	}

	public int getGodina_stampanja() {
		return godina_stampanja;
	}

	public void setGodina_stampanja(int godina_stampanja) {
		this.godina_stampanja = godina_stampanja;
	}

	public boolean isIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}
    
	
    

}