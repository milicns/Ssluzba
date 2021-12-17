package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Student;
import model.StudentsDatabase;

public class AbstractTableModelPassed extends AbstractTableModel{

		public AbstractTableModelPassed() {}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			int row = MainFrame.getInstance().getStudentTable().getSelectedRow();
			Student s = StudentsDatabase.getInstance().getRow(row);
			return s.getPassedSubjects().size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnName(int column) {
			
			ArrayList<String> columns = new ArrayList<String>();
			columns.add("Šifra predmeta");
			columns.add("Naziv predmeta");
			columns.add("ESPB");
			columns.add("Ocena");
			columns.add("Datum");
			
			return columns.get(column);
		}
	
	
}
