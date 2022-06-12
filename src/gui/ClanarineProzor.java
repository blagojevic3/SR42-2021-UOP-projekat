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

import gui.formeAddEdit.ClanarineForma;
import main.ProjekatMain;
import model.Biblioteka;
import model.ClanskaKarta;

public class ClanarineProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanarineTabela;	
	private Biblioteka biblioteka;
	
	public ClanarineProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Clanarine");
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
		
		String[] zaglavlja = new String[] {"ID", "Cijena", "Tip Karte", "Datum posljednje uplate (dd-mm-gggg)", "Broj mjeseci"};
		Object[][] sadrzaj = new Object[biblioteka.sveNeobrisaneClanarine().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sveNeobrisaneClanarine().size(); i++) {
			ClanskaKarta clanarina = biblioteka.sveNeobrisaneClanarine().get(i);
			
			sadrzaj[i][0] = clanarina.getId();
			sadrzaj[i][1] = clanarina.getCijena();
			sadrzaj[i][2] = clanarina.getTipkarte();
			sadrzaj[i][3] = clanarina.getDatum_posljednje_uplate();
			sadrzaj[i][4] = clanarina.getBroj_mjeseci();

			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanarineTabela = new JTable(tableModel);
		
		clanarineTabela.setRowSelectionAllowed(true);
		clanarineTabela.setColumnSelectionAllowed(false);
		clanarineTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanarineTabela.setDefaultEditor(Object.class, null);
		clanarineTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanarineTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanarineTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					ClanskaKarta clanarina = biblioteka.nadjiClanarinu(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete clanarinu?", 
							id + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						clanarina.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.izbrisiClanarinu(clanarina);
						biblioteka.snimiClanarine(ProjekatMain.clanarine_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanarineForma cf = new ClanarineForma(biblioteka, null);
				cf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanarineTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					ClanskaKarta clanarina = biblioteka.nadjiClanarinu(id);
					if(clanarina == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja administratora sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {

						ClanarineForma cf = new ClanarineForma(biblioteka, clanarina);
						cf.setVisible(true);
					}
				}
			}
		});
	}
}
