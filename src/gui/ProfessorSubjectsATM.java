package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Professor;
import model.ProfessorSubjectsDatabase;
import model.Subject;

public class ProfessorSubjectsATM extends AbstractTableModel {

	ProfessorSubjectsDatabase subData;
	
	public ProfessorSubjectsATM(Professor p) {
		
		subData = new ProfessorSubjectsDatabase(p);
		
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return subData.getSubjects().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return subData.getValueAt(rowIndex, columnIndex);
		
	}

	@Override
	public String getColumnName(int column) {
		return subData.getColumnName(column);
	}
}
