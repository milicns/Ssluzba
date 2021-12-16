package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tables.AbstractTableSubject;
import tables.StudentsJTable;
import tables.AbstractTableProfessor;

import tables.TableProfessor;
import tables.TableSubject;

public class MainFrame extends JFrame {  
	
	/*
	 * private static final long serialVersionUID = 1L;
	 */
	
	
	private JTable studentsTable;
	private JTable professorsTable;
	private JTable subjectsTable;
	TabbedPane tabs;
	
	
	
	
	
	
	public  MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(3*screenWidth / 4, 3*screenHeight/ 4);
	    setTitle("Studentska sluzba");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); //na centar
	     
        MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);
			
		
			
	}
		
	public void refreshTables(String akcija, int vrednost) throws ParseException {
		
		TableProfessor ProfessorsTable=new TableProfessor();
		TableSubject SubjectTable=new TableSubject();
		
		
		AbstractTableProfessor ProfessorsModel = (AbstractTableProfessor) ProfessorsTable.getModel();
		AbstractTableSubject SubjectModel = (AbstractTableSubject) SubjectTable.getModel();
		
		
		ProfessorsModel.fireTableDataChanged();
		SubjectModel.fireTableDataChanged();
		
		
		ProfessorsTable.validate();
		SubjectTable.validate();
		
	}
		
		
		
		
		
		
	}
	       

