package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

enum Title {
	REDOVNIPROFESOR, DOCENT, DEKAN
}



public class Professor {
	

	private String surname;
	private String name;
	private Date birthDate;
	private Adress adress;
	private String phoneNr;
	private String email;
	private Adress officeAdress;  
	private int idNumber;
	private Title title;
	private int internshipYears;
	private ArrayList <Subject> professorSubjects;
	
	public Professor() {}
	
	public Professor(String surname, String name, Date birthDate, Adress adress, String phoneNr, String email,
			Adress officeAdress, int idNumber, Title title, int internshipYears, ArrayList<Subject> professorSubjects) {
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
	
	public Professor(String surname, String name, Date birthDate, Adress adress, String phoneNr, String email,
			Adress officeAdress, int idNumber, Title title, int internshipYears) {
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

	public Professor() {
		super();
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

	public Adress getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(Adress officeAdress) {
		this.officeAdress = officeAdress;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public int getInternshipYears() {
		return internshipYears;
	}

	public void setInternshipYears(int internshipYears) {
		this.internshipYears = internshipYears;
	}

	public ArrayList<Subject> getProfessorSubjects() {
		return professorSubjects;
	}

	public void setProfessorSubjects(ArrayList<Subject> professorSubjects) {
		this.professorSubjects = professorSubjects;
	}
	
	public boolean findSubj(Subject s) {
		for(Subject sb: professorSubjects) {
			if(s.getSubjectCode().equals(s.getSubjectCode())) {
				return true;
			}
		}
		return false;
		
	}
	
	public Title TitleSearch(String titula) {
		Title t=null;
		switch(Integer.parseInt(titula)) {
		case 0:
			t =Title.REDOVNIPROFESOR;
		
		    break;
		case 1:
		     t=Title.DOCENT;
		     break;
		     
		case 2:
		     t=Title.DEKAN;
		     break;
		
		}
		
		return t;
	}
	
	
	
	

}
