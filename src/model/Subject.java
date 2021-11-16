package model;

import java.util.List;

enum Semester {
	L, Z
}

public class Subject {
	
	private String subjectCode;
	private String subjectName;
	private Semester semester;
	private int studyYear;
	private Professor subjectProfessor;
	private int espb;
	private List <Student> passedStudents;
	private List <Student> failedStudents;
	
	public Subject(String subjectCode, String subjectName, Semester semester, int studyYear, Professor subjectProfessor,
			int espb, List<Student> passedStudents, List<Student> failedStudents) {
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

	public List<Student> getPassedStudents() {
		return passedStudents;
	}

	public void setPassedStudents(List<Student> passedStudents) {
		this.passedStudents = passedStudents;
	}

	public List<Student> getFailedStudents() {
		return failedStudents;
	}

	public void setFailedStudents(List<Student> failedStudents) {
		this.failedStudents = failedStudents;
	}
	
}
