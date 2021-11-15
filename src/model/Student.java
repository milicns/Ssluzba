package model;

import java.util.Date;
import java.util.List;

enum Status {
	B,S
}

public class Student {
	
	public Student() {}

	private String name;
	private String surname;
	private Date birthDate;
	private Adress adress;
	private String phoneNr;
	private String email;
	private int index;
	private int enrollYear;
	private int currentYear;
	private Status status;
	private long avgGrade;
	private List<Subject> passedSubjects;
	private List<Subject> failedSubjects;
	
	public Student(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, int index,
			int enrollYear, int currentYear, Status status, long avgGrade, List<Subject> passedSubjects,
			List<Subject> failedSubjects) {
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
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

	public long getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(long avgGrade) {
		this.avgGrade = avgGrade;
	}

	public List<Subject> getPassedSubjects() {
		return passedSubjects;
	}

	public void setPassedSubjects(List<Subject> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}

	public List<Subject> getFailedSubjects() {
		return failedSubjects;
	}

	public void setFailedSubjects(List<Subject> failedSubjects) {
		this.failedSubjects = failedSubjects;
	}
	
}
