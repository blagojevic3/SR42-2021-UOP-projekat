package model;


/**
 * 
 */
public class Knjiga {

    protected String naslov;
    protected String originalni_naslov;
    protected int godina_objave;
    protected String opis_knjige;
    protected String ime_pisca;
    protected String prezime_pisca;
    protected int id;
    
    public Knjiga() {
    	this.naslov = "";
		this.originalni_naslov = "";
		this.godina_objave = 0;
		this.opis_knjige = "";
		this.ime_pisca = "";
		this.prezime_pisca = "";
		this.id = 0;
    }
    
	public Knjiga(String naslov, String originalni_naslov, int godina_objave, String opis_knjige, String ime_pisca,
			String prezime_pisca, int id) {
		super();
		this.naslov = naslov;
		this.originalni_naslov = originalni_naslov;
		this.godina_objave = godina_objave;
		this.opis_knjige = opis_knjige;
		this.ime_pisca = ime_pisca;
		this.prezime_pisca = prezime_pisca;
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalni_naslov() {
		return originalni_naslov;
	}

	public void setOriginalni_naslov(String originalni_naslov) {
		this.originalni_naslov = originalni_naslov;
	}

	public int getGodina_objave() {
		return godina_objave;
	}

	public void setGodina_objave(int godina_objave) {
		this.godina_objave = godina_objave;
	}

	public String getOpis_knjige() {
		return opis_knjige;
	}

	public void setOpis_knjige(String opis_knjige) {
		this.opis_knjige = opis_knjige;
	}

	public String getIme_pisca() {
		return ime_pisca;
	}

	public void setIme_pisca(String ime_pisca) {
		this.ime_pisca = ime_pisca;
	}

	public String getPrezime_pisca() {
		return prezime_pisca;
	}

	public void setPrezime_pisca(String prezime_pisca) {
		this.prezime_pisca = prezime_pisca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@Override
	public String toString() {
		return "Knjiga 	   \nID: " + id+
						  "\nOriginalni naslov: " + originalni_naslov +
						  "\nGodina objave:" + godina_objave +
						  "\nOpis knjige:" + opis_knjige +
						  "\nIme pisca" + ime_pisca +
						  "\nPrezime pisca" + prezime_pisca; 
						  
						  
	}

}