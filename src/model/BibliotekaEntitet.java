package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class BibliotekaEntitet {
	
	private String naziv;
	private String adresa;
	private String brtelefona;
	private LocalTime pocetakRadnog;
	private LocalTime krajRadnog;
	
	public BibliotekaEntitet() {
		
		this.naziv = "";
		this.adresa = "";
		this.brtelefona = "";
		this.pocetakRadnog = LocalTime.now();
		this.krajRadnog = LocalTime.now();
	}
	public BibliotekaEntitet(String naziv, String adresa, String brtelefona, LocalTime pocetakRadnog,
			LocalTime krajRadnog) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.brtelefona = brtelefona;
		this.pocetakRadnog = pocetakRadnog;
		this.krajRadnog = krajRadnog;
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


	public String getBrtelefona() {
		return brtelefona;
	}


	public void setBrtelefona(String brtelefona) {
		this.brtelefona = brtelefona;
	}


	public LocalTime getPocetakRadnog() {
		return pocetakRadnog;
	}


	public void setPocetakRadnog(LocalTime pocetakRadnog) {
		this.pocetakRadnog = pocetakRadnog;
	}


	public LocalTime getKrajRadnog() {
		return krajRadnog;
	}


	public void setKrajRadnog(LocalTime krajRadnog) {
		this.krajRadnog = krajRadnog;
	}
	
	public BibliotekaEntitet ucitajBiblioteku(String imeFajla) {
		try {
			
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			String[] split = line.split(";");
			String naziv = split[0];
			String adresa = split[1];
			String brtelefona = split[2];
			LocalTime pocetakRadnog = LocalTime.parse(split[3]);
			LocalTime krajRadnog = LocalTime.parse(split[4]);
			BibliotekaEntitet biblioteka = new BibliotekaEntitet(naziv, adresa, brtelefona, pocetakRadnog, krajRadnog);
			reader.close();
			return biblioteka;
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja podataka biblioteke.");
			e.printStackTrace();
		}
		return null;
	}
	
	 public void snimi(BibliotekaEntitet biblioteka) {
			try {
				File file = new File("src/fajlovi/" + "biblioteka.txt");
				String content = biblioteka.getNaziv() + ";" + biblioteka.getAdresa() + ";"
				+ biblioteka.getBrtelefona() + ";" + biblioteka.getPocetakRadnog() + ";" + biblioteka.getKrajRadnog() +"\n";
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka biblioteke.");
			}
		}
}
