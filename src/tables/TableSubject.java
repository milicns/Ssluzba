package tables;

import java.awt.Color;

import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import model.SubjectDatabase;


public class TableSubject extends JTable {
	private static final long serialVersionUID = 1L;
	
	public TableSubject() throws ParseException {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.getTableHeader().setBackground(new Color(100, 120, 100));
		this.setModel( new AbstractTableSubject());
		
		
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i = 0;i < SubjectDatabase.getInstance().getColumnCount();i++)
			
		this.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		this.setAutoCreateRowSorter(true);
	}
	
	
	

}
