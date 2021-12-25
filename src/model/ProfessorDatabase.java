package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfessorDatabase {
	
	

	private static ProfessorDatabase instance = null;

	public static ProfessorDatabase getInstance() {
		if (instance == null) {
			instance = new ProfessorDatabase();
		}
		return instance;
	
	}
	
	private List<String> columns = new ArrayList<>();
	private List<Professor> professors =new ArrayList<>();
	private List<Professor> refresh =new ArrayList<>();
	
	
	
	private ProfessorDatabase()  {
		
		
		initProfessores();

		this.columns.add("Surname");
		this.columns.add("Name");
		this.columns.add("Title");
		this.columns.add("InternshipYears");
		

	}



	private void initProfessores()  {
		// TODO Auto-generated method stub
		
		
		 Professor p1;
		 Professor p2;
		 Professor p3;
		 Professor p4;
		try {
			p1 = new Professor("Nemanja","Obradovic",new SimpleDateFormat("dd.MM.yyyy").parse("01.08.2001."),new Adress("address","1","Novi Sad","Srbija"),"1235860492321","mail1",new Adress("Office Address","1","Novi Sad", "Srbija"), 21, Title.DR, InternshipYears.REDOVNIPROFESOR, new ArrayList<Subject>());
			professors.add(p1);
			p2 = new Professor("Milan","Milovic",new SimpleDateFormat("dd.MM.yyyy").parse("01.11.2001."),new Adress("address","2","Beograd","Srbija"),"1235860492321","mail2",new Adress("Office Address","3","Novi Sad", "Srbija"), 21, Title.MR, InternshipYears.DEKAN, new ArrayList<Subject>());
			professors.add(p2);
			p3 = new Professor("Jovan","Jovic",new SimpleDateFormat("dd.MM.yyyy").parse("01.11.2011."),new Adress("address","2","Beograd","Srbija"),"1235860491234","mail3",new Adress("Office Address","2","Novi Sad", "Srbija"), 21, Title.MR, InternshipYears.REDOVNIPROFESOR, new ArrayList<Subject>());
			professors.add(p3);
			p4 = new Professor("Uros","Nedic",new SimpleDateFormat("dd.MM.yyyy").parse("01.11.1996."),new Adress("address","5","Novi Sad","Srbija"),"3215860491234","mail4",new Adress("Office Address","4","Beograd", "Srbija"), 21, Title.DR, InternshipYears.REDOVNIPROFESOR, new ArrayList<Subject>());
			professors.add(p4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
		refresh=professors;
	}
	
	
	public List<Professor> getProfessors() {
		return professors;
	}
	
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Professor professors = this.professors.get(row);

		switch (column) {
		case 0:
			return professors.getSurname();
		case 1:
			return professors.getName();
		case 2:
			return String.valueOf(professors.getTitle());
		case 3:
			return String.valueOf(professors.getInternshipYears());
		default:
			return null;
		}
	
	
	}


public void addProfessor(String surname, String name, Date birthDate, Adress adress, String phoneNr, String email,
		Adress officeAdress, int idNumber, Title title, InternshipYears internshipYears) {
	
	this.professors.add(new Professor(surname,  name,  birthDate,  adress,  phoneNr,  email, officeAdress,  idNumber,  title,  internshipYears));
		
}



public void editProfessor(int row, String surname, String name, Date birthDate, Adress adress, String phoneNr, String email,
		Adress officeAdress, int idNumber, Title title, InternshipYears internshipYears) {
	Professor p = getRow(row);
		p.setName(name);
		p.setSurname(surname);
		p.setBirthDate(birthDate);
		p.setAdress(adress);
		p.setPhoneNr(phoneNr);
		p.setEmail(email);
		p.setAdress(officeAdress);
		p.setIdNumber(idNumber);
		p.setTitle(title);
		p.setInternshipYears(internshipYears);
	
}



public void deleteProfessor(int  idNumber) {
	for (Professor p : professors) {
		if (p. getIdNumber() == (idNumber)) {
			professors.remove(p);
			break;
		}
	}
}
	
	
	
	
	
	
	
	
	
}
	
	
	

