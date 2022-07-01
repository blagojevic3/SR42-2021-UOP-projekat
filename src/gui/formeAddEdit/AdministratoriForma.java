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
import model.Administrator;
import model.Biblioteka;
import model.ClanskaKarta;
//import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;


public class AdministratoriForma extends JFrame {
	
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
	private Administrator administrator;
	
	public AdministratoriForma(Biblioteka biblioteka, Administrator administrator) {
		this.biblioteka = biblioteka;
		this.administrator = administrator;
		if(administrator == null) {
			setTitle("Dodavanje Administratora");
		}else {
			setTitle("Izmjena podataka - " + administrator.getKorisnicko_ime());
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
		
		if(administrator != null) {
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

					
					if(administrator == null) { // DODAVANJE:
						Administrator novi = new Administrator(id, ime, prezime, jmbg, adresa, pol, plata, korisnicko_ime, lozinka);
						biblioteka.dodajAdministratora(novi);
					}else { // IZMJENA:
						
						administrator.setId(id);
						administrator.setIme(ime);
						administrator.setPrezime(prezime);
						administrator.setJmbg(jmbg);
						administrator.setAdresa(adresa);
						administrator.setPol(pol);
						administrator.setPlata(plata);
						administrator.setKorisnicko_ime(korisnicko_ime);
						administrator.setLozinka(lozinka);
					}
					biblioteka.snimiAdministratore(ProjekatMain.administratori_FAJL);
					AdministratoriForma.this.dispose();
					AdministratoriForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtId.setText(administrator.getId());
		txtIme.setText(administrator.getIme());
		txtPrezime.setText(administrator.getPrezime());
		txtJmbg.setText(administrator.getJmbg());
		txtAdresa.setText(administrator.getJmbg());
		cbPol.setSelectedItem(administrator.getPol());
		txtPlata.setText(administrator.getPlata());
		txtKorisnickoIme.setText(administrator.getKorisnicko_ime());
		afLozinka.setText(administrator.getLozinka());

	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}
		else if(administrator ==null) {
			String id = txtId.getText().trim();
			Administrator pronadjeni = biblioteka.nadjiAdministratora(id);
			if(pronadjeni != null) {
				poruka += "-Administrator sa unijetim ID vec postoji\n.";
				ok = false;
			}
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
		if(txtJmbg.getText().trim().length() != 13) {
			poruka +="-JMBG nije validan, mora imati tacno 13 znakova.";
			ok = false;
		}
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
		}
		if(txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}else if(administrator == null){
			String korisnickoIme = txtKorisnickoIme.getText().trim();
			Administrator pronadjeni = biblioteka.nadjiAdministratora(korisnickoIme);
			if(pronadjeni != null) {
				poruka += "- Administrator sa tim korisnickim imenom vec postoji\n";
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
