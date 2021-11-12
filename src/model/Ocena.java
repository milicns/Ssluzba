package model;

import java.util.Date;

public class Ocena {
	
	private Student student;
	private Predmet subject;
	private int grade; /// must be in interval 6-10
	private Date examDate;
		
	public Ocena () {}

	public Ocena(Student student, Predmet subject, int grade, Date examDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.grade = grade;
		this.examDate = examDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getSubject() {
		return subject;
	}

	public void setSubject(Predmet subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
}
