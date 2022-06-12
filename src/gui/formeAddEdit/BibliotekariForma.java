package gui.formeAddEdit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import enumeracije.Pol;
import main.ProjekatMain;
import model.Biblioteka;
import model.Bibliotekar;
import net.miginfocom.swing.MigLayout;

public class BibliotekariForma extends JFrame {
	
	private JLabel lblId = new JLabel("ID:");
	private JTextField txtId = new JTextField(20);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(13);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(30);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField afLozinka = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Bibliotekar bibliotekar;
	
	public BibliotekariForma(Biblioteka biblioteka, Bibliotekar bibliotekar) {
		this.biblioteka = biblioteka;
		this.bibliotekar = bibliotekar;
		if(bibliotekar == null) {
			setTitle("Dodavanje Bibliotekara");
		}else {
			setTitle("Izmjena podataka - " + bibliotekar.getKorisnicko_ime());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(bibliotekar != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cbPol);
		add(lblPlata);
		add(txtPlata);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(afLozinka);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					
					String id = txtId.getText().trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String plata = txtPlata.getText().trim();
					String korisnicko_ime = txtKorisnickoIme.getText().trim();
					String lozinka = new String(afLozinka.getPassword()).trim();

					
					if(bibliotekar == null) { // DODAVANJE:
						Bibliotekar novi = new Bibliotekar(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime, lozinka);
						biblioteka.dodajBibliotekara(novi);
					}else { // IZMJENA:
						
						bibliotekar.setId(id);
						bibliotekar.setIme(ime);
						bibliotekar.setPrezime(prezime);
						bibliotekar.setJmbg(jmbg);
						bibliotekar.setAdresa(adresa);
						bibliotekar.setPol(pol);
						bibliotekar.setPlata(plata);
						bibliotekar.setKorisnicko_ime(korisnicko_ime);
						bibliotekar.setLozinka(lozinka);
					}
					biblioteka.snimiAdministratore(ProjekatMain.bibliotekari_FAJL);
					BibliotekariForma.this.dispose();
					BibliotekariForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtId.setText(bibliotekar.getId());
		txtIme.setText(bibliotekar.getIme());
		txtPrezime.setText(bibliotekar.getPrezime());
		txtJmbg.setText(bibliotekar.getJmbg());
		txtAdresa.setText(bibliotekar.getJmbg());
		cbPol.setSelectedItem(bibliotekar.getPol());
		txtPlata.setText(bibliotekar.getPlata());
		txtKorisnickoIme.setText(bibliotekar.getKorisnicko_ime());
		afLozinka.setText(bibliotekar.getLozinka());

	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime\n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime\n";
			ok = false;
		}
		if(txtJmbg.getText().trim().equals("")) {
			poruka += "- Unesite JMBG\n";
			ok = false;
		}
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
		}
		if(txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}else if(bibliotekar == null){
			String korisnickoIme = txtKorisnickoIme.getText().trim();
			Bibliotekar pronadjeni = biblioteka.nadjiBibliotekara(korisnickoIme);
			if(pronadjeni != null) {
				poruka += "- Bibliotekar sa tim korisnickim imenom vec postoji\n";
				ok = false;
			}
		}
		
		String sifra = new String(afLozinka.getPassword()).trim();
		if(sifra.equals("")) {
			poruka += "- Unesite lozinku\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
}
