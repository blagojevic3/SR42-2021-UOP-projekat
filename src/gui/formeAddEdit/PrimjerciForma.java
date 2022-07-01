package gui.formeAddEdit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import enumeracije.Jezik;
import enumeracije.Pol;
import enumeracije.TipPoveza;
import main.ProjekatMain;
import model.Administrator;
import model.Biblioteka;
import model.Bibliotekar;
import model.Clan;
import model.Knjiga;
import model.PrimjerakKnjige;
import net.miginfocom.swing.MigLayout;

public class PrimjerciForma extends JFrame {
	
	private JLabel lblId = new JLabel("ID:");
	private JTextField txtId = new JTextField(20);
	private JLabel lblKnjiga = new JLabel("Knjiga:");
	private JComboBox<String> cbKnjiga = new JComboBox<String>();
	private JLabel lblBrojStr = new JLabel("Broj strana: ");
	private JTextField txtBrojStr = new JTextField(20);
	private JLabel lblGodinaStampanja = new JLabel("Godina stampanja:");
	private JTextField txtGodinaStampanja = new JTextField(20);
	private JLabel lblJezik = new JLabel("Jezik stampanja:");
	private JComboBox<Jezik> cbJezik = new JComboBox<Jezik>(Jezik.values());
	private JLabel lblIznajmljena = new JLabel("Iznajmljena");
	private JCheckBox cbIznajmljena = new JCheckBox();
	private JLabel lblTip = new JLabel("Tip poveza: ");
	private JComboBox<TipPoveza> cbTip = new JComboBox<TipPoveza>(TipPoveza.values());
	
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Biblioteka knjige;
	private PrimjerakKnjige primjerak;
	
	public PrimjerciForma(Biblioteka biblioteka, PrimjerakKnjige primjerak) {
		
		this.biblioteka = biblioteka;
		this.primjerak = primjerak;
		
		this.knjige = new Biblioteka();
		this.knjige.ucitajKnjige("knjige.txt");
		for(Knjiga knjiga : knjige.sveNeobrisaneKnjige()) {
			cbKnjiga.addItem(knjiga.getId());
		}
		
		if(primjerak == null) {
			setTitle("Dodavanje Primjerka");
		}else {
			setTitle("Izmjena podataka - " + primjerak.getId());
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
		
		if(primjerak != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblKnjiga);
		add(cbKnjiga);
		add(lblBrojStr);
		add(txtBrojStr);
		add(lblGodinaStampanja);
		add(txtGodinaStampanja);
		add(lblJezik);
		add(cbJezik);
		add(lblIznajmljena);
		add(cbIznajmljena);
		add(lblTip);
		add(cbTip);

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
					String knjigaId = cbKnjiga.getSelectedItem().toString();
					Knjiga knjiga = biblioteka.nadjiKnjigu(knjigaId);
					int broj_strana = Integer.parseInt(txtBrojStr.getText().trim());
					int godina_stampanja = Integer.parseInt(txtGodinaStampanja.getText().trim());
					Jezik jezik = (Jezik)cbJezik.getSelectedItem();
					boolean iznajmljena = cbIznajmljena.isSelected();
					TipPoveza tip = (TipPoveza)cbTip.getSelectedItem();

					
					if(primjerak == null) { // DODAVANJE:
						PrimjerakKnjige novi = new PrimjerakKnjige(id, knjiga, broj_strana, godina_stampanja, jezik, iznajmljena,tip);
						biblioteka.dodajPrimjerak(novi);

					}else { // IZMJENA:
						
						primjerak.setId(id);
						primjerak.setOriginal(knjiga);
						primjerak.setBroj_strana(broj_strana);
						primjerak.setGodina_stampanja(godina_stampanja);
						primjerak.setJezik_stampanja(jezik);
						primjerak.setIznajmljena(iznajmljena);
						primjerak.setTip(tip);

					}
					biblioteka.snimiPrimjerke(ProjekatMain.primjerci_FAJL);
					PrimjerciForma.this.dispose();
					PrimjerciForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		
		txtId.setText(primjerak.getId());
		Knjiga knjiga = new Knjiga();
		cbKnjiga.setSelectedItem(knjiga.getId());
		txtBrojStr.setText(String.valueOf(primjerak.getBroj_strana()));
		txtGodinaStampanja.setText(String.valueOf(primjerak.getGodina_stampanja()));
		cbJezik.setSelectedItem(primjerak.getJezik_stampanja());
		cbIznajmljena.setSelected(primjerak.isIznajmljena());
		cbTip.setSelectedItem(primjerak.getTip());

	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sljedece greske u unosu:\n";
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}
		else if(primjerak ==null) {
			String id = txtId.getText().trim();
			PrimjerakKnjige pronadjeni = biblioteka.nadjiPrimjerak(id);
			if(pronadjeni != null) {
				poruka += "-Primjerak knjige sa unijetim ID vec postoji\n.";
				ok = false;
			}
		}
		if(txtBrojStr.getText().trim().equals("")) {
			poruka += "- Unesite broj strana\n";
			ok = false;
		}
		if(txtGodinaStampanja.getText().trim().equals("")) {
			poruka += "- Unesite godinu stampanja\n";
			ok = false;
		}

		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
