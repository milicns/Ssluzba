package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.DepartmentController;
import controller.StudentController;
import model.Department;
import model.DepartmentDatabase;
import model.FailedSubjects;
import model.PassedSubjects;
import model.Professor;
import model.Professor.Title;
import model.ProfessorDatabase;
import model.Student;
import model.Subject;
import model.SubjectDatabase;
import view.FailedTab;

public class DMDialog extends JDialog {
	
	private JList<String> profList;
	private JButton add;
	private JButton quit;
	private JPanel pnl;
	private JPanel btnPnl;
	private Department d;
	DefaultListModel<String> profName;
	
	public DMDialog(JDialog parent, String title, boolean modal, int row) {
		setSize(400,400);
		setTitle(title);
		setLocationRelativeTo(parent);
		d = DepartmentDatabase.getInstance().getRow(row);
		conditions();
		constructGui();
		buttonActions(parent);
	}
	
	private void constructGui(){

		profList = new JList<>();
		profList.setModel(profName);
		profList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JScrollPane sp = new JScrollPane(profList);
		
		pnl.add(sp);
		add(pnl, BorderLayout.NORTH);
		
		add = new JButton("Dodaj");
		quit = new JButton("Odustani");
		
		btnPnl.add(add);
		btnPnl.add(quit);
		add(btnPnl, BorderLayout.SOUTH);
		
	}
	
	private void buttonActions(JDialog parent) {
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
			 if(profList.getSelectedIndex() == -1) {
				 JOptionPane.showMessageDialog(parent, "Izaberite predmet za dodavanje");
			 } else {
			 String[] name = profList.getSelectedValue().split(" ");
			 String n = name[0];
			 Professor pr = ProfessorDatabase.getInstance().findByName(n);
			
			 DepartmentController.getInstance().addManager(d, pr);

			 dispose();
			}
			}
			
		});
	}
	
	private void conditions(){
		profName = new DefaultListModel<>();
		for(Professor p: ProfessorDatabase.getInstance().getProfessors()) {
			if((p.getTitle().equals(Title.REDOVNI_PROFESOR)||p.getTitle().equals(Title.VANREDNI_PROFESOR))&&(p.getInternshipYears()>=5)) {
				String name = p.getName()+" "+p.getSurname()+"                         ";
				profName.addElement(name);
				
			}
		}
	}

}
