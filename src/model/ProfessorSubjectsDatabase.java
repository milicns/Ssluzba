package model;

import java.util.ArrayList;
import java.util.List;

public class ProfessorSubjectsDatabase {
	
	private List<Subject> subjects;
	private List<String> columns;

	public ProfessorSubjectsDatabase(Professor p) {
	   

        subjects = p.getProfessorSubjects();
		
		this.columns = new ArrayList<String>();
		
		this.columns.add("Šifra");
		this.columns.add("Naziv");
		this.columns.add("Godina studija");
		this.columns.add("Semestar");
	}
	

	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public Subject findByCode(String code) {
		for(Subject s: subjects) {
			if(s.getSubjectCode().equals(code)) {
				return s;
			}
		}
		return null;
	}
	
	public boolean findByCode2(String code) {
		for(Subject s: subjects) {
			if(s.getSubjectCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
		
	public int getColumnCount() {
		return 4;
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
			return subject.getStudyYear();
		case 3:
			return String.valueOf(subject.getSemester());
		default:
			return null;
		}
	}
	

}
