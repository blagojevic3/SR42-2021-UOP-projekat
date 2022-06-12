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
import model.Knjiga;
import net.miginfocom.swing.MigLayout;

public class KnjigeForma extends JFrame {
	
	private JLabel lblId = new JLabel("ID:");
	private JTextField txtId = new JTextField(20);
	private JLabel lblNaslov = new JLabel("Naslov");
	private JTextField txtNaslov = new JTextField(20);
	private JLabel lblOrigNaslov = new JLabel("Originalni Naslov");
	private JTextField txtOrigNaslov = new JTextField(20);
	private JLabel lblGodinaObjave = new JLabel("Godina objave");
	private JTextField txtGodinaObjave = new JTextField(20);
	private JLabel lblOpis = new JLabel("Opis knjige");
	private JTextField txtOpis = new JTextField(30);
	private JLabel lblIme = new JLabel("Ime pisca");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime pisca");
	private JTextField txtPrezime = new JTextField(20);

	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Knjiga knjiga;
	
	public KnjigeForma(Biblioteka biblioteka, Knjiga knjiga) {
		this.biblioteka = biblioteka;
		this.knjiga = knjiga;
		if(knjiga == null) {
			setTitle("Dodavanje Knjige");
		}else {
			setTitle("Izmjena podataka - " + knjiga.getId());
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
		
		if(knjiga != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblNaslov);
		add(txtNaslov);
		add(lblOrigNaslov);
		add(txtOrigNaslov);
		add(lblGodinaObjave);
		add(txtGodinaObjave);
		add(lblOpis);
		add(txtOpis);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);

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
					String naslov = txtNaslov.getText().trim();
					String originalni_naslov = txtOrigNaslov.getText().trim();
					int godina_objave = Integer.parseInt(txtGodinaObjave.getText().trim());;
					String opis = txtOpis.getText().trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();

					
					if(knjiga == null) { // DODAVANJE:
						Knjiga nova = new Knjiga(id, naslov, originalni_naslov, godina_objave, opis, ime, prezime);
						biblioteka.dodajKnjigu(nova);
					}else { // IZMJENA:
						
						knjiga.setId(id);
						knjiga.setNaslov(naslov);
						knjiga.setOriginalni_naslov(originalni_naslov);
						knjiga.setGodina_objave(godina_objave);
						knjiga.setOpis_knjige(opis);
						knjiga.setIme_pisca(ime);
						knjiga.setPrezime_pisca(prezime);
						
					}
					biblioteka.snimiKnjige(ProjekatMain.knjige_FAJL);
					KnjigeForma.this.dispose();
					KnjigeForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtId.setText(knjiga.getId());
		txtNaslov.setText(knjiga.getNaslov());
		txtOrigNaslov.setText(knjiga.getOriginalni_naslov());
		txtGodinaObjave.setText(String.valueOf(knjiga.getGodina_objave()));
		txtOpis.setText(knjiga.getOpis_knjige());
		txtIme.setText(knjiga.getIme_pisca());
		txtPrezime.setText(knjiga.getPrezime_pisca());


	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sljedece greske u unosu:\n";
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime pisca\n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime pisca\n";
			ok = false;
		}
		if(txtNaslov.getText().trim().equals("")) {
			poruka += "- Unesite naslov knjige\n";
			ok = false;
		}
		if(txtOrigNaslov.getText().trim().equals("")) {
			poruka += "- Unesite originalni nasov\n";
			ok = false;
		}
			else if(knjiga == null){
			String id = txtId.getText().trim();
			Knjiga pronadjena = biblioteka.nadjiKnjigu(id);
			if(pronadjena != null) {
				poruka += "- Knjiga sa tim ID-om vec postoji\n";
				ok = false;
			}
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
