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
		
		Tab tabs = new Tab();
		this.add(tabs);
		showTable();
	
	}
	
	public void refreshStudents() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentsTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	private void showTable() {
		studentsTable = new StudentsJTable();

		JScrollPane scrollPane = new JScrollPane(studentsTable);
		add(scrollPane, BorderLayout.CENTER);

		this.refreshStudents();
	}
	
	       
}
