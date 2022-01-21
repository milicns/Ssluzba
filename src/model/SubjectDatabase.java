
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
		
		try {
			deserializeSubjects();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		Subject s1;
		Subject s2;
		Subject s3;
		Subject s4;
		Subject s5;
		Subject s6;
		Subject s7;
		Subject s8;
		Subject s9;
		Subject s10;
		Subject s11;
		Subject s12;
		Subject s13;
		Subject s14;
		Subject s15;
		Subject s16;
		Subject s17;
		Subject s18;
		Subject s19;
		Subject s20;
		Subject s21;
		Subject s22;
		Subject s23;
		Subject s24;
		Subject s25;
		Subject s26;
		Subject s27;
		Subject s28;
		Subject s29;
		Subject s30;
		
			
			try {
				s1 = new Subject("p1","Osnove programiranja",Subject.Semester.Z, 1,ProfessorDatabase.getInstance().getProfessors().get(1), 7,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s1);
				s2 = new Subject("p2","Statistika",Subject.Semester.L,3,ProfessorDatabase.getInstance().getProfessors().get(1), 8,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s2);
				s3 = new Subject("p3","Algoritmi i strukture podataka",Subject.Semester.L, 9, ProfessorDatabase.getInstance().getProfessors().get(1), 5,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s3);
				s4 = new Subject("p4","LPRS",Subject.Semester.Z,3,ProfessorDatabase.getInstance().getProfessors().get(1), 7,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s4);
				s5 = new Subject("p5","Matematika",Subject.Semester.L,1,new Professor(), 11,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s5);
				s6 = new Subject("p6","Xml i web servisi",Subject.Semester.L,4,new Professor(), 6,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s6);
				s7 = new Subject("p7","Metode optimizacije",Subject.Semester.Z,3,new Professor(), 6,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s7);
				s8 = new Subject("p8","Osnove elektrotehnike",Subject.Semester.L,1,ProfessorDatabase.getInstance().getProfessors().get(4), 11,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s8);
				s9 = new Subject("p9","Sociologija",Subject.Semester.Z,1,ProfessorDatabase.getInstance().getProfessors().get(4), 10,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s9);
				s10 = new Subject("p10","Filozofija",Subject.Semester.Z,1,ProfessorDatabase.getInstance().getProfessors().get(4), 4,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s10);
				s11 = new Subject("p11","ORT",Subject.Semester.L,2,new Professor(), 7,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s11);
				s12 = new Subject("p12","NANS",Subject.Semester.L,2,ProfessorDatabase.getInstance().getProfessors().get(5), 5,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s12);
				s13 = new Subject("p13","Organizacije podataka",Subject.Semester.Z,2,ProfessorDatabase.getInstance().getProfessors().get(5), 7,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s13);
				s14 = new Subject("p14","Baze podataka",Subject.Semester.Z,2,ProfessorDatabase.getInstance().getProfessors().get(5), 6,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s14);
				s15 = new Subject("p15","Paralelno programiranje",Subject.Semester.Z,2,ProfessorDatabase.getInstance().getProfessors().get(6), 8,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s15);
				s16 = new Subject("p16","Konkurentno programiranje",Subject.Semester.L,2,ProfessorDatabase.getInstance().getProfessors().get(6), 9,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s16);
				s17 = new Subject("p17","Operativni sistemi",Subject.Semester.L,2,new Professor(), 8,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s17);
				s18 = new Subject("p18","Algebra",Subject.Semester.Z,1,new Professor(), 15,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s18);
				s19 = new Subject("p19","Diskretna matematika",Subject.Semester.L,3,new Professor(), 14,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s19);
				s20 = new Subject("ps20","Upravljacki sistemi",Subject.Semester.L,3,new Professor(), 8,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s20);
				s21 = new Subject("ps21","Osnovi elektronike",Subject.Semester.Z,2,new Professor(), 7,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s21);
				s22 = new Subject("ps22","Slucajni procesi",Subject.Semester.L,4,new Professor(), 9,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s22);
				s23 = new Subject("ps23","Racunarstvo visokih performansi",Subject.Semester.L,4,new Professor(), 10,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s23);
				s24 = new Subject("p24","Analiza 1",Subject.Semester.Z,1,new Professor(), 20,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s24);
				s25 = new Subject("it25","Informaciona bezbednost",Subject.Semester.L,4,ProfessorDatabase.getInstance().getProfessors().get(16), 9,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s25);
				s26 = new Subject("it26","Elektronsko placanje",Subject.Semester.Z,3,ProfessorDatabase.getInstance().getProfessors().get(17), 8,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s26);
				s27 = new Subject("it27","Distribuirani sistemi",Subject.Semester.L,4,ProfessorDatabase.getInstance().getProfessors().get(18), 6,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s27);
				s28 = new Subject("p28","Projektovanje softvera",Subject.Semester.Z,3,ProfessorDatabase.getInstance().getProfessors().get(17), 5,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s28);
				s29 = new Subject("p29","Informacioni sistemi",Subject.Semester.Z,4,ProfessorDatabase.getInstance().getProfessors().get(16), 6,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s29);
				s30 = new Subject("p30","Masinsko ucenje",Subject.Semester.L,4,new Professor(), 7,new ArrayList<Student>(),new ArrayList<Student>());
				subjects.add(s30);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		*/
		
	}
	


	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public Subject findByCode(String code) {
		for(Subject s: subjects) {
			if(s.getSubjectCode().equals(code)) {
				return s;
			}
		}
		return null;
	}
	
	public boolean findByCode2(String code) {
		for(Subject s: subjects) {
			if(s.getSubjectCode().equals(code)) {
				return true;
			}
		}
		return false;
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
	
	public void deleteSubject(String subjectCode) {
		for (Subject sb : subjects) {
			if (sb.getSubjectCode().equals(subjectCode)) {
				ArrayList<Student> students = sb.getFailedStudents();
				for(Student s:students) {
				 if(s.getFailedSubjects().contains(sb)) {
					 s.getFailedSubjects().remove(sb);
					
				 }
				}
				subjects.remove(sb);
				break;
			}
		}
	}
	
	public void editSubject(int row, String subjectCode, String subjectName, Semester semester, int studyYear,int espb) {
				Subject sb = getRow(row);
				sb.setSubjectCode(subjectCode);
				sb.setSubjectName(subjectName);
				sb.setSemester(semester);
				sb.setStudyYear(studyYear);
				sb.setEspb(espb);
				
	}
	
	public void addStudentToSubject(Student s, Subject sb) {
		sb.getFailedStudents().add(s);
		
	}
	
	public void removeStudentFromSubject(Student s) {
		List<Subject> subjects = SubjectDatabase.getInstance().getSubjects();
		for(Subject sb: subjects) {
			if(sb.getFailedStudents().contains(s)) {
				sb.getFailedStudents().remove(s);
				break;
			}
			
		}
	}
	
	public void serializeSubjects() throws IOException{
		
		
		File f = new File("database/subjects.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {

			XStream xs = new XStream();
			xs.addPermission(AnyTypePermission.ANY);
			xs.alias("subject", Subject.class);
			xs.toXML(subjects, os); 
		} finally {
			os.close();
		}
	}
		
	@SuppressWarnings("unchecked")
	public void deserializeSubjects() throws IOException {
		File f = new File("database/subjects.xml");
		
			XStream xs = new XStream();
			xs.allowTypes(new Class[] {Subject.class,Professor.class,Student.class});
			xs.alias("subject", Subject.class);
			this.subjects = (List<Subject>) xs.fromXML(f);
	
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
