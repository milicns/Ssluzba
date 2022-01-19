package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.PassedSubjects;
import model.Student;
import model.StudentsDatabase;

public class AbstractTableModelPassed extends AbstractTableModel{

		PassedSubjects pSub;
		
		public AbstractTableModelPassed(Student s) {
		
			pSub = new PassedSubjects(s);
			
		}
		
		@Override
		public int getRowCount() {
		
			return pSub.getGrades().size();
		}

		@Override
		public int getColumnCount() {
		
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			return pSub.getValueAt(rowIndex, columnIndex);
		}

		@Override
		public String getColumnName(int column) {
			
			return pSub.getColumnName(column);
		}
	
	
}
