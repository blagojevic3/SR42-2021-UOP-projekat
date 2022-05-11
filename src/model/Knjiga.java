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
    
    

}