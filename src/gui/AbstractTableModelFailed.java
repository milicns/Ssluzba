package gui;

import javax.swing.table.AbstractTableModel;

import model.FailedSubjects;
import model.Student;


public class AbstractTableModelFailed extends AbstractTableModel{
	
	FailedSubjects subData;
	
	public AbstractTableModelFailed(Student s) {
		subData = new FailedSubjects(s);
	}
	

	@Override
	public int getRowCount() {
		
		
		return subData.getSubjects().size();
	}

	@Override
	public int getColumnCount() {
		
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return subData.getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return subData.getColumnName(column);
	}
	
	
}
