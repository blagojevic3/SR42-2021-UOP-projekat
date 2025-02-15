package model;



public class Clan {


    protected String ime;
    protected String prezime;
    protected String jmbg;
    protected String adresa;
    protected boolean aktivan;
    protected String id;
    protected boolean obrisan;
    //protected ClanskaKarta kartica;
    
    public Clan() {
    	this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.adresa = "";
		this.aktivan = false;
		this.id = "";
		this.obrisan = false;
		//this.kartica = null;
    }
    
	public Clan(String id, String ime, String prezime, String jmbg, String adresa, boolean aktivan, boolean obrisan) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.aktivan = aktivan;
		this.id = id;
		this.obrisan = obrisan;
		//this.kartica = kartica;
	}
	public Clan(String id, String ime, String prezime, String jmbg, String adresa, boolean aktivan) {
		
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.aktivan = aktivan;
		this.id = id;
		//this.kartica = kartica;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
//	public ClanskaKarta getKartica() {
//		return kartica;
//	}
//
//	public void setKartica(ClanskaKarta kartica) {
//		this.kartica = kartica;
//	}
	
	
	@Override
	public String toString() {
		return "CLAN 	   \nID: " + id+
						  "\nIme: " + ime +
						  "\nPrezime:" + prezime +
						  "\nJMBG:" + jmbg +
						  "\nAdresa" + adresa +
						  "\nAktivan"+ aktivan+
						  "\nObrisan:"+ obrisan;
//						  "\nClanska karta: " + kartica.toString();
						  
						  
	}
    
}