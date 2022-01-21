package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ProfessorController;
import gui.FailedJTable;
import gui.MainFrame;
import gui.ProfessorSubjectsATM;
import gui.ProfessorSubjectsJTable;
import model.Professor;
import model.ProfessorDatabase;
import model.ProfessorSubjectsDatabase;
import model.StudentsDatabase;
import model.Subject;
import model.SubjectDatabase;

public class ProfessorSubjectsTab extends JPanel{
	
	private JButton add;
	private JButton delete;
	private ProfessorSubjectsJTable subJTable;
	private JPanel btnPnl;
	private JPanel table;
	private Professor prof;
	private ProfessorSubjectsDatabase psd;
	
	public ProfessorSubjectsTab(JDialog parent, int row) {
		initGui();
		constructGui();
		buttonActions(this,row);
		
	}

	private void initGui() {
		
		setLayout(new BorderLayout());
		btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		table = new JPanel(new FlowLayout(FlowLayout.CENTER));
		subJTable = new ProfessorSubjectsJTable();
		
		add = new JButton("Dodaj");
		delete = new JButton("Obriši");
	}
	
	private void constructGui() {
		
		JScrollPane sp = new JScrollPane(subJTable);
		table.add(sp);
		add(table, BorderLayout.CENTER);
		
		btnPnl.add(Box.createHorizontalStrut(10));
		btnPnl.add(add);
		btnPnl.add(delete);
		add(btnPnl,BorderLayout.NORTH);
		
	}
	
	private void buttonActions(ProfessorSubjectsTab parent, int row) {
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorSubjectDialog psd = new ProfessorSubjectDialog(parent,true, row);
				psd.setVisible(true);
				
			}
			
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(subJTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(parent, "Izaberite predmet ili više za brisanje");
				}else {
				String[] options = {"Da", "Ne"};
				int d = JOptionPane.showOptionDialog(parent,"Da li ste sigurni da želite da obrišete predmet?", "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");
				if(d == JOptionPane.YES_OPTION) {
					
					prof = ProfessorDatabase.getInstance().getRow(row);
					psd = new ProfessorSubjectsDatabase(prof);
					
					if(subJTable.getSelectedRowCount() == 1) {
					
					String id = prof.getProfessorSubjects().get(subJTable.getSelectedRow()).getSubjectCode();
					ProfessorController.getInstance().removeSubjectFromProfessor(prof, id);
					
						
					} else if(subJTable.getSelectedRowCount() > 1){
						
						int[] rows = subJTable.getSelectedRows();
						ArrayList<String> ids = new ArrayList<String>();
						for(int i = 0; i < rows.length; i++) {
							String temp = subJTable.getValueAt(rows[i], 0).toString();
							ids.add(temp);
						}
						
						for(String id: ids) {
						    ProfessorController.getInstance().removeSubjectFromProfessor(prof, id);
						}
					}
					refresh();
				}			
				
				}
		}});
		
	}
	
	public void refresh() {
		ProfessorSubjectsATM model = (ProfessorSubjectsATM) subJTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
}
