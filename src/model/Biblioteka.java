package model;
import java.time.LocalTime;
import java.util.ArrayList;




public class Biblioteka {

    protected String naziv;
    protected String adresa;
    protected int telefon;
    protected LocalTime radno_vrijeme;
    protected ArrayList<Bibliotekar> bibliotekari;
    protected ArrayList<Administrator> administratori;
    protected ArrayList<Clan> clanovi;
    protected ArrayList<Knjiga> knjige;
    protected ArrayList<PrimjerakKnjige> primjerci;
    protected ArrayList<Zanr> zanrovi;
    
    public Biblioteka() {
    	this.bibliotekari = new ArrayList<Bibliotekar>();
    	this.administratori = new ArrayList<Administrator>();
    	this.clanovi = new ArrayList<Clan>();
    	this.knjige = new ArrayList<Knjiga>();
    	this.primjerci = new ArrayList<PrimjerakKnjige>();
    	this.zanrovi = new ArrayList<Zanr>();
    	this.naziv = "";
    	this.adresa = "";
    	this.telefon = 0;
    	this.radno_vrijeme = null;
    }

	public Biblioteka(String naziv, String adresa, int telefon, LocalTime radno_vrijeme) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radno_vrijeme = radno_vrijeme;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public LocalTime getRadno_vrijeme() {
		return radno_vrijeme;
	}

	public void setRadno_vrijeme(LocalTime radno_vrijeme) {
		this.radno_vrijeme = radno_vrijeme;
	}

	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}

	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}

	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}

	public void setAdministratori(ArrayList<Administrator> administratori) {
		this.administratori = administratori;
	}

	public ArrayList<Clan> getClanovi() {
		return clanovi;
	}

	public void setClanovi(ArrayList<Clan> clanovi) {
		this.clanovi = clanovi;
	}

	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}

	public ArrayList<PrimjerakKnjige> getPrimjerci() {
		return primjerci;
	}

	public void setPrimjerci(ArrayList<PrimjerakKnjige> primjerci) {
		this.primjerci = primjerci;
	}

	public ArrayList<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(ArrayList<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}
	
	
    

    public Administrator nadjiAdministratora(String id) {
    	for(Administrator administrator:administratori) {
    		if (administrator.getId().equals(id)) {
    			return administrator;
    		}
    	}
    	return null;
    }
    public Bibliotekar nadjiBibliotekara(String id) {
    	for(Bibliotekar bibliotekar:bibliotekari) {
    		if (bibliotekar.getId().equals(id)) {
    			return bibliotekar;
    		}
    	}
    	return null;
    }
    public Clan nadjiClana(String id) {
    	for(Clan clan:clanovi) {
    		if (clan.getId().equals(id)) {
    			return clan;
    		}
    	}
    	return null;
    }
    public Knjiga nadjiKnjigu(String id) {
    	for(Knjiga knjiga:knjige) {
    		if (knjiga.getId().equals(id)) {
    			return knjiga;
    		}
    	}
    	return null;
    }
    public PrimjerakKnjige primjerak(String id) {
    	for(PrimjerakKnjige primjerak:primjerci) {
    		if (primjerak.getId().equals(id)) {
    			return primjerak;
    		}
    	}
    	return null;
    }
    public Zanr zanr(String oznaka) {
    	for(Zanr zanr:zanrovi) {
    		if (zanr.getOznaka().equals(oznaka)) {
    			return zanr;
    		}
    	}
    	return null;
    }
    
	
    
    
    
}