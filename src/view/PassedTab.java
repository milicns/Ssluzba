package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.PassedJTable;
import model.Student;
import model.Grade;
import model.StudentsDatabase;

public class PassedTab extends JPanel {

	
	private JLabel lblAvg;
	private JLabel avgValue;
	private JLabel lEspb;
	private JLabel espbValue;
	private JPanel btnPnl;
	private JPanel table;
	private JPanel lblPnl;
	
	private Student student;
	private JButton undo;
	private JTable passed;
	
	
	public PassedTab(int row) {
		student = StudentsDatabase.getInstance().getRow(row);
		initGui();
		constructGui();
		
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());
		btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		table = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		lblPnl = new JPanel(new GridBagLayout());
		
		lblAvg = new JLabel("Prosečna ocena: ");
		avgValue = new JLabel(Double.toString(student.getAvgGrade()));
		
		lEspb =  new JLabel("Ukupno ESPB: ");
		espbValue = new JLabel(Integer.toString(espbSum()));
		
		passed = new PassedJTable();
		
		undo = new JButton("Poništi");
	}
	
	
	private void constructGui() {
		
		JScrollPane sp = new JScrollPane(passed);
		table.add(sp);
		add(table, BorderLayout.CENTER);
		
		lblPnl.add(Box.createHorizontalStrut(120));
		lblPnl.add(lblAvg);
		lblPnl.add(Box.createHorizontalGlue());
		lblPnl.add(avgValue);
		lblPnl.add(Box.createVerticalStrut(10));
		lblPnl.add(Box.createHorizontalStrut(120));
		lblPnl.add(lEspb);
		lblPnl.add(Box.createHorizontalGlue());
		lblPnl.add(espbValue);
		
		/*lblPnl.add(avg, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(25, 0, 0, 0), 0, 0));
		
		lblPnl.add(avgValue, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(25, 25, 0, 25), 0, 0));
		
		lblPnl.add(espb, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));
		
		lblPnl.add(espbValue, new GridBagConstraints(1, 9, 0, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(10, 10, 0, 10), 0, 0));*/
		
		add(lblPnl, BorderLayout.SOUTH);
		
		btnPnl.add(Box.createHorizontalStrut(10));
		btnPnl.add(undo);
		add(btnPnl,BorderLayout.NORTH);
		
	}
	
	
	private int espbSum() {
		int sum = 0;
		for(Grade g : student.getPassedSubjects()) {
			sum += g.getSubject().getEspb();
		}
		return sum;	
	}
}
