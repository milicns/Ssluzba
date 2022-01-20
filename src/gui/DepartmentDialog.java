package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
	
	public DepartmentDialog(JFrame parent, String title, boolean modal) {
		setSize(500,550);
		setLocationRelativeTo(parent);
		setTitle(title);
		constructGui();
		
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

}
