
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Status;
import model.Subject.Semester;
	

public class SubjectDatabase {
	
	private static SubjectDatabase instance = null;

	public static SubjectDatabase getInstance() {
		if (instance == null) {
			instance = new SubjectDatabase();
		}
		return instance;
	}

	private List<Subject> subjects;
	private List<String> columns;
	private List<Subject> refresh =new ArrayList<>();

	private SubjectDatabase() {
	   
	
		initSubjects();

		this.columns = new ArrayList<String>();
		
		this.columns.add("Sifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB bodovi");
		this.columns.add("Godina");
		this.columns.add("Semestar");
	}
	
	
	private void initSubjects() {
		
		this.subjects = new ArrayList<Subject>();
		
		//Subject s1= new Subject("E22","OISISI",Semester.Z,2);
		//Subject s2= new Subject("E21","Baze Podataaka",Semester.L,3);
		//subjects.add(s1);
		//subjects.add(s2);
			
		
		refresh= subjects;
		
	}
	
	
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	

	public void setSubjects(List<Subject> predmeti) {
		this.subjects = predmeti;
	}
		
	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Subject subject = this.subjects.get(row);
		switch (column) {
		case 0:
			return subject.getSubjectCode();
		case 1:
			return subject.getSubjectName();
		case 2:
			return subject.getEspb();
		case 3:
			return subject.getStudyYear();
		case 4:
			return String.valueOf(subject.getSemester());
		default:
			return null;
		}
	}
	
}
