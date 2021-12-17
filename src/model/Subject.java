package model;

import java.util.ArrayList;
import java.util.List;


public class Subject {
	
	private String subjectCode;
	private String subjectName;
	private Semester semester;
	private int studyYear;
	private Professor subjectProfessor;
	private int espb;
	private ArrayList <Student> passedStudents;
	private ArrayList <Student> failedStudents;
	
	public Subject(String subjectCode, String subjectName, Semester semester, int studyYear, Professor subjectProfessor,
			int espb, ArrayList<Student> passedStudents, ArrayList<Student> failedStudents) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.semester = semester;
		this.studyYear = studyYear;
		this.subjectProfessor = subjectProfessor;
		this.espb = espb;
		this.passedStudents = passedStudents;
		this.failedStudents = failedStudents;
	}
	
	public Subject(String subjectCode, String subjectName, Semester semester, int studyYear, Professor subjectProfessor,
			int espb) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.semester = semester;
		this.studyYear = studyYear;
		this.subjectProfessor = subjectProfessor;
		this.espb = espb;
		this.passedStudents = passedStudents;
		this.failedStudents = failedStudents;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	public Professor getSubjectProfessor() {
		return subjectProfessor;
	}

	public void setSubjectProfessor(Professor subjectProfessor) {
		this.subjectProfessor = subjectProfessor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<Student> getPassedStudents() {
		return passedStudents;
	}

	public void setPassedStudents(ArrayList<Student> passedStudents) {
		this.passedStudents = passedStudents;
	}

	public ArrayList<Student> getFailedStudents() {
		return failedStudents;
	}

	public void setFailedStudents(ArrayList<Student> failedStudents) {
		this.failedStudents = failedStudents;
	}
	
	public enum Semester {
		L, Z
	}
	
}
