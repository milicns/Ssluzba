package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Professor;
import model.Subject;

public class ProfessorSubjectsATM extends AbstractTableModel {

	List<Subject> subjects;
	List<String> columns;
	
	public ProfessorSubjectsATM(Professor p) {
		
		subjects = p.getProfessorSubjects();
		columns = new ArrayList<String>();
		this.columns.add("Šifra");
		this.columns.add("Naziv");
		this.columns.add("Godina studija");
		this.columns.add("Semestar");
		
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return subjects.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Subject subject = this.subjects.get(rowIndex);
		switch (columnIndex) {
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

	@Override
	public String getColumnName(int column) {
		return columns.get(column);
	}
}
