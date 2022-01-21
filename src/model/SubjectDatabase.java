
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Status;
import model.Subject.Semester;
	

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
	   
	
		initSubjects();

		this.columns = new ArrayList<String>();
		
		this.columns.add("Sifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB bodovi");
		this.columns.add("Godina");
		this.columns.add("Semestar");
	}
	
	

	public List<Subject> getSubjects() {
		return subjects;
	}
	
	
	private void initSubjects() {
		
		this.subjects = new ArrayList<Subject>();
		
		Subject s1;
		Subject s2;
		Subject s3;
		Subject s4;
		
			
			try {
				s1 = new Subject("E11","OISISI",Subject.Semester.L, 2, 5);
				subjects.add(s1);
				s2 = new Subject("E01","Analiza 1",Subject.Semester.L,1 ,4);
				subjects.add(s2);
				s3 = new Subject("E22","Analiza 2",Subject.Semester.Z, 2, 3);
				subjects.add(s3);
				s4 = new Subject("E23","Fizika",Subject.Semester.Z,3, 7);
				subjects.add(s4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		
		
	}
	


	public void setSubjects(List<Subject> predmeti) {
		this.subjects = predmeti;
	}
		
	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Subject subject = this.subjects.get(row);
		switch (column) {
		case 0:
			return subject.getSubjectCode();
		case 1:
			return subject.getSubjectName();
		case 2:
			return subject.getEspb();
		case 3:
			return subject.getStudyYear();
		case 4:
			return String.valueOf(subject.getSemester());
		default:
			return null;
		}
	}
	
	public Subject findById2(String id) {
		for(Subject s: subjects) {
			if(s.getSubjectCode().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	
	
	
	public void addSubject(String subjectCode, String subjectName, Semester semester, int studyYear,Professor subjectProfessor, int espb, ArrayList<Student> passed,ArrayList<Student> failed) {
		this.subjects.add(new Subject(subjectCode, subjectName, semester, studyYear,subjectProfessor, espb,passed,failed));
			
	}
	
	
	
	
	public void editSubject(int row, String subjectCode, String subjectName, Semester semester, int studyYear,int espb) {
				Subject sb = getRow(row);
				sb.setSubjectCode(subjectCode);
				sb.setSubjectName(subjectName);
				sb.setSemester(semester);
				sb.setStudyYear(studyYear);
				sb.setEspb(espb);
				
			}
	
	
	
	public void deleteSubject(String subjectCode) {
		for (Subject sb : subjects) {
			if (sb.getSubjectCode().equals(subjectCode)) {
				subjects.remove(sb);
				break;
			}
		}
	}
	
	
	
	
}
