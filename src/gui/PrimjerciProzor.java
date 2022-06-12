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

import gui.formeAddEdit.PrimjerciForma;
import main.ProjekatMain;

import model.Biblioteka;
import model.PrimjerakKnjige;

public class PrimjerciProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable primjerciTabela;	
	private Biblioteka biblioteka;
	
	public PrimjerciProzor(Biblioteka biblioteka) {
		
		this.biblioteka = biblioteka;
		setTitle("Primjerci knjiga");
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
		
		String[] zaglavlja = new String[] {"ID", "Original", "Broj strana", "Godina stampanja", "Jezik stampanja","Iznajmljena","Tip poveza"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimjerci().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniPrimjerci().size(); i++) {
			PrimjerakKnjige primjerak = biblioteka.sviNeobrisaniPrimjerci().get(i);
			
			sadrzaj[i][0] = primjerak.getOriginal();
			sadrzaj[i][1] = primjerak.getBroj_strana();
			sadrzaj[i][2] = primjerak.getGodina_stampanja();
			sadrzaj[i][3] = primjerak.getJezik_stampanja();
			sadrzaj[i][4] = primjerak.isIznajmljena();
			sadrzaj[i][5] = primjerak.getTip();

			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primjerciTabela = new JTable(tableModel);
		
		primjerciTabela.setRowSelectionAllowed(true);
		primjerciTabela.setColumnSelectionAllowed(false);
		primjerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primjerciTabela.setDefaultEditor(Object.class, null);
		primjerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primjerciTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primjerciTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					PrimjerakKnjige primjerak = biblioteka.nadjiPrimjerak(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete primjerak?", 
							id + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						primjerak.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.izbrisiPrimjerak(primjerak);
						biblioteka.snimiPrimjerke(ProjekatMain.primjerci_FAJL);

					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimjerciForma pf = new PrimjerciForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primjerciTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					PrimjerakKnjige primjerak = biblioteka.nadjiPrimjerak(id);
					if(primjerak == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja primjerka sa ID-om", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {

						PrimjerciForma pf = new PrimjerciForma(biblioteka, primjerak);
						pf.setVisible(true);
					}
				}
			}
		});
	}

}
