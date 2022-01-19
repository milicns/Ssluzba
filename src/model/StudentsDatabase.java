package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import model.Student.Status;

/**
 * @param args
 * @throws IOException
 */

public class StudentsDatabase {

	private static StudentsDatabase instance = null;
	
	public static StudentsDatabase getInstance() {
		if (instance == null) {
			instance = new StudentsDatabase();
		}
		return instance;
	}

	private List<Student> students;
	private List<String> columns;
	
	private StudentsDatabase() {
		initStudents();
		
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
			deserialize();
		} catch (Exception e) {
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
	
	public boolean findById(String id) {
		for(Student s: students) {
			if(s.getIndex().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public Student findById2(String id) {
		for(Student s: students) {
			if(s.getIndex().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	public void addSubject(Student s, Subject sb) {
		s.getFailedSubjects().add(sb);
		
	}
	
	public void removeSubject(Student s, String id) {
		List<Subject> subjects = s.getFailedSubjects();
		for(Subject sb: subjects) {
			if(sb.getSubjectCode().equals(id)) {
				subjects.remove(sb);
				break;
			}
			
		}
	}
	
	public void addStudent(String name, String surname, Date birthDate, Adress adress, String phoneNr, String email, String index,
			int enrollYear, int currentYear, Status status, ArrayList<Grade> passed, ArrayList<Subject> failed) {
		
		this.students.add(new Student(name, surname, birthDate, adress, phoneNr, email, index, enrollYear, currentYear, status, passed, failed));
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
			int enrollYear, int currentYear, Status status, ArrayList<Grade> passed, ArrayList<Subject> failed) {
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
	
	public void serialize() throws IOException{
		
		
		File f = new File("database/students.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {

			XStream xs = new XStream();
			xs.addPermission(AnyTypePermission.ANY);
			xs.alias("student", Student.class);
			xs.toXML(students, os); 
		} finally {
			os.close();
		}
	}
		
	@SuppressWarnings("unchecked")
	public void deserialize() throws IOException {
		File f = new File("database/students.xml");
		
			XStream xs = new XStream();
			xs.allowTypes(new Class[] {Student.class,Subject.class});
			xs.alias("student", Student.class);
			this.students = (List<Student>) xs.fromXML(f);
	
	}
	
	
	
}
