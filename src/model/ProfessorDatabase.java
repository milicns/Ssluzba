package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfessorDatabase {
	
	

	private static ProfessorDatabase instance = null;

	public static ProfessorDatabase getInstance() throws ParseException {
		if (instance == null) {
			instance = new ProfessorDatabase();
		}
		return instance;
	
	}
	
	private List<String> columns = new ArrayList<>();
	private List<Professor> professors =new ArrayList<>();
	private List<Professor> refresh =new ArrayList<>();
	
	
	
	private ProfessorDatabase() throws ParseException {
		
		
		initProfessores();

		this.columns.add("Surname");
		this.columns.add("Name");
		this.columns.add("Title");
		this.columns.add("InternshipYears");
		

	}



	private void initProfessores() throws ParseException {
		// TODO Auto-generated method stub
		
		/*
		 *Professor p1= new Professor("Nemanja","Obradovic",new SimpleDateFormat("dd.MM.yyyy").parse("01.08.2001."),"address 1","1235860492321","mail1","Office Address 1","12345678",Title.DR,internshipYears.REDOVNIPROFESOR);
		 *Professor p2= new Professor("Pera","Perovic",new SimpleDateFormat("dd.MM.yyyy").parse("15.05.1999."),"Address 2","5432120492049","mail2","Office Address 2","21399998",Title.PROF,internshipYears.DEKAN);
		 *Professor p3= new Professor("Jovan","Jovanovic",new SimpleDateFormat("dd.MM.yyyy").parse("12.05.1955."),"Address 3","5555520492049","mail2","Office Address 3","44449998",Title.MR,internshipYears.DOCENT);
		 *professors.add(p1);
		  professors.add(p2);
		   professors.add(p3);
	*/
		
		
		
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
	
	/*public void addProfesor(String name,String surname,Date birthDate,String adress,String phoneNr,String email,String officeAdress,String idNumber,Title title, int intershipYears ) {
		this.professors.add(new Professor(name,surname,birthDate,adress,phoneNr,email,officeAdress,idNumber,title,intershipYears));
		refresh=professors;*/
		
	}
	
	
	

