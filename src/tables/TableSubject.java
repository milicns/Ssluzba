package tables;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import model.SubjectDatabase;


public class TableSubject extends JTable {
	private static final long serialVersionUID = 1L;
	
	public TableSubject() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.getTableHeader().setBackground( Color.WHITE);
		this.setModel( new AbstractTableSubject());
		
		
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i = 0;i < SubjectDatabase.getInstance().getColumnCount();i++)
			
		this.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		this.setAutoCreateRowSorter(true);
	}
	
	
	
	
	
	

}
