package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import gui.TabbedPane;
import view.SubjectView;





public class SubjectController {
	
	private static SubjectController instance = null;
	
	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	private SubjectController() {}
	
	private SubjectView SubjectView;
	
	/*public SubjectController(SubjectView SubjectView){
		setSubjectView(SubjectView);
	}*/

}
