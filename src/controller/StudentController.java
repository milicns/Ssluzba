package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import gui.FailedJTable;
import gui.MainFrame;
import model.Adress;
import model.Grade;
import model.Student;
import model.StudentsDatabase;
import model.Subject;
import model.Student.Status;
import view.FailedTab;

public class StudentController {

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void addStudent(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status, ArrayList<Grade> passed, ArrayList<Subject> failed){
		StudentsDatabase.getInstance().addStudent(name, surname, birthDate, adress, phoneNr, email, index, enrollYear, currentYear, status, passed, failed);
		MainFrame.getInstance().refreshStudents();
	}
	
	public void deleteStudent(String index) {
		StudentsDatabase.getInstance().deleteStudent(index);
		MainFrame.getInstance().refreshStudents();
	}
	
	public void editStudent(int row, String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status, ArrayList<Grade> passed, ArrayList<Subject> failed) {
		StudentsDatabase.getInstance().editStudent(row, name, surname, birthDate, adress, phoneNr, email, index, enrollYear, currentYear, status, passed, failed);
		MainFrame.getInstance().refreshStudents();
		
	}
	
	public void removeSubjectFromStudent(Student s, String id) {
		StudentsDatabase.getInstance().removeSubjectFromStudent(s, id);
	}
	
	public void addSubjectToStudent(Student s, Subject sb) {
		StudentsDatabase.getInstance().addSubjectToStudent(s, sb);
	}
	
}