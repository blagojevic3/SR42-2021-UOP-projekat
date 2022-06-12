package gui.formeAddEdit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import main.ProjekatMain;
import model.Clan;
import model.Biblioteka;
import net.miginfocom.swing.MigLayout;

public class ClanoviForma extends JFrame{
	
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
	
	
	private JLabel lblAktivan = new JLabel("Aktivan");
	private JComboBox<Boolean> cbAktivan = new JComboBox<>();
	private Vector<Boolean> cbAktivanItems;
	
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Clan clan;
	
	public ClanoviForma(Biblioteka biblioteka, Clan clan) {
		
		this.biblioteka = biblioteka;
		this.clan = clan;
		cbAktivanItems = new Vector<Boolean>();
		cbAktivanItems.add(Boolean.TRUE);
		cbAktivanItems.add(Boolean.FALSE);
		
		if(clan == null) {
			setTitle("Dodavanje Clana");
		}else {
			setTitle("Izmjena podataka - " + clan.getId());
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
		
		if(clan != null) {
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
		add(lblAktivan);
		add(cbAktivan);

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
					Boolean aktivan = (Boolean)cbAktivan.getSelectedItem();

					
					if(clan == null) { // DODAVANJE:
						Clan novi = new Clan(id, ime, prezime, jmbg, adresa, aktivan);
						biblioteka.dodajClana(novi);
					}else { // IZMJENA:
						
						clan.setId(id);
						clan.setIme(ime);
						clan.setPrezime(prezime);
						clan.setJmbg(jmbg);
						clan.setAdresa(adresa);
						clan.setAktivan(aktivan);

					}
					biblioteka.snimiClanove(ProjekatMain.clanovi_FAJL);
					ClanoviForma.this.dispose();
					ClanoviForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtId.setText(clan.getId());
		txtIme.setText(clan.getIme());
		txtPrezime.setText(clan.getPrezime());
		txtJmbg.setText(clan.getJmbg());
		txtAdresa.setText(clan.getJmbg());
		cbAktivan.setSelectedItem(cbAktivan.getSelectedItem());


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

		

		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
}
