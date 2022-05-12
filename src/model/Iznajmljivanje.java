package model;
import java.time.LocalDate;

/**
 * 
 */
public class Iznajmljivanje {

    protected LocalDate datum_iznajmljivanja;
    protected LocalDate datum_vracanja;
    protected Zaposleni zaposleni;
    protected Clan clan;
    protected PrimjerakKnjige primjerak;
    
    public Iznajmljivanje() {
    	
    	this.datum_iznajmljivanja = null;
		this.datum_vracanja = null;
		this.zaposleni = null;
		this.clan = null;
		this.primjerak = null;
    	
    }
    
	public Iznajmljivanje(LocalDate datum_iznajmljivanja, LocalDate datum_vracanja, Zaposleni zaposleni, Clan clan,
			PrimjerakKnjige primjerak) {
		super();
		this.datum_iznajmljivanja = datum_iznajmljivanja;
		this.datum_vracanja = datum_vracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primjerak = primjerak;
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

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public PrimjerakKnjige getPrimjerak() {
		return primjerak;
	}

	public void setPrimjerak(PrimjerakKnjige primjerak) {
		this.primjerak = primjerak;
	}
    
	@Override
	public String toString() {
		return "Zaposleni koji je iznajmio \n: " + zaposleni.toString()+
						  "\nClan koji je iznajmio: " + clan.toString() +
						  "\nDatum iznajmljivanja:" + datum_iznajmljivanja +
						  "\nDatum vracanja:" + datum_vracanja +
						  "\nPrimjerak:" + primjerak.toString();
						  
						  
	}
	
}