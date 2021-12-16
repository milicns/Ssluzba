package tables;


import java.text.ParseException;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDatabase;


public class AbstractTableProfessor extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		try {
			return ProfessorDatabase.getInstance().getProfessors().size();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return ProfessorDatabase.getInstance().getColumnCount();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			return ProfessorDatabase.getInstance().getValueAt(rowIndex, columnIndex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnIndex;
	}

	@Override
	public String getColumnName(int column) {
		try {
			return ProfessorDatabase.getInstance().getColumnName(column);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
	
	
