package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import enumeracije.Jezik;
import enumeracije.Pol;
import enumeracije.TipPoveza;




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
    
    public void snimiAdministratore(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Administrator administrator : administratori) {
				content += administrator.getId() + "|" + administrator.getIme() + "|"
						+ administrator.getPrezime() + "|" + administrator.getJmbg() + "|"
						+ administrator.getAdresa() + "|" + administrator.getPol() + "|" + administrator.getPlata() + "|"
						+ administrator.getKorisnicko_ime() + "|" + administrator.getLozinka()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja administratora.");
		}
	}
    
    public void snimiBibliotekare(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Bibliotekar bibliotekar : bibliotekari) {
				content += bibliotekar.getId() + "|" + bibliotekar.getIme() + "|"
						+ bibliotekar.getPrezime() + "|" + bibliotekar.getJmbg() + "|"
						+ bibliotekar.getAdresa() + "|" + bibliotekar.getPol() + "|" + bibliotekar.getPlata() + "|"
						+ bibliotekar.getKorisnicko_ime() + "|" + bibliotekar.getLozinka()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}
    
    public void snimiClanove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Clan clan : clanovi) {
				content += clan.getId() + "|" + clan.getIme() + "|"
						+ clan.getPrezime() + "|" + clan.getJmbg() + "|"
						+ clan.getAdresa() + "|" + clan.isAktivan()  /*+ clan.getKartica()*/ + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}
    
    public void snimiKnjige(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Knjiga knjiga : knjige) {
				content += knjiga.getId() + "|" + knjiga.getNaslov() + "|"
						+ knjiga.getOriginalni_naslov() + "|" + knjiga.getGodina_objave() + "|"
						+ knjiga.getOpis_knjige() + "|" + knjiga.getIme_pisca() + "|" + knjiga.getPrezime_pisca() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}
    
    public void snimiPrimjerke(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (PrimjerakKnjige primjerak : primjerci) {
				content += primjerak.getId() + "|" + primjerak.getOriginal().getId() + "|"
						+ primjerak.getBroj_strana() + "|" + primjerak.getGodina_stampanja() + "|"
						+ primjerak.getJezik_stampanja() + "|" + primjerak.isIznajmljena() + "|" + primjerak.getTip() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}
    
    public void snimiZanrove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Zanr zanr : zanrovi) {
				content += zanr.getOznaka() + "|" + zanr.getOpis() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}
    
    public void ucitajAdministratore(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String adresa = split[4];
				Pol pol = Pol.valueOf(split[5]);
				String plata = split[6];
				String korisnicko_ime = split[7];
				String lozinka = split[8];
				Administrator administrator = new Administrator(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime,lozinka);
				administratori.add(administrator);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}
    
    public void ucitajBibliotekare(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String adresa = split[4];
				Pol pol = Pol.valueOf(split[5]);
				String plata = split[6];
				String korisnicko_ime = split[7];
				String lozinka = split[8];
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime,lozinka);
				bibliotekari.add(bibliotekar);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}
    
    public void ucitajClanove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String adresa = split[4];
				boolean aktivan = Boolean.parseBoolean(split[4]);
				
				
				Clan clan = new Clan(id, ime, prezime, jmbg, adresa, aktivan);
				clanovi.add(clan);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}
    
    public void ucitajKnjige(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String naslov = split[1];
				String originalni_naslov = split[2];
				String godina_objaveString = split[3];
				int godina_objave = Integer.parseInt(godina_objaveString);
				String opis_knjige = split[4];
				String ime_pisca = split[5];
				String prezime_pisca = split[6];
				
				
				Knjiga knjiga = new Knjiga(id, naslov, originalni_naslov, godina_objave, opis_knjige, ime_pisca, prezime_pisca);
				knjige.add(knjiga);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}
	
    public void ucitajPrimjerke(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				Knjiga original = null;
				for(Knjiga k:knjige) {
					if(k.getId().equals(split[1])) {
						original = k;
					}
				}
				String broj_stranaString = split[2];
				int broj_strana = Integer.parseInt(broj_stranaString);
				String godina_stampanjaString = split[3];
				int godina_stampanja = Integer.parseInt(godina_stampanjaString);
				Jezik jezik = Jezik.valueOf(split[4]);
				boolean iznajmljena = Boolean.parseBoolean(split[5]);
				TipPoveza tip = TipPoveza.valueOf(split[6]);
				
				
				
				PrimjerakKnjige primjerak = new PrimjerakKnjige(id, original, broj_strana, godina_stampanja, jezik, iznajmljena,tip);
				primjerci.add(primjerak);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}
    
    public void ucitajZanrove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String oznaka = split[0];
				String opis = split[1];
				
				
				
				
				Zanr zanr = new Zanr(oznaka, opis);
				zanrovi.add(zanr);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}
    
    public void dodajAdministratora(Administrator administrator) {
		this.administratori.add(administrator);
	}
    
    public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.add(bibliotekar);
	}
    public void dodajClana(Clan clan) {
		this.clanovi.add(clan);
	}
    public void dodajKnjigu(Knjiga knjiga) {
		this.knjige.add(knjiga);
	}
    public void dodajPrimjerak(PrimjerakKnjige primjerak) {
		this.primjerci.add(primjerak);
	}
    public void dodajZanr(Zanr zanr) {
		this.zanrovi.add(zanr);
	}
    
    
}