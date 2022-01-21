package gui;

import javax.swing.table.AbstractTableModel;

//import model.GradeDatabase;

public class AbstractTableModelGrade extends AbstractTableModel {
	
	
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
	//	return GradeDatabase.getInstance().getOcene().size();
	}
	
	@Override
	public int getColumnCount() {
	//	return GradeDatabase.getInstance().getColumnCount();
		

	}
	
	public String getColumnName(int column) {
	//	return GradeDatabase.getInstance().getColumnName(column);
		return "dodate kolone";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
