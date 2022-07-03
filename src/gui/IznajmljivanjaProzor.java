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

import gui.formeAddEdit.IznajmljivanjaForma;
import main.ProjekatMain;
import model.Biblioteka;
import model.Iznajmljivanje;

public class IznajmljivanjaProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjaTabela;	
	private Biblioteka biblioteka;
	
	public IznajmljivanjaProzor(Biblioteka biblioteka) {
		
		this.biblioteka = biblioteka;
		setTitle("Iznajmljivanja");
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
		
		String[] zaglavlja = new String[] {"ID", "Datum iznajmljivanja(dd-mm-gggg)", "Datum vracanja (dd-mm-gggg)", "Zaposleni", "Clan","Primjerak knjige"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimjerci().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniPrimjerci().size(); i++) {
			Iznajmljivanje iznajmljivanje = biblioteka.svaNeobrisanaIznajmljivanja().get(i);
			
			sadrzaj[i][0] = iznajmljivanje.getId();
			sadrzaj[i][1] = iznajmljivanje.getDatum_iznajmljivanja();
			sadrzaj[i][2] = iznajmljivanje.getDatum_vracanja();
			sadrzaj[i][3] = iznajmljivanje.getZaposleni();
			sadrzaj[i][4] = iznajmljivanje.getClan();
			sadrzaj[i][5] = iznajmljivanje.getPrimjerak();

			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		iznajmljivanjaTabela = new JTable(tableModel);
		
		iznajmljivanjaTabela.setRowSelectionAllowed(true);
		iznajmljivanjaTabela.setColumnSelectionAllowed(false);
		iznajmljivanjaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iznajmljivanjaTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Iznajmljivanje iznajmljivanje = biblioteka.nadjiIznajmljivanje(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete iznajmljivanje?", 
							  " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						iznajmljivanje.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.izbrisiIznajmljivanje(iznajmljivanje);
						biblioteka.snimiIznajmljivanje(ProjekatMain.iznajmljivanja_FAJL);

					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjaForma iznf = new IznajmljivanjaForma(biblioteka, null);
				iznf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Iznajmljivanje iznajmljivanje = biblioteka.nadjiIznajmljivanje(id);
					if(iznajmljivanje == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja iznajmljivanja sa ID-om", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {

						IznajmljivanjaForma iznf = new IznajmljivanjaForma(biblioteka, iznajmljivanje);
						iznf.setVisible(true);
					}
				}
			}
		});
	}
}
