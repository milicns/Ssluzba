package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.text.ParseException;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;


 import view.ProfessorView;




public class ProfessorDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;


	public ProfessorDialog(Frame parent) {
		super(parent, "Add Professor", false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 350);
		setLocationRelativeTo(parent);

		ProfessorView pv = new ProfessorView();

		add(pv);
		
		
		
	}
	public ProfessorDialog(Frame parent,int selRow) throws ParseException {
		super(parent, "Change Professor", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 350);
		setLocationRelativeTo(parent);

 ///FALI TABBED PANE
		
		
		
	}
	
	
	

}
