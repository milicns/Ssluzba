package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import gui.MainFrame;
import model.Professor;
import model.Student;
import model.StudentsDatabase;
import model.Subject.Semester;
import model.SubjectDatabase;

import view.SubjectDialog;

public class SubjectController {
	
	private static SubjectController instance = null;
	
	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	private SubjectController() {}

	public void addSubject(String subjectCode, String subjectName, Semester semester, int studyYear,Professor prof, int espb, ArrayList<Student> passed, ArrayList<Student> failed) {
		
	SubjectDatabase.getInstance().addSubject(subjectCode, subjectName, semester, studyYear, prof, espb, passed, failed);
	MainFrame.getInstance().refreshSubjects();
				
	}
	
	public void editSubject(int row, String subjectCode, String subjectName, Semester semester, int studyYear, int espb) {
		
	SubjectDatabase.getInstance().editSubject(row, subjectCode, subjectName, semester, studyYear, espb);
	MainFrame.getInstance().refreshSubjects();
					
	}
	
}
