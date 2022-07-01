package gui.formeAddEdit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.ProjekatMain;
import model.Administrator;
import model.Biblioteka;
import model.Knjiga;
import model.Zanr;
import net.miginfocom.swing.MigLayout;

public class ZanroviForma extends JFrame{
	
	private JLabel lblOznaka = new JLabel("Oznaka:");
	private JTextField txtOznaka = new JTextField(20);
	private JLabel lblNaziv = new JLabel("Naziv");
	private JTextField txtNaziv = new JTextField(20);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);


	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Zanr zanr;
	
	public ZanroviForma(Biblioteka biblioteka, Zanr zanr) {
		
		this.biblioteka = biblioteka;
		this.zanr = zanr;
		if(zanr == null) {
			setTitle("Dodavanje Zanra");
		}else {
			setTitle("Izmjena podataka - " + zanr.getOznaka());
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
		
		if(zanr != null) {
			popuniPolja();
		}
		
		add(lblOznaka);
		add(txtOznaka);
		add(lblNaziv);
		add(txtNaziv);
		add(lblOpis);
		add(txtOpis);


		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					
					String oznaka = txtOznaka.getText().trim();
					String naziv = txtNaziv.getText().trim();
					String opis = txtOpis.getText().trim();


					
					if(zanr == null) { // DODAVANJE:
						Zanr novi = new Zanr(oznaka, naziv, opis);
						biblioteka.dodajZanr(novi);
					}else { // IZMJENA:
						
						zanr.setOznaka(oznaka);
						zanr.setNaziv(naziv);
						zanr.setOpis(opis);

						
					}
					biblioteka.snimiZanrove(ProjekatMain.zanrovi_FAJL);
					ZanroviForma.this.dispose();
					ZanroviForma.this.setVisible(false);
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtOznaka.setText(zanr.getOznaka());
		txtNaziv.setText(zanr.getNaziv());
		txtOpis.setText(zanr.getOpis());
		


	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sljedece greske u unosu:\n";
		
		
		if(txtOznaka.getText().trim().equals("")) {
			poruka += "- Unesite oznaku\n";
			ok = false;
		}
		else if(zanr ==null) {
			String oznaka = txtOznaka.getText().trim();
			Zanr pronadjeni = biblioteka.nadjiZanr(oznaka);
			if(pronadjeni != null) {
				poruka += "-Zanr sa unijetom oznakom vec postoji\n.";
				ok = false;
			}
		}
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Unesite opis\n";
			ok = false;
		}
		if(txtNaziv.getText().trim().equals("")) {
			poruka += "- Unesite naziv\n";
			ok = false;
		}
		else if(zanr == null){
			String naziv = txtNaziv.getText().trim();
			Zanr pronadjeni = biblioteka.nadjiZanr(naziv);
			if(pronadjeni != null) {
				poruka += "- Zanr sa tim nazivom vec postoji\n";
				ok = false;
			}
		}
		
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}

}
