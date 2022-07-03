package model;


/**
 * 
 */
public class Iznajmljivanje {
	
	protected String id;
    protected String datum_iznajmljivanja;
    protected String datum_vracanja;
    protected Zaposleni zaposleni;
    protected Clan clan;
    protected PrimjerakKnjige primjerak;
    protected boolean obrisan;
    
    public Iznajmljivanje() {
    	
    	this.id = "";
    	this.datum_iznajmljivanja = null;
		this.datum_vracanja = null;
		this.zaposleni = null;
		this.clan = null;
		this.primjerak = null;
		this.obrisan = false;
    	
    }
    
	public Iznajmljivanje(String id,String datum_iznajmljivanja, String datum_vracanja, Zaposleni zaposleni, Clan clan,
			PrimjerakKnjige primjerak, boolean obrisan) {
		super();
		
		this.id = id;
		this.datum_iznajmljivanja = datum_iznajmljivanja;
		this.datum_vracanja = datum_vracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primjerak = primjerak;
		this.obrisan = obrisan;
	}
	public Iznajmljivanje(String id,String datum_iznajmljivanja, String datum_vracanja, Zaposleni zaposleni, Clan clan,
			PrimjerakKnjige primjerak) {
		super();
		
		this.id = id;
		this.datum_iznajmljivanja = datum_iznajmljivanja;
		this.datum_vracanja = datum_vracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primjerak = primjerak;

	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public String getDatum_iznajmljivanja() {
		return datum_iznajmljivanja;
	}

	public void setDatum_iznajmljivanja(String datum_iznajmljivanja) {
		this.datum_iznajmljivanja = datum_iznajmljivanja;
	}

	public String getDatum_vracanja() {
		return datum_vracanja;
	}

	public void setDatum_vracanja(String datum_vracanja) {
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
		return 			  "ID \n: " + id+
						  "Zaposleni koji je iznajmio " + zaposleni.toString()+
						  "\nClan koji je iznajmio: " + clan.toString() +
						  "\nDatum iznajmljivanja:" + datum_iznajmljivanja +
						  "\nDatum vracanja:" + datum_vracanja +
						  "\nPrimjerak:" + primjerak.toString()+
						  "\nObrisan:" + obrisan;
						  
						  
	}
	
}