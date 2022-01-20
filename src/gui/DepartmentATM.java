package gui;

import javax.swing.table.AbstractTableModel;

import model.DepartmentDatabase;

public class DepartmentATM extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return DepartmentDatabase.getInstance().getDepartments().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return DepartmentDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return DepartmentDatabase.getInstance().getColumnName(column);
	}

}
