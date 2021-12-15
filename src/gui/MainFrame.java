package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class MainFrame extends JFrame {  
	
	private JTable studentsTable;
	private JTable professorsTable;
	private JTable subjectsTable;
	TabbedPane tabs;
	
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(3*screenWidth / 4, 3*screenHeight/ 4);
	    setTitle("Studentska služba");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	     
        MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar(this);
		add(toolbar, BorderLayout.NORTH);
		
		studentsTable = new StudentsJTable();
		JScrollPane stp = new JScrollPane(studentsTable);
		professorsTable = new ProfessorsJTable();
		JScrollPane pp = new JScrollPane(professorsTable);
		subjectsTable = new SubjectsJTable();
		JScrollPane sbp = new JScrollPane(subjectsTable);
		
		tabs = new TabbedPane();
		tabs.addTab("Studenti", stp);
		tabs.addTab("Profesori", pp);
		tabs.addTab("Predmeti", sbp);
		this.add(tabs, BorderLayout.CENTER);
	
	}
	
	public void refreshStudents() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentsTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	
	public TabbedPane getTabs() {
		return tabs;
	}
	
	public JTable getStudentTable() {
		return studentsTable;
	}
	       
}
