package model;



public class Clan {


    protected String ime;
    protected String prezime;
    protected int jmbg;
    protected String adresa;
    protected boolean aktivan;
    protected int id;
    
    public Clan() {
    	this.ime = "";
		this.prezime = "";
		this.jmbg = 0;
		this.adresa = "";
		this.aktivan = false;
		this.id = 0;
    }
    
	public Clan(String ime, String prezime, int jmbg, String adresa, boolean aktivan, int id) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.aktivan = aktivan;
		this.id = id;
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

	public int getJmbg() {
		return jmbg;
	}

	public void setJmbg(int jmbg) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    
}