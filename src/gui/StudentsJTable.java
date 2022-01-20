package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import model.StudentsDatabase;



public class StudentsJTable extends JTable{
	
	private TableRowSorter<AbstractTableModelStudents> sorter;
	
	private static StudentsJTable instance = null;
	
	public static StudentsJTable getInstance() {
		if (instance == null) {
			instance = new StudentsJTable();
		}
		return instance;
	}
	
	public StudentsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelStudents model = new AbstractTableModelStudents();
		this.setModel(new AbstractTableModelStudents());
		//this.setAutoCreateRowSorter(true);
		sorter = new TableRowSorter<AbstractTableModelStudents>(model);
		this.setRowSorter(sorter);
		
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
	
	public TableRowSorter getRowSorter() {
		return sorter;
	}

}
