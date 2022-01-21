package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Professor;
import model.ProfessorDatabase;



public class ProfessorSubjectsJTable extends JTable{

	public ProfessorSubjectsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		int row = MainFrame.getInstance().getProfessorTable().getSelectedRow();
		Professor p = ProfessorDatabase.getInstance().getRow(row);
		this.setModel(new ProfessorSubjectsATM(p));
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
	
}
