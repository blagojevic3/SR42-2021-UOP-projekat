package gui.formeAddEdit;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.ProjekatMain;
import model.Biblioteka;
import model.BibliotekaEntitet;
import model.Knjiga;
import net.miginfocom.swing.MigLayout;

public class BibliotekaEntForma extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private BibliotekaEntitet biblioteka = new BibliotekaEntitet();
	private JLabel lblNaziv = new JLabel("Naziv:");
	private JTextField txtNaziv = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa:");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblTelefon = new JLabel("Telefon:");
	private JTextField txtTelefon = new JTextField(20);
	private JLabel lblpocetakRadnog = new JLabel("Pocetak radnog vremena:");
	private JTextField txtpocetakRadnog = new JTextField(20);
	private JLabel lblkrajRadnog = new JLabel("Kraj radnog vremena:");
	private JTextField txtkrajRadnog = new JTextField(20);
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Cancel");
	
	public BibliotekaEntForma(JFrame owner, String title, boolean modal, BibliotekaEntitet biblioteka) {
		super(owner, title, modal);
		this.biblioteka = biblioteka;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(owner);
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(velicinaEkrana.width/2, velicinaEkrana.height/2);
		biblioteka = biblioteka.ucitajBiblioteku("biblioteka.txt");
		postaviKomponente();
		akcije();
		pack();
	}
	
	public void postaviKomponente() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		txtNaziv.setText(biblioteka.getNaziv());
		txtAdresa.setText(biblioteka.getAdresa());
		txtTelefon.setText(biblioteka.getBrtelefona());
		txtpocetakRadnog.setText(biblioteka.getPocetakRadnog() + "");
		txtkrajRadnog.setText(biblioteka.getKrajRadnog() + "");
		add(lblNaziv);
		add(txtNaziv);
		add(lblAdresa);
		add(txtAdresa);
		add(lblTelefon);
		add(txtTelefon);
		add(lblpocetakRadnog);
		add(txtpocetakRadnog);
		add(lblkrajRadnog);
		add(txtkrajRadnog);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
	}
	
	public void akcije() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekaEntForma.this.dispose();
				
			}
		});
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean b = true;
				String naziv = txtNaziv.getText().trim();
				String adresa = txtAdresa.getText().trim();
				String telefon = txtTelefon.getText().trim();
				String pocetakRadnog = txtpocetakRadnog.getText().trim();
				String krajRadnog = txtkrajRadnog.getText().trim();
				
				if(naziv.equals("") || adresa.equals("") || telefon.equals("")
						|| pocetakRadnog.equals("") || krajRadnog.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste unijeli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
					b = false;
				}else {
					try {
						biblioteka.setNaziv(naziv);
						biblioteka.setAdresa(adresa);
						biblioteka.setBrtelefona(telefon);
						biblioteka.setPocetakRadnog(LocalTime.parse(pocetakRadnog));
						biblioteka.setKrajRadnog(LocalTime.parse(krajRadnog));
						biblioteka.snimiBiblioteku(biblioteka);
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Niste unijeli pravilne podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
						b = false;
					}
				}
				if(b == true)
					dispose();
			}
		});
	}
	
}
