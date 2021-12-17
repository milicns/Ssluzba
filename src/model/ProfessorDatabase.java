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
		try {
			p1 = new Professor("Nemanja","Obradovic",new SimpleDateFormat("dd.MM.yyyy").parse("01.08.2001."),new Adress("address","1","Novi Sad","Srbija"),"1235860492321","mail1",new Adress("Office Address","1","Novi Sad", "Srbija"), 21, Title.DR, InternshipYears.REDOVNIPROFESOR, new ArrayList<Subject>());
			professors.add(p1);
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
	
	/*public void addProfesor(String name,String surname,Date birthDate,String adress,String phoneNr,String email,String officeAdress,String idNumber,Title title, int intershipYears ) {
		this.professors.add(new Professor(name,surname,birthDate,adress,phoneNr,email,officeAdress,idNumber,title,intershipYears));
		refresh=professors;*/
		
	}
	
	
	

