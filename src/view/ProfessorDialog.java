package view;

import java.awt.Frame;
import java.text.ParseException;
import javax.swing.JDialog;


public class ProfessorDialog extends JDialog{
	
	
private static final long serialVersionUID = 1L;

	
	public ProfessorDialog(Frame f,int selRow) throws ParseException {
		super(f, " Change Professor ", true);
		setSize(400, 350);
		setLocationRelativeTo(f);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(f);

		
	}
	
	

	public ProfessorDialog(Frame f) {
		super(f, "Add Professor", true);
		setSize(400, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(f);
		ProfessorView pv = new  ProfessorView ();
		add(pv);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
