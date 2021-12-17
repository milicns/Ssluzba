package dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import view.SubjectView;



public class SubjectDialog  extends JDialog {
	
	
	
	private static final long serialVersionUID = 1L;

	public SubjectDialog(Frame parent) {
		super(parent, "Add Subject", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(parent);

		SubjectView subView = new SubjectView();

		add(subView);
		
	}
	public SubjectDialog(Frame parent,int selRow) {
		super(parent, "Change Subject", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(parent);
		
		
	}

}
