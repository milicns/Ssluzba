package model;

import java.util.Date;
import java.util.List;


public class Profesor {
	

	private String surname;
	private String name;
	private Date birthDate;
	private Adresa adress;
	private String phoneNr;
	private String email;
	private String officeAdress;
	private int idNumber;
	private String title;
	private int internshipYears;
	private List <Predmet> professorSubjects;
	
	public Profesor(String surname, String name, Date birthDate, Adresa adress, String phoneNr, String email,
			String officeAdress, int idNumber, String title, int internshipYears, List<Predmet> professorSubjects) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phoneNr = phoneNr;
		this.email = email;
		this.officeAdress = officeAdress;
		this.idNumber = idNumber;
		this.title = title;
		this.internshipYears = internshipYears;
		this.professorSubjects = professorSubjects;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Adresa getAdress() {
		return adress;
	}

	public void setAdress(Adresa adress) {
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

	public String getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(String officeAdress) {
		this.officeAdress = officeAdress;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getInternshipYears() {
		return internshipYears;
	}

	public void setInternshipYears(int internshipYears) {
		this.internshipYears = internshipYears;
	}

	public List<Predmet> getProfessorSubjects() {
		return professorSubjects;
	}

	public void setProfessorSubjects(List<Predmet> professorSubjects) {
		this.professorSubjects = professorSubjects;
	}

}
