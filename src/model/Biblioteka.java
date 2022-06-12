package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import enumeracije.Jezik;
import enumeracije.Pol;
import enumeracije.TipPoveza;




public class Biblioteka {

    protected String naziv;
    protected String adresa;
    protected int telefon;
    protected String radno_vrijeme;
    protected ArrayList<Zaposleni> zaposleni;
    protected ArrayList<Bibliotekar> bibliotekari;
    protected ArrayList<Administrator> administratori;
    protected ArrayList<Clan> clanovi;
    protected ArrayList<Knjiga> knjige;
    protected ArrayList<PrimjerakKnjige> primjerci;
    protected ArrayList<Zanr> zanrovi;
    protected ArrayList<Iznajmljivanje> iznajmljivanja;
    protected ArrayList<ClanskaKarta> clanarine;
 
    

    
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

	public Biblioteka(String naziv, String adresa, int telefon, String radno_vrijeme) {
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

	public String getRadno_vrijeme() {
		return radno_vrijeme;
	}

	public void setRadno_vrijeme(String radno_vrijeme) {
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
	
	
    

	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public ArrayList<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}

	public void setIznajmljivanja(ArrayList<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}

	public ArrayList<ClanskaKarta> getClanarine() {
		return clanarine;
	}

	public void setClanarine(ArrayList<ClanskaKarta> clanarine) {
		this.clanarine = clanarine;
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
						+ administrator.getKorisnicko_ime() + "|" + administrator.getLozinka()+"|"+ administrator.isObrisan()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
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
						+ bibliotekar.getKorisnicko_ime() + "|" + bibliotekar.getLozinka()+"|"+ bibliotekar.isObrisan()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
		}
	}
    
    public void snimiClanove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Clan clan : clanovi) {
				content += clan.getId() + "|" + clan.getIme() + "|"
						+ clan.getPrezime() + "|" + clan.getJmbg() + "|"
						+ clan.getAdresa() + "|" + clan.isAktivan()+ "|"+ clan.isObrisan() /*+ clan.getKartica()*/ + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
		}
	}
    
    public void snimiKnjige(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Knjiga knjiga : knjige) {
				content += knjiga.getId() + "|" + knjiga.getNaslov() + "|"
						+ knjiga.getOriginalni_naslov() + "|" + knjiga.getGodina_objave() + "|"
						+ knjiga.getOpis_knjige() + "|" + knjiga.getIme_pisca() + "|" + knjiga.getPrezime_pisca()  + "|"+knjiga.isObrisan()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
		}
	}
    
    public void snimiPrimjerke(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (PrimjerakKnjige primjerak : primjerci) {
				content += primjerak.getId() + "|" + primjerak.getOriginal().getId() + "|"
						+ primjerak.getBroj_strana() + "|" + primjerak.getGodina_stampanja() + "|"
						+ primjerak.getJezik_stampanja() + "|" + primjerak.isIznajmljena() + "|" + primjerak.getTip() +"|"+primjerak.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
		}
	}
    
    public void snimiZanrove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Zanr zanr : zanrovi) {
				content += zanr.getOznaka() + "|" + zanr.getOpis() + "|" + zanr.isObrisan()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
		}
	}
    public void snimiIznajmljivanje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Iznajmljivanje iznajmljivanje : iznajmljivanja) {
				content += iznajmljivanje.getId() + "|" + iznajmljivanje.getZaposleni() + "|"
				+ iznajmljivanje.getClan()+"|"+ iznajmljivanje.getPrimjerak()+"|"
				+ iznajmljivanje.getDatum_iznajmljivanja() + "|" + iznajmljivanje.getDatum_vracanja()+"|"
				+ iznajmljivanje.isObrisan()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
		}
	}
    
    public void snimiClanarine(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (ClanskaKarta clanarina : clanarine) {
				content += clanarina.getBroj() + "|" + clanarina.getCijena() + "|"
				+ clanarina.getTipkarte()+"|"+ clanarina.getDatum_posljednje_uplate()+"|"
				+ clanarina.getBroj_mjeseci() + "|" + clanarina.isObrisan()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja.");
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
				boolean obrisan = Boolean.parseBoolean(split[9]);
				Administrator administrator = new Administrator(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime,lozinka, obrisan);
				administratori.add(administrator);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
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
				boolean obrisan = Boolean.parseBoolean(split[9]);
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime,lozinka,obrisan);
				bibliotekari.add(bibliotekar);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
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
				boolean aktivan = Boolean.parseBoolean(split[5]);
				boolean obrisan = Boolean.parseBoolean(split[6]);
				
				
				Clan clan = new Clan(id, ime, prezime, jmbg, adresa, aktivan,obrisan);
				clanovi.add(clan);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
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
				boolean obrisan = Boolean.parseBoolean(split[7]);
				
				
				Knjiga knjiga = new Knjiga(id, naslov, originalni_naslov, godina_objave, opis_knjige, ime_pisca, prezime_pisca, obrisan);
				knjige.add(knjiga);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
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
				boolean obrisan = Boolean.parseBoolean(split[7]);
				
				
				
				PrimjerakKnjige primjerak = new PrimjerakKnjige(id, original, broj_strana, godina_stampanja, jezik, iznajmljena,tip, obrisan);
				primjerci.add(primjerak);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
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
				boolean obrisan = Boolean.parseBoolean(split[2]);
				
				
				
				
				Zanr zanr = new Zanr(oznaka, opis, obrisan);
				zanrovi.add(zanr);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
			e.printStackTrace();
		}
	}
    
    public void ucitajIznajmljivanje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String datum_iznajmljivanja = split[1];
				String datum_vracanja = split[2];
				Zaposleni iznajmljivac = null;
				for(Zaposleni z:zaposleni) {
					if(z.getId().equals(split[3])) {
						iznajmljivac = z;
					}
				}
				Clan clan = null;
				for(Clan c:clanovi) {
					if(c.getId().equals(split[4])) {
						clan = c;
					}
				}
				PrimjerakKnjige primjerak = null;
				for(PrimjerakKnjige p:primjerci) {
					if(p.getId().equals(split[5])) {
						primjerak = p;
					}
				}


				boolean obrisan = Boolean.parseBoolean(split[6]);
				
				
				
				
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datum_iznajmljivanja, datum_vracanja, iznajmljivac, clan,
						primjerak, obrisan);
				iznajmljivanja.add(iznajmljivanje);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
			e.printStackTrace();}
		}
		
    public void ucitajClanarine(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int broj = Integer.parseInt(split[0]);
				double cijena = Double.parseDouble(split[1]);
				String tipkarte = split[2];
				LocalDate datum_posljednje_uplate = LocalDate.parse(split[3]);
				int broj_mjeseci = Integer.parseInt(split[4]);	
				boolean obrisan = Boolean.parseBoolean(split[5]);
				
				
				
				
				ClanskaKarta clanarina = new ClanskaKarta(broj, cijena, tipkarte, datum_posljednje_uplate, broj_mjeseci, obrisan);
				clanarine.add(clanarina);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka");
			e.printStackTrace();
		}
	}	
    
    public void dodajAdministratora(Administrator administrator) {
		this.administratori.add(administrator);
	}
    
    public void obrisiAdministratora(Administrator administrator) {
    	this.administratori.remove(administrator);
    }
    public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.add(bibliotekar);
	}
    public void obrisiBibliotekara(Bibliotekar bibliotekar) {
    	this.bibliotekari.remove(bibliotekar);
    }
    public void dodajClana(Clan clan) {
		this.clanovi.add(clan);
	}
    public void izbrisiClana(Clan clan) {
		this.clanovi.remove(clan);
	}
    public void dodajKnjigu(Knjiga knjiga) {
		this.knjige.add(knjiga);
	}
    public void izbrisiKnjigu(Knjiga knjiga) {
		this.knjige.remove(knjiga);
	}
    public void dodajPrimjerak(PrimjerakKnjige primjerak) {
		this.primjerci.add(primjerak);
	}
    public void izbrisiPrimjerak(PrimjerakKnjige primjerak) {
		this.primjerci.remove(primjerak);
	}
    public void dodajZanr(Zanr zanr) {
		this.zanrovi.add(zanr);
	}
    public void izbrisiZanr(Zanr zanr) {
		this.zanrovi.remove(zanr);
	}
    public void dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
    	this.iznajmljivanja.add(iznajmljivanje);
    }
    public void izbrisiIznajmljivanje(Iznajmljivanje iznajmljivanje) {
    	this.iznajmljivanja.remove(iznajmljivanje);
    }
    public void dodajClanarinu(ClanskaKarta clanarina) {
    	this.clanarine.add(clanarina);
    }
    public void izbrisiIznajmljivanje(ClanskaKarta clanarina) {
    	this.clanarine.remove(clanarina);
    }
    
    public ArrayList<Administrator> sviNeobrisaniAdministratori() {
		ArrayList<Administrator> neobrisani = new ArrayList<Administrator>();
		for(Administrator administrator : administratori) {
			if(!administrator.isObrisan()) {
				neobrisani.add(administrator);
			}
		}
		return neobrisani;
	}
    
    public ArrayList<Bibliotekar> sviNeobrisaniBibliotekari() {
		ArrayList<Bibliotekar> neobrisani = new ArrayList<Bibliotekar>();
		for(Bibliotekar bibliotekar : bibliotekari) {
			if(!bibliotekar.isObrisan()) {
				neobrisani.add(bibliotekar);
			}
		}
		return neobrisani;
	}
    
    public ArrayList<Clan> sviNeobrisaniClanovi() {
		ArrayList<Clan> neobrisani = new ArrayList<Clan>();
		for(Clan clan : clanovi) {
			if(!clan.isObrisan()) {
				neobrisani.add(clan);
			}
		}
		return neobrisani;
	}
    
    public ArrayList<ClanskaKarta> sveNeobrisaneClanarine() {
		ArrayList<ClanskaKarta> neobrisane = new ArrayList<ClanskaKarta>();
		for(ClanskaKarta clanarina : clanarine) {
			if(!clanarina.isObrisan()) {
				neobrisane.add(clanarina);
			}
		}
		return neobrisane;
	}
    
    public ArrayList<Iznajmljivanje> svaNeobrisanaIznajmljivanja() {
		ArrayList<Iznajmljivanje> neobrisana = new ArrayList<Iznajmljivanje>();
		for(Iznajmljivanje iznajmljivanje : iznajmljivanja) {
			if(!iznajmljivanje.isObrisan()) {
				neobrisana.add(iznajmljivanje);
			}
		}
		return neobrisana;
	}
    
    public ArrayList<Knjiga> sveNeobrisaneKnjige() {
		ArrayList<Knjiga> neobrisane = new ArrayList<Knjiga>();
		for(Knjiga knjiga : knjige) {
			if(!knjiga.isObrisan()) {
				neobrisane.add(knjiga);
			}
		}
		return neobrisane;
	}
    
    public ArrayList<PrimjerakKnjige> sviNeobrisaniPrimjerci() {
		ArrayList<PrimjerakKnjige> neobrisane = new ArrayList<PrimjerakKnjige>();
		for(PrimjerakKnjige primjerak : primjerci) {
			if(!primjerak.isObrisan()) {
				neobrisane.add(primjerak);
			}
		}
		return neobrisane;
	}
    
    public ArrayList<Zanr> sviNeobrisaniZanrovi() {
		ArrayList<Zanr> neobrisani = new ArrayList<Zanr>();
		for(Zanr zanr : zanrovi) {
			if(!zanr.isObrisan()) {
				neobrisani.add(zanr);
			}
		}
		return neobrisani;
	}
    
    public Administrator login(String korisnickoIme, String lozinka) {
		for(Administrator administrator : administratori) {
			if(administrator.getKorisnicko_ime().equalsIgnoreCase(korisnickoIme) &&
					administrator.getLozinka().equals(lozinka) && !administrator.isObrisan()) {
				return administrator;
			}
		}
		return null;
	}
}