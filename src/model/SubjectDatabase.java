/*package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Status;

public class SubjectDatabase {

private static SubjectDatabase instance = null;
	
	public static SubjectDatabase getInstance() {
		if (instance == null) {
			instance = new SubjectDatabase();
		}
		return instance;
	}

	private List<Subject> subjects;
	private List<String> columns;
	
	private SubjectDatabase() {
		
		
		this.columns = new ArrayList<String>();
		
		this.columns.add("Indeks");
		this.columns.add("Ime");
		this.columns.add("Prezime");
		this.columns.add("Godina studija");
		this.columns.add("Status");
		this.columns.add("Prosek");		
	}
	
	private void initStudents() {
		this.students = new ArrayList<Student>();
		
		try {
			students.add(new Student("Pera", "Perić", new SimpleDateFormat("dd.mm.yyyy.").parse("03.05.2000."), new Adress("Bulevar Oslobođenja","79","Novi Sad","Srbija"),"065/111-3434","pera.peric@gmail.com","ra-22-2019",2019,3,Status.B, 8.79, new ArrayList<Grade>(), new ArrayList<Subject>()));
			students.add(new Student("Milos", "Petrović", new SimpleDateFormat("dd.mm.yyyy.").parse("15.08.1999."), new Adress("Temerinska","121","Novi Sad","Srbija"),"064/333-5555","milos.petrovic@gmail.com","sw-14-2018",2018,4,Status.B, 9.54, new ArrayList<Grade>(), new ArrayList<Subject>()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getName();
		case 2:
			return student.getSurname();
		case 3:
			return Integer.toString(student.getCurrentYear());
		case 4:
			return student.getStatus().toString();
		case 5:
			return Double.toString(student.getAvgGrade());
		default:
			return null;
		}
	}
	
	public void addStudent(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status) {
		
		this.students.add(new Student(name, surname, birthDate, adress, phoneNr, email, index, enrollYear, currentYear, status));
	}
	
	public void deleteStudent(String id) {
		for (Student s : students) {
			if (s.getIndex().equals(id)) {
				students.remove(s);
				break;
			}
		}
	}
	
	public void editStudent(int row,String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status) {
				Student s = getRow(row);
				s.setName(name);
				s.setSurname(surname);
				s.setBirthDate(birthDate);
				s.setAdress(adress);
				s.setPhoneNr(phoneNr);
				s.setEmail(email);
				s.setIndex(index);
				s.setEnrollYear(enrollYear);
				s.setCurrentYear(currentYear);
				s.setStatus(status);
			}
	
}*/
