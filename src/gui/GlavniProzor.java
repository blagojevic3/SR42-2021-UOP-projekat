package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Biblioteka;
import model.Zaposleni;

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
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik ) {
		
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Glavni Prozor");
		setSize(800, 600);
		getContentPane().setBackground(Color.CYAN);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();


	}
	
	private void initMenu() {
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
