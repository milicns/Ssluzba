package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.MainFrame;

public class ProfessorEditPane extends JTabbedPane{

	private JPanel profInf;
	private JPanel psTab;
	
	public ProfessorEditPane(JDialog parent) {
		
		int row = MainFrame.getInstance().getProfessorTable().getSelectedRow();
		profInf = new ProfessorInformations(parent, row);
		this.addTab("Informacije", profInf);
		
		psTab = new ProfessorSubjectsTab(parent, row);
		this.add("Predmeti",psTab);
		
	}
}
