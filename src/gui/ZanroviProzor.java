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

import gui.formeAddEdit.ZanroviForma;
import main.ProjekatMain;
import model.Biblioteka;
import model.Zanr;

public class ZanroviProzor extends JFrame{
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;	
	private Biblioteka biblioteka;
	
	public ZanroviProzor(Biblioteka biblioteka) {
		
		this.biblioteka = biblioteka;
		setTitle("Zanrovi");
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
		
		String[] zaglavlja = new String[] {"Oznaka", "Naziv", "Opis"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniZanrovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniZanrovi().size(); i++) {
			Zanr zanr = biblioteka.sviNeobrisaniZanrovi().get(i);
			
			sadrzaj[i][0] = zanr.getOznaka();
			sadrzaj[i][1] = zanr.getNaziv();
			sadrzaj[i][2] = zanr.getOpis();


			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
		zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String oznaka = tableModel.getValueAt(red, 0).toString();
					Zanr zanr = biblioteka.nadjiZanr(oznaka);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete zanr?", 
							oznaka + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						zanr.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.izbrisiZanr(zanr);
						biblioteka.snimiZanrove(ProjekatMain.zanrovi_FAJL);

					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviForma zf = new ZanroviForma(biblioteka, null);
				zf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String oznaka = tableModel.getValueAt(red, 0).toString();
					Zanr zanr = biblioteka.nadjiZanr(oznaka);
					if(zanr == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja zanra sa tom oznakom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {

						ZanroviForma zf = new ZanroviForma(biblioteka, zanr);
						zf.setVisible(true);
					}
				}
			}
		});
	}

}
