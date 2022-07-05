package gui.formeAddEdit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enumeracije.Jezik;
import enumeracije.TipPoveza;
import main.ProjekatMain;
import model.Administrator;
import model.Biblioteka;
import model.Bibliotekar;
import model.Clan;
import model.Iznajmljivanje;
import model.Knjiga;
import model.PrimjerakKnjige;
import model.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class IznajmljivanjaForma extends JFrame{
	
	private JLabel lblId = new JLabel("ID:");
	private JTextField txtId = new JTextField(20);
	private JLabel lblDIznajmljivanja = new JLabel("Datum iznajmljivanja(dd-mm-gggg):");
	private JTextField txtDIznajmljivanja = new JTextField(20);
	private JLabel lblDVracanja = new JLabel("Datum vracanja(dd-mm-gggg):");
	private JTextField txtDVracanja = new JTextField(20);
	private JLabel lblZaposleni = new JLabel("Zaposleni: ");
	private JComboBox<String> cbZaposleni = new JComboBox<String>();
	private JLabel lblClan = new JLabel("Clan: ");
	private JComboBox<String> cbClan = new JComboBox<String>();
	private JLabel lblPrimjerak = new JLabel("Primjerak: ");
	private JComboBox<String> cbPrimjerak = new JComboBox<String>();
	private Biblioteka bibliotekari;
	private Biblioteka clanovi;
	private Biblioteka primjerci;

	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Iznajmljivanje iznajmljivanje;
	
	public IznajmljivanjaForma(Biblioteka biblioteka, Iznajmljivanje iznajmljivanje) {
		
		this.biblioteka = biblioteka;
		this.iznajmljivanje = iznajmljivanje;
		
		this.bibliotekari = new Biblioteka();
		this.bibliotekari.ucitajBibliotekare("bibliotekari.txt");
		for(Bibliotekar bibliotekar : bibliotekari.sviNeobrisaniBibliotekari()) {
			cbZaposleni.addItem(bibliotekar.getId());
		}
		this.clanovi = new Biblioteka();
		this.clanovi.ucitajClanove("clanovi.txt");
		for(Clan clan : clanovi.sviNeobrisaniClanovi()) {
			cbClan.addItem(clan.getId());
		}
		
		this.primjerci = new Biblioteka();
		this.primjerci.ucitajPrimjerke("primjerci.txt");
		for(PrimjerakKnjige primjerak : primjerci.sviNeobrisaniPrimjerci()) {
			if(primjerak.isIznajmljena() == false)
				cbPrimjerak.addItem(primjerak.getId());
		}
		if(iznajmljivanje == null) {
			setTitle("Dodavanje Iznajmljivanja");
		}else {
			setTitle("Izmjena podataka - " + iznajmljivanje.getId());
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
		
		if(iznajmljivanje != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblDIznajmljivanja);
		add(txtDIznajmljivanja);
		add(lblDVracanja);
		add(txtDVracanja);
		add(lblZaposleni);
		add(cbZaposleni);
		add(lblClan);
		add(cbClan);
		add(lblPrimjerak);
		add(cbPrimjerak);

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
					String datumIznajmljivanja = txtDIznajmljivanja.getText().trim();
					String datumVracanja = txtDVracanja.getText().trim();
					String idZaposleni = cbZaposleni.getSelectedItem().toString();
					Bibliotekar bibliotekar = biblioteka.nadjiBibliotekara(idZaposleni);
					String idClan = cbClan.getSelectedItem().toString();
					Clan clan = biblioteka.nadjiClana(idClan);
					String idPrimjerak = cbPrimjerak.getSelectedItem().toString();
					PrimjerakKnjige primjerak = biblioteka.nadjiPrimjerak(idPrimjerak);


					
					if(primjerak == null) { // DODAVANJE:
						Iznajmljivanje novo = new Iznajmljivanje(id, datumIznajmljivanja, datumVracanja, bibliotekar, clan, primjerak);
						biblioteka.dodajIznajmljivanje(novo);

					}else { // IZMJENA:
						
						iznajmljivanje.setId(id);
						iznajmljivanje.setDatum_iznajmljivanja(datumIznajmljivanja);
						iznajmljivanje.setDatum_vracanja(datumVracanja);
						iznajmljivanje.setZaposleni(bibliotekar);
						iznajmljivanje.setClan(clan);
						iznajmljivanje.setPrimjerak(primjerak);
						


					}
					biblioteka.snimiIznajmljivanje(ProjekatMain.iznajmljivanja_FAJL);
					IznajmljivanjaForma.this.dispose();
					IznajmljivanjaForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		
		txtId.setText(iznajmljivanje.getId());
		txtDIznajmljivanja.setText(iznajmljivanje.getDatum_iznajmljivanja());
		txtDVracanja.setText(iznajmljivanje.getDatum_vracanja());
		cbZaposleni.setSelectedItem(iznajmljivanje.getZaposleni().getId());
		cbClan.setSelectedItem(iznajmljivanje.getClan().getId());
		if(!(cbPrimjerak.getItemCount()== 0)) {
			
			cbPrimjerak.addItem(iznajmljivanje.getPrimjerak().getId());
		}



	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sljedece greske u unosu:\n";
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}
		else if(iznajmljivanje == null){
			String id = txtId.getText().trim();
			Iznajmljivanje pronadjeno = biblioteka.nadjiIznajmljivanje(id);
			if(pronadjeno != null) {
				poruka += "- Iznajmljivanje sa tim ID-om vec postoji\n";
				ok = false;
			}
		}
		if(txtDIznajmljivanja.getText().trim().equals("")) {
			poruka += "- Unesite datum iznajmljivanja\n";
			ok = false;
		}
		if(txtDVracanja.getText().trim().equals("")) {
			poruka += "- Unesite datum vracanja\n";
			ok = false;
		}

		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
