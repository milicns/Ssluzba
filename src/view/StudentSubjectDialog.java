package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.StudentController;
import controller.SubjectController;
import gui.MainFrame;
import model.FailedSubjects;
import model.PassedSubjects;
import model.Student;
import model.StudentsDatabase;
import model.Subject;
import model.SubjectDatabase;

public class StudentSubjectDialog extends JDialog{
	
	private JList<String> subList;
	private JButton add;
	private JButton quit;
	private JPanel pnl;
	private JPanel btnPnl;
	private Student s;
	private PassedSubjects ps;
	private FailedSubjects fd;
	DefaultListModel<String> subName;
	
	public StudentSubjectDialog(FailedTab parent, boolean modal,String id) {
		setTitle("Dodaj predmet studentu");
		setSize(300,300);
		setLocationRelativeTo(parent);
		s = StudentsDatabase.getInstance().findById2(id);
		conditions();
		constructGui();
		buttonActions(parent);
		
		
	}
	
	private void constructGui(){

		subList = new JList<>();
		subList.setModel(subName);
		subList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JScrollPane sp = new JScrollPane(subList);
		
		pnl.add(sp);
		add(pnl, BorderLayout.NORTH);
		
		add = new JButton("Dodaj");
		quit = new JButton("Odustani");
		
		btnPnl.add(add);
		btnPnl.add(quit);
		add(btnPnl, BorderLayout.SOUTH);
		
	}
	
	private void buttonActions(FailedTab parent) {
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
			 if(subList.getSelectedIndex() == -1) {
				 JOptionPane.showMessageDialog(parent, "Izaberite predmet za dodavanje");
			 } else {
			 String[] name = subList.getSelectedValue().split(" ");
			 String code = name[0];
			 Subject sb = SubjectDatabase.getInstance().findByCode(code);
			
			 StudentController.getInstance().addSubjectToStudent(s, sb);
			 parent.getTable().refresh();

			 dispose();
			}
			}
			
		});
		
		
	}
	
	private void conditions() {
		fd = new FailedSubjects(s);
		ps = new PassedSubjects(s);
		subName = new DefaultListModel<>();
		for(Subject sb: SubjectDatabase.getInstance().getSubjects()) {
			if((sb.getStudyYear() <= s.getCurrentYear())&&!(fd.findByCode2(sb.getSubjectCode()))&&!(ps.findSubject(sb.getSubjectCode()))) {
				String name = sb.getSubjectCode()+" - "+sb.getSubjectName()+"                         ";
				subName.addElement(name);
				
			}
		}
		
		
	}

}
