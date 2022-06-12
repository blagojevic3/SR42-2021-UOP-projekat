package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import gui.formeAddEdit.BibliotekariForma;
import main.ProjekatMain;
import model.Administrator;
import model.Biblioteka;
import model.Bibliotekar;

public class BibliotekariProzor extends JFrame{
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	
	private Biblioteka biblioteka;
	
	public BibliotekariProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Bibliotekari");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/icons/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/icons/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/icons/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa","Pol","Plata","Korisnicko ime","Lozinka"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniBibliotekari().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniBibliotekari().size(); i++) {
			Bibliotekar bibliotekar = biblioteka.sviNeobrisaniBibliotekari().get(i);
			
			sadrzaj[i][0] = bibliotekar.getId();
			sadrzaj[i][1] = bibliotekar.getIme();
			sadrzaj[i][2] = bibliotekar.getPrezime();
			sadrzaj[i][3] = bibliotekar.getJmbg();
			sadrzaj[i][4] = bibliotekar.getAdresa();
			sadrzaj[i][5] = bibliotekar.getPol();
			sadrzaj[i][6] = bibliotekar.getPlata();
			sadrzaj[i][7] = bibliotekar.getKorisnicko_ime();
			sadrzaj[i][8] = bibliotekar.getLozinka();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		bibliotekariTabela = new JTable(tableModel);
		
		bibliotekariTabela.setRowSelectionAllowed(true);
		bibliotekariTabela.setColumnSelectionAllowed(false);
		bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bibliotekariTabela.setDefaultEditor(Object.class, null);
		bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = bibliotekariTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnickoIme = tableModel.getValueAt(red, 7).toString();
					Bibliotekar bibliotekar = biblioteka.nadjiBibliotekara(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete bibliotekara?", 
							korisnickoIme + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						bibliotekar.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiBibliotekare(ProjekatMain.administratori_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariForma bf = new BibliotekariForma(biblioteka, null);
				bf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = bibliotekariTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnickoIme = tableModel.getValueAt(red, 7).toString();
					Bibliotekar bibliotekar = biblioteka.nadjiBibliotekara(korisnickoIme);
					if(bibliotekar == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja administratora sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						BibliotekariForma bf = new BibliotekariForma(biblioteka, bibliotekar);
						bf.setVisible(true);
					}
				}
			}
		});
	}
	
}
