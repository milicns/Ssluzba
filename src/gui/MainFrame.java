package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ResourceBundleController;
import listeners.WindowList;
import tables.AbstractTableProfessor;
import tables.AbstractTableSubject;
import tables.TableProfessor;
import tables.TableSubject;

public class MainFrame extends JFrame {  
	
	private JTable studentsTable;
	private JTable professorsTable;
	private JTable subjectsTable;
	private TabbedPane tabs;
	private StatusBar sb;
	private MenuBar menu;
	
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
	    setTitle(ResourceBundleController.getInstance().getResourceBundle().getString("title"));
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	     
        menu = new MenuBar(this);
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
		tabs.addTab(ResourceBundleController.getInstance().getResourceBundle().getString("studentsTable"), stp);
		tabs.addTab(ResourceBundleController.getInstance().getResourceBundle().getString("professorsTable"), pp);
		tabs.addTab(ResourceBundleController.getInstance().getResourceBundle().getString("subjectsTable"), sbp);
		this.add(tabs, BorderLayout.CENTER);
		
		this.add(getSb(), BorderLayout.SOUTH);
		tabs.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(tabs.getSelectedIndex()==0) {
					refreshSb(ResourceBundleController.getInstance().getResourceBundle().getString("studentsTable"));
				} else if(tabs.getSelectedIndex()==1) {
					refreshSb(ResourceBundleController.getInstance().getResourceBundle().getString("professorsTable"));
				}else if(tabs.getSelectedIndex()==2) {
					refreshSb(ResourceBundleController.getInstance().getResourceBundle().getString("subjectsTable"));
				}
			}
		});
		addWindowListener(new WindowList());
		
	}
	
	public void changeLanguage() {
		menu.getmFile().setText(ResourceBundleController.getInstance().getResourceBundle().getString("mFile"));
		menu.getmEdit().setText(ResourceBundleController.getInstance().getResourceBundle().getString("mEdit"));
		menu.getmHelp().setText(ResourceBundleController.getInstance().getResourceBundle().getString("mHelp"));
		menu.getMiAbout().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miAbout"));
		menu.getMiHelp().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miHelp"));
		menu.getMiClose().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miClose"));
		menu.getMiSave().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miSave"));
		menu.getMiDelete().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miDelete"));
		menu.getMiEdit().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miEdit"));
		menu.getMiStudent().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miStudent"));
		menu.getMiProfessor().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miProfessor"));
		menu.getMiSubject().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miSubject"));
		menu.getMiDepartment().setText(ResourceBundleController.getInstance().getResourceBundle().getString("miDepartment"));
		menu.getmLang().setText(ResourceBundleController.getInstance().getResourceBundle().getString("mLang"));
		tabs.setTitleAt(0, ResourceBundleController.getInstance().getResourceBundle().getString("studentsTable"));
		tabs.setTitleAt(1, ResourceBundleController.getInstance().getResourceBundle().getString("professorsTable"));
		tabs.setTitleAt(2, ResourceBundleController.getInstance().getResourceBundle().getString("subjectsTable"));
		sb.changeLanguage();
		studentsTable.getColumnModel().getColumn(0).setHeaderValue(ResourceBundleController.getInstance().getResourceBundle().getString("index"));
		studentsTable.getColumnModel().getColumn(1).setHeaderValue(ResourceBundleController.getInstance().getResourceBundle().getString("name"));
		studentsTable.getColumnModel().getColumn(2).setHeaderValue(ResourceBundleController.getInstance().getResourceBundle().getString("surname"));
		studentsTable.getColumnModel().getColumn(3).setHeaderValue(ResourceBundleController.getInstance().getResourceBundle().getString("year"));
		studentsTable.getColumnModel().getColumn(4).setHeaderValue(ResourceBundleController.getInstance().getResourceBundle().getString("status"));
		studentsTable.getColumnModel().getColumn(5).setHeaderValue(ResourceBundleController.getInstance().getResourceBundle().getString("avg"));
	}
		
	public void refreshTables(String a, int v) throws ParseException {
		
		TableProfessor ProfessorsTable=new TableProfessor();
		
		AbstractTableProfessor ProfessorsModel = (AbstractTableProfessor) ProfessorsTable.getModel();
		
		ProfessorsModel.fireTableDataChanged();
		
		ProfessorsTable.validate();
		
	}
	
	public StatusBar getSb() {
		if(tabs.getSelectedIndex()==0) {
			sb = new StatusBar(ResourceBundleController.getInstance().getResourceBundle().getString("studentsTable"));
		} else if (tabs.getSelectedIndex()==1) {
			sb = new StatusBar(ResourceBundleController.getInstance().getResourceBundle().getString("professorsTable"));
		} else if (tabs.getSelectedIndex()==2) {
			sb = new StatusBar(ResourceBundleController.getInstance().getResourceBundle().getString("subjectsTable"));
		}
			return sb;
	}
	
	
	public void refreshStudents() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentsTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	public void refreshProfessors() {
		AbstractTableProfessor model = (AbstractTableProfessor) professorsTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	public void refreshSubjects() {
		AbstractTableSubject model = (AbstractTableSubject) subjectsTable.getModel();
		
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
	
	public JTable getProfessorTable() {
		return professorsTable;
	}
	
	public JTable getSubjectTable() {
		return subjectsTable;
	}
	
}