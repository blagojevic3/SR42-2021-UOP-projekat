package gui.formeAddEdit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;


import enumeracije.TipKarte;
import main.ProjekatMain;

import model.Biblioteka;
import model.ClanskaKarta;
import net.miginfocom.swing.MigLayout;

public class ClanarineForma extends JFrame {
	
	private JLabel lblId = new JLabel("ID:");
	private JTextField txtId = new JTextField(20);
	private JLabel lblCijena = new JLabel("Cijena");
	private JTextField txtCijena = new JTextField(20);
	private JLabel lblTipKarte = new JLabel("Tip Karte");
	private JComboBox<TipKarte> cbTipKarte = new JComboBox<TipKarte>(TipKarte.values());
	private JLabel lblDatum = new JLabel("Datum posljednje uplate (dd-mm-gggg)");
	private JTextField txtDatum = new JTextField(13);
	private JLabel lblBrojMjeseci = new JLabel("Broj mjeseci");
	private JTextField txtBrojMjeseci = new JTextField(30);
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private ClanskaKarta clanarina;
	
	public ClanarineForma(Biblioteka biblioteka, ClanskaKarta clanarina) {
		this.biblioteka = biblioteka;
		this.clanarina = clanarina;
		if(clanarina == null) {
			setTitle("Dodavanje Clanarine...");
		}else {
			setTitle("Izmjena podataka - " + clanarina.getId());
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
		
		if(clanarina != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblCijena);
		add(txtCijena);
		add(lblTipKarte);
		add(cbTipKarte);
		add(lblDatum);
		add(txtDatum);
		add(lblBrojMjeseci);
		add(txtBrojMjeseci);

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
					double cijena = Double.parseDouble(txtCijena.getText().trim());
					TipKarte tipkarte = (TipKarte)cbTipKarte.getSelectedItem();
					String datum = txtDatum.getText().trim();
					int brojmjeseci = Integer.parseInt(txtBrojMjeseci.getText().trim());


					
					if(clanarina == null) { // DODAVANJE:
						ClanskaKarta novi = new ClanskaKarta(id, cijena, tipkarte, datum, brojmjeseci);
						biblioteka.dodajClanarinu(novi);
					}else { // IZMJENA:
						
						clanarina.setId(id);
						clanarina.setCijena(cijena);
						clanarina.setTipkarte(tipkarte);
						clanarina.setDatum_posljednje_uplate(datum);
						clanarina.setBroj_mjeseci(brojmjeseci);

					}
					biblioteka.snimiClanarine(ProjekatMain.clanarine_FAJL);
					ClanarineForma.this.dispose();
					ClanarineForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtId.setText(clanarina.getId());
		txtCijena.setText(String.valueOf(clanarina.getCijena()));
		cbTipKarte.setSelectedItem(clanarina.getTipkarte());
		txtDatum.setText(clanarina.getDatum_posljednje_uplate());
		txtBrojMjeseci.setText(String.valueOf(clanarina.getBroj_mjeseci()));


	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sljedece greske u unosu:\n";
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}else if(clanarina ==null) {
			String id = txtId.getText().trim();
			ClanskaKarta pronadjena = biblioteka.nadjiClanarinu(id);
			if(pronadjena != null) {
				poruka += "-Clanarina sa unijetim ID vec postoji\n.";
				ok = false;
			}
		}
		
		
		try {
			Double.parseDouble(txtCijena.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Cijena mora biti broj\n";
			ok = false;
		}
		if(txtDatum.getText().trim().equals("")) {
			poruka += "- Unesite Datum posljednje uplate\n";
			ok = false;
		}
			try {
				Integer.parseInt(txtBrojMjeseci.getText().trim());
			}catch (NumberFormatException e) {
				poruka += "- Broj mjeseci mora biti broj\n";
				ok = false;
			}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
		}
	}

