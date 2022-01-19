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
		constructGui();
		buttonActions(parent);
		
		
	}
	
	private void constructGui(){
		
		conditions();

		subList = new JList<>();
		subList.setModel(subName);
		subList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		subList.setMaximumSize(getMaximumSize());
		
		pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnl.setMaximumSize(getMaximumSize());
		btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JScrollPane sp = new JScrollPane(subList);
		sp.setMaximumSize(getMaximumSize());
		pnl.add(sp);
		add(pnl, BorderLayout.NORTH);
		
		add = new JButton("Dodaj");
		quit = new JButton("Odustani");
		
		btnPnl.add(add);
		btnPnl.add(quit);
		add(btnPnl, BorderLayout.CENTER);
		
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
			 String[] name = subList.getSelectedValue().split(" ");
			 String code = name[0];
			 Subject sb = SubjectDatabase.getInstance().findByCode(code);
			 int row = MainFrame.getInstance().getStudentTable().getSelectedRow();
			
			 StudentController.getInstance().addSubjectToStudent(s, sb);
			 parent.getTable().refresh();

			 dispose();
			 //subList.remove(subList.getSelectedIndex());
				
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
