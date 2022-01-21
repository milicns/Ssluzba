package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
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
		sorter = new TableRowSorter<AbstractTableModelStudents>(model);
		this.setRowSorter(sorter);
		
		//https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know
		Comparator c1 = new java.util.Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			
			String[] temp1 = o1.toString().split(" ");
			String[] temp2 = o2.toString().split(" ");
			String[] temp3 = temp1[1].split("/");
			String[] temp4 = temp2[1].split("/");
			int n1 = Integer.parseInt(temp3[1]);
			int n2 = Integer.parseInt(temp4[1]);
			
			return ((Comparable)n1).compareTo(n2);
		}
		
	};
	
	Comparator c2 = new java.util.Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			
			String[] temp1 = o1.toString().split(" ");
			String[] temp2 = o2.toString().split(" ");
			String[] temp3 = temp1[1].split("/");
			String[] temp4 = temp2[1].split("/");
			int n1 = Integer.parseInt(temp3[1]);
			int n2 = Integer.parseInt(temp4[1]);
			
			return ((Comparable)temp1[0]).compareTo(temp2[0]);
		}
		
	};
	
	Comparator c3 = new java.util.Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			
			String[] temp1 = o1.toString().split(" ");
			String[] temp2 = o2.toString().split(" ");
			String[] temp3 = temp1[1].split("/");
			String[] temp4 = temp2[1].split("/");
			int n1 = Integer.parseInt(temp3[0]);
			int n2 = Integer.parseInt(temp4[0]);
			
			return ((Comparable)n1).compareTo(n2);
		}
		
	};
	
	sorter.setComparator(0,c2.thenComparing(c1).thenComparing(c3));

		
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
