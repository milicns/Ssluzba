package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	public Student() {}

	private String name;
	private String surname;
	private Date birthDate;
	private Adress adress;
	private String phoneNr;
	private String email;
	private String index;
	private int enrollYear;
	private int currentYear;
	private Status status;
	private double avgGrade;

	private ArrayList<Grade> passedSubjects;
	private ArrayList<Subject> failedSubjects;
	
	public Student(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status, double avgGrade, ArrayList<Grade> passedSubjects,
			ArrayList<Subject> failedSubjects) {

		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phoneNr = phoneNr;
		this.email = email;
		this.index = index;
		this.enrollYear = enrollYear;
		this.currentYear = currentYear;
		this.status = status;
		this.avgGrade = avgGrade;
		this.passedSubjects = passedSubjects;
		this.failedSubjects = failedSubjects;
	}
	
	public Student(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status, ArrayList<Grade> passedSubjects, ArrayList<Subject> failedSubjects) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phoneNr = phoneNr;
		this.email = email;
		this.index = index;
		this.enrollYear = enrollYear;
		this.currentYear = currentYear;
		this.status = status;
		this.avgGrade = avgGrade;
		this.passedSubjects = passedSubjects;
		this.failedSubjects = failedSubjects;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(int enrollYear) {
		this.enrollYear = enrollYear;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	public ArrayList<Grade> getPassedSubjects() {
		return passedSubjects;
	}

	public void setPassedSubjects(ArrayList<Grade> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}

	public ArrayList<Subject> getFailedSubjects() {
		return failedSubjects;
	}

	public void setFailedSubjects(ArrayList<Subject> failedSubjects) {
		this.failedSubjects = failedSubjects;
	}
	
	public String getValue(int row, int column) {
		Subject subject = this.failedSubjects.get(row);
		switch (column) {
		case 0:
			return subject.getSubjectCode();
		case 1:
			return subject.getSubjectName();
		case 2:
			return Integer.toString(subject.getEspb());
		case 3:
			return Integer.toString(subject.getStudyYear());
		case 4:
			return String.valueOf(subject.getSemester());
		default:
			return null;
		}
	}
	
	public enum Status {
		B,S
	}
}
