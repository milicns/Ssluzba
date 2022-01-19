package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class StudentEditDialog extends JDialog{

	public StudentEditDialog(JFrame parent, String title, boolean modal) {
		
		setSize(650,650);
		setLocationRelativeTo(parent);
		setTitle(title);
		setLayout(new BorderLayout());
		this.add(new EditPane(this));
		setVisible(true);
		
	}
}
