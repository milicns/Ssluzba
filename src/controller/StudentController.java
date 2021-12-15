package controller;

import java.util.Date;
import java.util.List;

import gui.MainFrame;
import model.Adress;
import model.Grade;
import model.Student;
import model.StudentsDatabase;
import model.Subject;
import model.Student.Status;

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
			int enrollYear, int currentYear, Status status) {
		StudentsDatabase.getInstance().addStudent(name, surname, birthDate, adress, phoneNr, email, index, enrollYear, currentYear, status);
		MainFrame.getInstance().refreshStudents();
	}
	
}