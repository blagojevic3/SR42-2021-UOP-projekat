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

import gui.formeAddEdit.AdministratoriForma;
import main.ProjekatMain;
import model.Administrator;
import model.Biblioteka;


public class AdministratoriProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable administratoriTabela;	
	private Biblioteka biblioteka;
	
	public AdministratoriProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Administratori");
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
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniAdministratori().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniAdministratori().size(); i++) {
			Administrator administrator = biblioteka.sviNeobrisaniAdministratori().get(i);
			
			sadrzaj[i][0] = administrator.getId();
			sadrzaj[i][1] = administrator.getIme();
			sadrzaj[i][2] = administrator.getPrezime();
			sadrzaj[i][3] = administrator.getJmbg();
			sadrzaj[i][4] = administrator.getAdresa();
			sadrzaj[i][5] = administrator.getPol();
			sadrzaj[i][6] = administrator.getPlata();
			sadrzaj[i][7] = administrator.getKorisnicko_ime();
			sadrzaj[i][8] = administrator.getLozinka();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		administratoriTabela = new JTable(tableModel);
		
		administratoriTabela.setRowSelectionAllowed(true);
		administratoriTabela.setColumnSelectionAllowed(false);
		administratoriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		administratoriTabela.setDefaultEditor(Object.class, null);
		administratoriTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(administratoriTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = administratoriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnickoIme = tableModel.getValueAt(red, 7).toString();
					Administrator administrator = biblioteka.nadjiAdministratora(korisnickoIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete administratora?", 
							korisnickoIme + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						administrator.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiAdministratore(ProjekatMain.administratori_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriForma af = new AdministratoriForma(biblioteka, null);
				af.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = administratoriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnickoIme = tableModel.getValueAt(red, 7).toString();
					Administrator administrator = biblioteka.nadjiAdministratora(korisnickoIme);
					if(administrator == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja administratora sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {

						AdministratoriForma af = new AdministratoriForma(biblioteka, administrator);
						af.setVisible(true);
					}
				}
			}
		});
	}
	
}
