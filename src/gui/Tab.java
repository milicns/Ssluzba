package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Tab extends JTabbedPane{
	
	private StudentsJTable students;
	private ProfessorsJTable professors;
	private SubjectsJTable subjects;
	
	public Tab() {
		super();
		this.addTab("Studenti", studentsTab());
		this.addTab("Profesori", professorsTab());
		this.addTab("Predmeti", subjectsTab());
		
	}
	
	private JScrollPane studentsTab() {
		
		students = new StudentsJTable();
		JScrollPane sc=new JScrollPane(students,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		return sc;	
	}
	
	private JScrollPane professorsTab() {
		
		students = new StudentsJTable();
		JScrollPane sc=new JScrollPane(professors,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		return sc;	
	}
	
	private JScrollPane subjectsTab() {
		
		students = new StudentsJTable();
		JScrollPane sc=new JScrollPane(subjects,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		return sc;	
	}
		
}

