package tables;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.SubjectDatabase;


public class TableSubject extends JTable {
	private static final long serialVersionUID = 1L;
	
	public TableSubject() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel( new AbstractTableSubject());
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
