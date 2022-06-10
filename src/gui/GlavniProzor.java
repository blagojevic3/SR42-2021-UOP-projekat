package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Biblioteka;

public class GlavniProzor extends JFrame{
	
	private JMenuBar glavniMeni = new JMenuBar();
	private JMenu zaposleniMenu = new JMenu("Zaposleni");
	private JMenu knjigeMenu = new JMenu("Knjige");
	private JMenu clanoviMenu = new JMenu("Clanovi");
	private JMenuItem administatoriItem = new JMenuItem("Administratori");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	private JMenuItem clanoviItem = new JMenuItem("Clanovi");
	private JMenuItem tipoviClanarineItem = new JMenuItem("Tipovi clanarine");
	private JMenuItem originaliItem = new JMenuItem("Originali");
	private JMenuItem primjerciItem = new JMenuItem("Primjerci");
	private JMenuItem zanroviItem = new JMenuItem("Zanrovi");
	private JMenuItem iznajmljivanjaItem = new JMenuItem("Iznajmljivanja");
	
	private Biblioteka biblioteka;
	
	
	public GlavniProzor() {
		
		this.biblioteka = biblioteka;
		setTitle("Glavni Prozor");
		setSize(800, 600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();


	}
	
	private void initMenu() {
		setJMenuBar(glavniMeni);
		glavniMeni.add(zaposleniMenu);
		glavniMeni.add(clanoviMenu);
		glavniMeni.add(knjigeMenu);
		zaposleniMenu.add(administatoriItem);
		zaposleniMenu.add(bibliotekariItem);
		clanoviMenu.add(clanoviItem);
		clanoviMenu.add(tipoviClanarineItem);
		knjigeMenu.add(originaliItem);
		knjigeMenu.add(primjerciItem);
		knjigeMenu.add(zanroviItem);
		knjigeMenu.add(iznajmljivanjaItem);
		
		

		
		
				
	}
	
	
	
	
	
	
	
}
