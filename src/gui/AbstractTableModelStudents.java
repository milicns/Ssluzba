package gui;

import javax.swing.table.AbstractTableModel;

import model.StudentsDatabase;

public class AbstractTableModelStudents extends AbstractTableModel{

	public AbstractTableModelStudents() {
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return StudentsDatabase.getInstance().getStudents().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return StudentsDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return StudentsDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return StudentsDatabase.getInstance().getColumnName(column);
	}
}
