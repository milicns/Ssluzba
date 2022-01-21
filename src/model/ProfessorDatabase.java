package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import model.Professor.Title;

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
		
		try {
			deserializeProfessors();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	/*	
		Professor p1;
		Professor p2;
		 Professor p3;
		 Professor p4;
		 Professor p5;
		 Professor p6;
		 Professor p7;
		 Professor p8;
		 Professor p9;
		 Professor p10;
		 Professor p11;
		 Professor p12;
		 Professor p13;
		 Professor p14;
		 Professor p15;
		 Professor p16;
		 Professor p17;
		 Professor p18;
		 Professor p19;
		 
		try {
			p1 = new Professor("Milos","Nikolic",new SimpleDateFormat("dd.MM.yyyy").parse("12.12.1965."),AdressBase.getInstance().getAdrese().get(0),"021/356-785","milos.nikolic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 123123123, Title.REDOVNI_PROFESOR, 30, new ArrayList<Subject>());
			p2 = new Professor("Nikola","Mirkovic",new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1978."),AdressBase.getInstance().getAdrese().get(1),"021/368-456","nikola.mirkovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 321321321, Title.REDOVNI_PROFESOR, 22, new ArrayList<Subject>());
			p3 = new Professor("Ilija","Petkovic",new SimpleDateFormat("dd.MM.yyyy").parse("03.09.1988."),AdressBase.getInstance().getAdrese().get(2),"021/215-314","ilija.petkovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 456456456, Title.VANREDNI_PROFESOR, 22, new ArrayList<Subject>());
			p4 = new Professor("Mitar","Petrovic",new SimpleDateFormat("dd.MM.yyyy").parse("25.07.1976."),AdressBase.getInstance().getAdrese().get(3),"021/884-640","mitar.petrovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 789789789, Title.VANREDNI_PROFESOR, 27, new ArrayList<Subject>());
			p5 = new Professor("Vasa","Micic",new SimpleDateFormat("dd.MM.yyyy").parse("14.02.1970."),AdressBase.getInstance().getAdrese().get(4),"021/212-114","vasa.micic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 100100144, Title.DOCENT, 24, new ArrayList<Subject>());
			p6 = new Professor("Srdjan","Miletic",new SimpleDateFormat("dd.MM.yyyy").parse("20.04.1966."),AdressBase.getInstance().getAdrese().get(5),"021/978-224","srdjan.miletic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 200020244, Title.DOCENT, 31, new ArrayList<Subject>());
			p7 = new Professor("Branislav","Mihajlovic",new SimpleDateFormat("dd.MM.yyyy").parse("28.06.1980."),AdressBase.getInstance().getAdrese().get(6),"021/778-323","branislav.mihajlovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 559585632, Title.REDOVNI_PROFESOR, 13, new ArrayList<Subject>());
			p8 = new Professor("Marko","Markovic",new SimpleDateFormat("dd.MM.yyyy").parse("31.01.1985."),AdressBase.getInstance().getAdrese().get(7),"021/899-659","marko.markovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 334968855, Title.REDOVNI_PROFESOR, 17, new ArrayList<Subject>());
			p9 = new Professor("Milos","Milakovic",new SimpleDateFormat("dd.MM.yyyy").parse("21.09.1975."),AdressBase.getInstance().getAdrese().get(8),"021/122-326","milos.milakovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 730703654, Title.VANREDNI_PROFESOR, 12, new ArrayList<Subject>());
			p10 = new Professor("Lazar","Bratic",new SimpleDateFormat("dd.MM.yyyy").parse("13.11.1973."),AdressBase.getInstance().getAdrese().get(9),"021/888-156","lazar.bratic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 600378644, Title.VANREDNI_PROFESOR, 3, new ArrayList<Subject>());
			p11 = new Professor("Ljeposava","Drazic",new SimpleDateFormat("dd.MM.yyyy").parse("11.08.1964."),AdressBase.getInstance().getAdrese().get(10),"021/456-125","ljeposava.drazic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 158496152, Title.DOCENT, 31, new ArrayList<Subject>());
			p12 = new Professor("Miroljub","Dragic",new SimpleDateFormat("dd.MM.yyyy").parse("02.03.1959."),AdressBase.getInstance().getAdrese().get(11),"021/886-455","miroljub.dragic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 777348595, Title.DOCENT, 42, new ArrayList<Subject>());
			p13 = new Professor("Bogdan","Rekavic",new SimpleDateFormat("dd.MM.yyyy").parse("23.06.1977."),AdressBase.getInstance().getAdrese().get(5),"021/945-155","bogdan.rekavic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 721254363, Title.VANREDNI_PROFESOR, 18, new ArrayList<Subject>());
			p14 = new Professor("Stanka","Milic",new SimpleDateFormat("dd.MM.yyyy").parse("03.03.1991."),AdressBase.getInstance().getAdrese().get(2),"021/746-659","stanka.milic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 225533448, Title.DOCENT, 7, new ArrayList<Subject>());
			p15 = new Professor("Milica","Vukovic",new SimpleDateFormat("dd.MM.yyyy").parse("18.10.1967."),AdressBase.getInstance().getAdrese().get(7),"021/489-326","milica.vukovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 111555888, Title.VANREDNI_PROFESOR, 14, new ArrayList<Subject>());
			p16 = new Professor("Misa","Misic",new SimpleDateFormat("dd.MM.yyyy").parse("20.10.1969."),AdressBase.getInstance().getAdrese().get(0),"021/487-265","misa.misic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 300300344, Title.DOCENT, 19, new ArrayList<Subject>());
			p17 = new Professor("Branko","Maricic",new SimpleDateFormat("dd.MM.yyyy").parse("18.01.1973."),AdressBase.getInstance().getAdrese().get(1),"021/159-478","branko.maricic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 400400444, Title.DOCENT, 22, new ArrayList<Subject>());
			p18 = new Professor("Branislav","Lukovic",new SimpleDateFormat("dd.MM.yyyy").parse("08.04.1982."),AdressBase.getInstance().getAdrese().get(2),"021/156-326","branislav.lukovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 500500544, Title.REDOVNI_PROFESOR, 9, new ArrayList<Subject>());
			p19 = new Professor("Branimir","Obradovic",new SimpleDateFormat("dd.MM.yyyy").parse("07.01.1979."),AdressBase.getInstance().getAdrese().get(0),"021/922-333","branimir.obradovic@mailinator.com",AdressBase.getInstance().getAdrese().get(9), 600600644, Title.DOCENT, 17, new ArrayList<Subject>());
			professors.add(p1);
			professors.add(p2);
			professors.add(p3);
			professors.add(p4);
			professors.add(p5);
			professors.add(p6);
			professors.add(p7);
			professors.add(p8);
			professors.add(p9);
			professors.add(p10);
			professors.add(p11);
			professors.add(p12);
			professors.add(p13);
			professors.add(p14);
			professors.add(p15);
			professors.add(p16);
			professors.add(p17);
			professors.add(p18);
			professors.add(p19);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			return professors.getName();
		case 1:
			return professors.getSurname();
		case 2:
			return String.valueOf(professors.getTitle());
		case 3:
			return String.valueOf(professors.getInternshipYears());
		default:
			return null;
		}
	
	
	}
	
	public Professor findByName(String name) {
		for(Professor p: this.professors) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public void addSubjectToProfessor(Professor p, Subject sb) {
		p.getProfessorSubjects().add(sb);
	}
	
	

	public void addProfessor(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email,
		Adress officeAdress, int idNumber, Title title, int internshipYears) {
	
		this.professors.add(new Professor(name,  surname,  birthDate,  adress,  phoneNr,  email, officeAdress,  idNumber,  title,  internshipYears));
		
	}



	public void editProfessor(int row, String surname, String name, Date birthDate, Adress adress, String phoneNr, String email,
		Adress officeAdress, int idNumber, Title title, int internshipYears) {
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



	public void deleteProfessor(int  i) {
		ArrayList<Subject> subjects = professors.get(i).getProfessorSubjects();
		for(Subject sb:subjects){
			sb.setSubjectProfessor(null);
		}
		professors.remove(i);
	}
	
	public void removeSubjectFromProfessor(Professor p, String i) {
		List<Subject> subjects = p.getProfessorSubjects();
		for(Subject sb: subjects) {
			if(sb.getSubjectCode().equals(i)) {
				subjects.remove(sb);
				sb.setSubjectProfessor(null);
				break;
			}
			
		}
		
	}
	
	
	public void serializeProfessors() throws IOException{
		
		
		File f = new File("database/professors.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {

			XStream xs = new XStream();
			xs.addPermission(AnyTypePermission.ANY);
			xs.alias("professor", Student.class);
			xs.toXML(professors, os); 
		} finally {
			os.close();
		}
	}
		
	@SuppressWarnings("unchecked")
	public void deserializeProfessors() throws IOException {
		File f = new File("database/professors.xml");
		
			XStream xs = new XStream();
			xs.allowTypes(new Class[] {Professor.class});
			xs.alias("professor", Student.class);
			this.professors = (List<Professor>) xs.fromXML(f);
	
	}

	
	
}
	
	
	

