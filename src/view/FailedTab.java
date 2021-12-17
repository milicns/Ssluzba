package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.FailedJTable;
import model.Student;
import model.StudentsDatabase;

public class FailedTab extends JPanel{
	
	private Student student;
	private JButton add;
	private JButton delete;
	private JButton exam;
	private JTable failed;
	private JPanel btnPnl;
	private JPanel table;
	
	
	public FailedTab(int row) {
		student = StudentsDatabase.getInstance().getRow(row);
		initGui();
		constructGui();
		
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());
		btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		table = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		failed = new FailedJTable();
		
		add = new JButton("Dodaj");
		delete = new JButton("Obriši");
		exam = new JButton("Polaganje");
	}
	
	
	private void constructGui() {
		
		JScrollPane sp = new JScrollPane(failed);
		table.add(sp);
		add(table, BorderLayout.CENTER);
		
		btnPnl.add(Box.createHorizontalStrut(10));
		btnPnl.add(add);
		btnPnl.add(delete);
		btnPnl.add(exam);
		add(btnPnl,BorderLayout.NORTH);
		
	}

}
