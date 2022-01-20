package model;

import java.util.ArrayList;
import java.util.List;

import model.Subject.Semester;

public class FailedSubjects {
		
		private List<Subject> subjects;
		private List<String> columns;

		public FailedSubjects(Student s) {
		   

            subjects = s.getFailedSubjects();
			
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
	
		public void addSubject(String subjectCode, String subjectName, Semester semester, int studyYear,Professor prof, int espb, ArrayList<Student> passed,ArrayList<Student> failed) {
			this.subjects.add(new Subject(subjectCode, subjectName, semester, studyYear,prof, espb,passed,failed));
				
		}
		
		public void deleteSubject(String subjectCode) {
			for (Subject sb : subjects) {
				if (sb.getSubjectCode().equals(subjectCode)) {
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
		
		
	
}
