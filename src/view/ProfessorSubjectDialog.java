package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.ProfessorController;
import controller.StudentController;
import gui.MainFrame;
import model.FailedSubjects;
import model.PassedSubjects;
import model.Professor;
import model.ProfessorDatabase;
import model.ProfessorSubjectsDatabase;
import model.Subject;
import model.SubjectDatabase;


public class ProfessorSubjectDialog extends JDialog{

	private JList<String> subList;
	private JButton confirm;
	private JButton quit;
	private JPanel pnl;
	private JPanel btnPnl;
	private Professor p;
	private ProfessorSubjectsDatabase subData;
	DefaultListModel<String> subName;
	
	public ProfessorSubjectDialog(ProfessorSubjectsTab parent, boolean modal,int row) {
		
		setTitle("Dodaj predmet");
		setSize(350,350);
		setLocationRelativeTo(parent);
		p = ProfessorDatabase.getInstance().getRow(row);
		conditions();
		constructGui();
		buttonActions(parent);
		
	}
	
	private void constructGui(){
		
		conditions();
		subList = new JList<>();
		subList.setModel(subName);
		subList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JScrollPane sp = new JScrollPane(subList);
		
		pnl.add(sp);
		add(pnl, BorderLayout.NORTH);
		
		confirm = new JButton("Potvrdi");
		quit = new JButton("Odustani");
		
		btnPnl.add(confirm);
		btnPnl.add(quit);
		add(btnPnl, BorderLayout.SOUTH);
		
	}
	
	
	private void buttonActions(ProfessorSubjectsTab parent) {
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			 List<String> temp= subList.getSelectedValuesList();
			 if(subList.getSelectedIndex()==-1) {
				 JOptionPane.showMessageDialog(parent, "Izaberite predmet ili više za dodavanje");
			 }
			 else {
				 
			     if(temp.size() == 1) {
				 String[] name = subList.getSelectedValue().split(" ");
				 String code = name[0];
				 Subject sb = SubjectDatabase.getInstance().findByCode(code);
			
				 ProfessorController.getInstance().addSubjectToProfessor(p, sb);
				 sb.setSubjectProfessor(p);

			 } else if(temp.size()>1) {
				for(int i = 0; i<temp.size(); i++) {
					String[] name = temp.get(i).split(" ");
					String id = name[0];
					Subject sb = SubjectDatabase.getInstance().findByCode(id);	
					ProfessorController.getInstance().addSubjectToProfessor(p, sb);
					sb.setSubjectProfessor(p);
				}
			}
			 parent.refresh();
			 dispose();
			}
			
		}});
		
	}
	
	
	private void conditions() {
		subData = new ProfessorSubjectsDatabase(p);
		subName = new DefaultListModel<>();
		for(Subject sb: SubjectDatabase.getInstance().getSubjects()) {
			if(!subData.findByCode2(sb.getSubjectCode())) {
				String name = sb.getSubjectCode()+" - "+sb.getSubjectName()+"                         ";
				subName.addElement(name);
				
			}
		}
	}
}
