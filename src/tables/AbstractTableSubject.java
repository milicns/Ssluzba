package tables;

import javax.swing.table.AbstractTableModel;

import model.SubjectDatabase;

public class AbstractTableSubject extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return SubjectDatabase.getInstance().getSubjects().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return SubjectDatabase.getInstance().getColumnCount();
	}	
	public String getColumnName(int column) {
		
		return SubjectDatabase.getInstance().getColumnName(column);
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return SubjectDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	

}
