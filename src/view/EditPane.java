package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.MainFrame;
import gui.PassedJTable;

public class EditPane extends JTabbedPane{

	private JPanel inf;
	private JPanel passed;
	private JPanel failed;
	
	public EditPane(JDialog parent) {
		
		int row = MainFrame.getInstance().getStudentTable().getSelectedRow();
		inf = new InformationsTab(row, parent);
		this.addTab("Informacije", inf);
		
		passed = new PassedTab(row);
		this.addTab("Položeni", passed);
		
		failed = new FailedTab(row);
		this.addTab("Nepoloženi", failed);
		
	}
	
	
}
