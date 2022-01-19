package model;

import java.util.ArrayList;
import java.util.List;

import model.Subject.Semester;

public class PassedSubjects {


	private List<Grade> grades;
	private List<String> columns;
	
	private PassedSubjects() {}

	public PassedSubjects(Student s) {
	   

        grades = s.getPassedSubjects();
		
		this.columns = new ArrayList<String>();
		
		this.columns.add("Sifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB bodovi");
		this.columns.add("Ocena");
		this.columns.add("Datum");
	}
	

	
	public List<Grade> getGrades() {
		return grades;
	}
	
	public boolean findSubject(String id) {
		for(Grade g: grades) {
			if(g.getSubject().getSubjectCode().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
		
	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Grade getRow(int rowIndex) {
		return this.grades.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Grade grade = this.grades.get(row);
		switch (column) {
		case 0:
			return grade.getSubject().getSubjectCode();
		case 1:
			return grade.getSubject().getSubjectName();
		case 2:
			return grade.getSubject().getEspb();
		case 3:
			return grade.getSubject().getStudyYear();
		case 4:
			return String.valueOf(grade.getSubject().getSemester());
		default:
			return null;
		}
	}

	
	
}
