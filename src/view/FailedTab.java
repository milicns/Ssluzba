package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import gui.AbstractTableModelFailed;
import gui.FailedJTable;
import gui.MainFrame;
//import model.FailedSubjects;    KOMENTAR OVDE 
import model.Student;
import model.StudentsDatabase;
import model.Subject;

public class FailedTab extends JPanel{
	
	private Student student;
	private JButton add;
	private JButton delete;
	private JButton exam;
	private FailedJTable failed;
	private JPanel btnPnl;
	private JPanel table;
	
	private static FailedTab instance = null;
	public static FailedTab getInstance() {
		if (instance == null) {
			instance = new FailedTab();
		}
		return instance;
	}
	
	private FailedTab() {}
	
	public FailedTab(EditPane parent, int row) {
		
		initGui();
		constructGui();
		buttonActions(this, row);
		
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());
		btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		table = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		failed = new FailedJTable();
		
		add = new JButton("Dodaj");
		delete = new JButton("Obriši");
		exam = new JButton("Polaganje");
	}
	
	
	private void constructGui() {
		
		JScrollPane sp = new JScrollPane(failed);
		table.add(sp);
		add(table, BorderLayout.CENTER);
		
		btnPnl.add(Box.createHorizontalStrut(10));
		btnPnl.add(add);
		btnPnl.add(delete);
		btnPnl.add(exam);
		add(btnPnl,BorderLayout.NORTH);
		
	}
	
	private void buttonActions(FailedTab ft, int row) {
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//StudentSubjectDialog sbd = new StudentSubjectDialog(ft, true,StudentsDatabase.getInstance().getRow(row).getIndex());
				//sbd.setVisible(true);
			}
			
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(failed.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(ft, "Izaberite predmet za brisanje");
				} else {
				String[] options = {"Da", "Ne"};
				int d = JOptionPane.showOptionDialog(ft,"Da li ste sigurni da želite da obrišete predmet?", "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");
				if(d == JOptionPane.YES_OPTION) {
					int row1 = getTable().getSelectedRow();
					student = StudentsDatabase.getInstance().getRow(row);
					String id = student.getFailedSubjects().get(row1).getSubjectCode();
					StudentController.getInstance().removeSubjectFromStudent(student,id);
					refreshTable();
				}
				}
			}
			
		});
		
	}
	

   public void refreshTable() {
	 AbstractTableModelFailed model = (AbstractTableModelFailed) failed.getModel();
	 model.fireTableDataChanged();
   }
	
   public FailedJTable getTable() {
	  return failed;
  
   }

}
