package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DepartmentDialog extends JDialog {
	
	private JPanel pnl;
	private JTable dpTable;
	private JButton set;
	private JPanel btnPnl;
	private JDialog dial = this;
	
	public DepartmentDialog(JFrame parent, String title, boolean modal) {
		setSize(500,550);
		setLocationRelativeTo(parent);
		setTitle(title);
		constructGui();
		buttonActions();
		
	}
	
	
	private void constructGui() {
		setLayout(new BorderLayout());
		pnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dpTable = new DepartmentJTable();
		btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JScrollPane sp = new JScrollPane(dpTable);
		pnl.add(sp);
		
		add(pnl,BorderLayout.CENTER);
		set = new JButton("Postavi šefa");
		btnPnl.add(set);
		add(btnPnl, BorderLayout.NORTH);
		
	}
	
	private void buttonActions() {
		set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = dpTable.getSelectedRow();
				DMDialog dmd = new DMDialog(dial,"Postavljanje šefa",true,row);
				dmd.setVisible(true);
				
			}
			
		});
	}

}
