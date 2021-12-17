package tables;


import java.text.ParseException;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDatabase;


public class AbstractTableProfessor extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
			return ProfessorDatabase.getInstance().getProfessors().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ProfessorDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ProfessorDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		return ProfessorDatabase.getInstance().getColumnName(column);
		
	}
}
	
	
