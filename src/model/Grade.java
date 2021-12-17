package model;

import java.util.Date;

public class Grade {
	
	private Student student;
	private Subject subject;
	private int grade; /// must be in interval 6-10
	private Date examDate;
		
	public Grade () {}

	public Grade(Student student, Subject subject, int grade, Date examDate) {
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if(grade>=6 && grade<=10) {
		this.grade = grade;
		}
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
}
