package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import controller.SubjectController;
import model.Student;
import model.StudentsDatabase;

public class FailedJTable extends JTable{

	
	
	public FailedJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		int row = MainFrame.getInstance().getStudentTable().getSelectedRow();
		Student s = StudentsDatabase.getInstance().getRow(row);
		this.setModel(new AbstractTableModelFailed(s));
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void refresh() {
		AbstractTableModelFailed model = (AbstractTableModelFailed) this.getModel();
		model.fireTableDataChanged();
	}
}
