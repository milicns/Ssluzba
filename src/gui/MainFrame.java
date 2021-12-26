package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tables.AbstractTableSubject;
import tables.AbstractTableProfessor;

import tables.TableProfessor;
import tables.TableSubject;

public class MainFrame extends JFrame {  
	
	private JTable studentsTable;
	private JTable professorsTable;
	private JTable subjectsTable;
	TabbedPane tabs;
	StatusBar sb;
	
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	
	private  MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(3*screenWidth / 4, 3*screenHeight/ 4);
	    setTitle("Studentska sluzba");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	     
        MenuBar menu = new MenuBar(this);
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar(this);
		add(toolbar, BorderLayout.NORTH);
		
		studentsTable = new StudentsJTable();
		JScrollPane stp = new JScrollPane(studentsTable);
		professorsTable = new TableProfessor();
		JScrollPane pp = new JScrollPane(professorsTable);
		subjectsTable = new TableSubject();
		JScrollPane sbp = new JScrollPane(subjectsTable);
		
		tabs = new TabbedPane();
		tabs.addTab("Studenti", stp);
		tabs.addTab("Profesori", pp);
		tabs.addTab("Predmeti", sbp);
		this.add(tabs, BorderLayout.CENTER);
		
		this.add(getSb(), BorderLayout.SOUTH);
		tabs.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(tabs.getSelectedIndex()==0) {
					refreshSb("Studenti");
				} else if(tabs.getSelectedIndex()==1) {
					refreshSb("Profesori");
				}else if(tabs.getSelectedIndex()==2) {
					refreshSb("Predmeti");
				}
			}
		});
		
		}
		
	public void refreshTables(String a, int v) throws ParseException {
		
		TableProfessor ProfessorsTable=new TableProfessor();
		TableSubject SubjectTable=new TableSubject();
		
		AbstractTableProfessor ProfessorsModel = (AbstractTableProfessor) ProfessorsTable.getModel();
		AbstractTableSubject SubjectModel = (AbstractTableSubject) SubjectTable.getModel();
		
		ProfessorsModel.fireTableDataChanged();
		SubjectModel.fireTableDataChanged();
		
		ProfessorsTable.validate();
		SubjectTable.validate();
		
	}
	
	public StatusBar getSb() {
		if(tabs.getSelectedIndex()==0) {
			sb = new StatusBar("Studenti");
		} else if (tabs.getSelectedIndex()==1) {
			sb = new StatusBar("Profesori");
		} else if (tabs.getSelectedIndex()==2) {
			sb = new StatusBar("Predmeti");
		}
			return sb;
	}
	
	
	public void refreshStudents() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentsTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	public void refreshSb(String tName) {
		
		this.sb = new StatusBar(tName);
		this.add(sb, BorderLayout.SOUTH);
		validate();
		
	}
	
	
	public TabbedPane getTabs() {
		return tabs;
	}
	
	public JTable getStudentTable() {
		return studentsTable;
	}
	       

}