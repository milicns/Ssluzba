package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ProfessorEditDialog extends JDialog{
	
	public ProfessorEditDialog(JFrame parent, String title, boolean modal) {
		setSize(600,600);
		setTitle(title);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		this.add(new ProfessorEditPane(this));
		setVisible(true);
		
	}

}
