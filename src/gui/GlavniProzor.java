package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Biblioteka;
import model.BibliotekaEntitet;
import model.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class GlavniProzor extends JFrame{
	
	private JMenuBar glavniMeni = new JMenuBar();
	private JMenu zaposleniMenu = new JMenu("Zaposleni");
	private JMenu knjigeMenu = new JMenu("Knjige");
	private JMenu clanoviMenu = new JMenu("Clanovi");
	private JMenuItem administratoriItem = new JMenuItem("Administratori");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	private JMenuItem clanoviItem = new JMenuItem("Clanovi");
	private JMenuItem tipoviClanarineItem = new JMenuItem("Tipovi clanarine");
	private JMenuItem originaliItem = new JMenuItem("Originali");
	private JMenuItem primjerciItem = new JMenuItem("Primjerci");
	private JMenuItem zanroviItem = new JMenuItem("Zanrovi");
	private JMenuItem iznajmljivanjaItem = new JMenuItem("Iznajmljivanja");
	
	private JLabel lblnaziv = new JLabel();
	private JLabel lbladresa = new JLabel();
	private JLabel lbltelefon = new JLabel();
	private JLabel lblpocetakRadnog = new JLabel();
	private JLabel lblkrajRadnog = new JLabel();
	private JButton btnEdit = new JButton();
	
	
	private JLabel lblGreet = new JLabel("Dobrodosli!");
	
	
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	private BibliotekaEntitet bibliotekaInfo = new BibliotekaEntitet();
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik ) {
		
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Glavni Prozor: "+ prijavljeniKorisnik.getKorisnicko_ime());
		setSize(800, 600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		bibliotekaInfo = bibliotekaInfo.ucitajBiblioteku("biblioteka.txt");
		ucitavanje();
		initMenu();
		initActions();


	}
	public void ucitavanje() {
		
		lblnaziv.setText("Naziv: " + bibliotekaInfo.getNaziv());
		lbladresa.setText("Adresa: " + bibliotekaInfo.getAdresa());
		lbltelefon.setText("Telefon: " + bibliotekaInfo.getBrtelefona());
		lblpocetakRadnog.setText("Pocetak radnog vremena: " + bibliotekaInfo.getPocetakRadnog());
		lblkrajRadnog.setText("Kraj radnog vremena: " + bibliotekaInfo.getKrajRadnog());
	}
	
	private void initMenu() {
		MigLayout layout = new MigLayout("wrap 1");
		setLayout(layout);
		setJMenuBar(glavniMeni);
		glavniMeni.add(zaposleniMenu);
		glavniMeni.add(clanoviMenu);
		glavniMeni.add(knjigeMenu);
		zaposleniMenu.add(administratoriItem);
		zaposleniMenu.add(bibliotekariItem);
		clanoviMenu.add(clanoviItem);
		clanoviMenu.add(tipoviClanarineItem);
		knjigeMenu.add(originaliItem);
		knjigeMenu.add(primjerciItem);
		knjigeMenu.add(zanroviItem);
		knjigeMenu.add(iznajmljivanjaItem);
		add(lblGreet);
		add(lblnaziv);
		add(lbladresa);
		add(lbltelefon);
		add(lblpocetakRadnog);
		add(lblkrajRadnog);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/icons/edit.gif"));
		btnEdit.setIcon(editIcon);
		
		
			
	}
	
	private void initActions() {
		
		administratoriItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriProzor ap = new AdministratoriProzor(biblioteka);
				ap.setVisible(true);
			}
		});
		
		bibliotekariItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariProzor bp = new BibliotekariProzor(biblioteka);
				bp.setVisible(true);
			}
		});
		
		tipoviClanarineItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanarineProzor cp = new ClanarineProzor(biblioteka);
				cp.setVisible(true);
			}
		});
		
		clanoviItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanoviProzor clanp = new ClanoviProzor(biblioteka);
				clanp.setVisible(true);
			}
		});
		
		originaliItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor originalp = new KnjigeProzor(biblioteka);
				originalp.setVisible(true);
			}
		});
		
		primjerciItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimjerciProzor pp = new PrimjerciProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		
		zanroviItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviProzor zp = new ZanroviProzor(biblioteka);
				zp.setVisible(true);
			}
		});
		
		iznajmljivanjaItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjaProzor ip = new IznajmljivanjaProzor(biblioteka);
				ip.setVisible(true);
			}
		});
		
		

	}
	
	
	
	
	
	
}
