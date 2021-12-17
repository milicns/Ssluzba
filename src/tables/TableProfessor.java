package tables;

import java.awt.Color;
import java.awt.Component;

import java.text.ParseException;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import model.ProfessorDatabase;


public class TableProfessor extends JTable{
	
	private static final long serialVersionUID = 1L;
	
	public TableProfessor() {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.getTableHeader().setBackground(new Color(100, 120, 100));
       
        this.setModel(new AbstractTableProfessor());
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i = 0;i < ProfessorDatabase.getInstance().getColumnCount();i++)
		this.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		this.setAutoCreateRowSorter(true);
    }
	
	
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
