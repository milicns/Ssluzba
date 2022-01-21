package gui;


import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;


public class ProfessorsJTable extends JTable{

	public ProfessorsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.WHITE);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
}
