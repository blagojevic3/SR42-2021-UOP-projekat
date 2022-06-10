package model;
import enumeracije.TipPoveza;
import enumeracije.Jezik;
/**
 * 
 */
public class PrimjerakKnjige {

	protected Knjiga original;
    protected int broj_strana;
    protected int godina_stampanja;
    protected Jezik jezik_stampanja;
    protected boolean iznajmljena;
	protected String id; 
	protected TipPoveza tip;
	
	public PrimjerakKnjige() {
		
		this.original = null;
		this.broj_strana = 0;
		this.godina_stampanja = 0;
		this.jezik_stampanja = null;
		this.iznajmljena = false;
		this.id = "";
		this.tip = null;
	}
	
	public PrimjerakKnjige(String id, Knjiga original, int broj_strana, int godina_stampanja, Jezik jezik_stampanja,
			boolean iznajmljena, TipPoveza tip) {
		super();
		this.original = original;
		this.broj_strana = broj_strana;
		this.godina_stampanja = godina_stampanja;
		this.jezik_stampanja = jezik_stampanja;
		this.iznajmljena = iznajmljena;
		this.id = id;
		this.tip = tip;
	}

	public Knjiga getOriginal() {
		return original;
	}

	public void setOriginal(Knjiga original) {
		this.original = original;
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

	public Jezik getJezik_stampanja() {
		return jezik_stampanja;
	}

	public void setJezik_stampanja(Jezik jezik_stampanja) {
		this.jezik_stampanja = jezik_stampanja;
	}

	public boolean isIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipPoveza getTip() {
		return tip;
	}

	public void setTip(TipPoveza tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "Primjerak knjige: " + original.toString()+
				"\nBroj strana: " + broj_strana +
				"\nTip poveza:" + tip +
				"\nGodina stampanja:" + godina_stampanja +
				"\nJezik stampanja: " + jezik_stampanja +
				"\nIznajmljena:" + iznajmljena;
						  
	}
	
}