package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import model.DepartmentDatabase;
import model.ProfessorDatabase;
import model.StudentsDatabase;
import model.SubjectDatabase;

public class  WindowList implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		try {
		
			ProfessorDatabase.getInstance().serializeProfessors();
			DepartmentDatabase.getInstance().serializeDepartments();
			SubjectDatabase.getInstance().serializeSubjects();
			StudentsDatabase.getInstance().serializeStudents();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
