package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class GradeDatabase {

	
	private static GradeDatabase instance = null;

	public static GradeDatabase getInstance() {
		if (instance == null) {
			instance = new GradeDatabase();
		}
		return instance;
	}

	private List<Grade> grade;
	private List<String> columns;

	private GradeDatabase() {
		
		initOcene();

		this.columns = new ArrayList<String>();
		this.columns.add("Subject Code");
		this.columns.add("Subject Name");
		this.columns.add("ESPB");
		this.columns.add("Grade");
		this.columns.add(" Date ");
	}

	private void initOcene() {
		this.grade = new ArrayList<Grade>();
		
	}

	public List<Grade> getOcene() {
		return grade;
	}

	public void setGrades(List<Grade> ocene) {
		this.grade = ocene;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Grade getRow(int rowIndex) {
		return this.grade.get(rowIndex);
	}

	////////////--------------------------E
	/////////// E SAD OVDE  JOS ZA OCENE KOJE MOZE DA UNESE ,da li treba ograniciti na 6,7,8,9,10 ili kasnije izbaciti warning message da nije dobro uneo 
	
	// ili mozda i enum  vrednosti napraviti 

	
	
	//  public void addGrade(Student student,Subject subject,OVDE STAVITI VREDNOST OCENE ocena,Date date) { // KOD VREDNOSTI OCENE DA LI IH OGRANIciti ili enum type.....
	//	this.grade.add(new Grade(student,subject,ocena,date));
	//  }

	public void removeGrade(String s) {
		for (Grade g : grade) {
			if (g.getSubject().getSubjectCode().compareTo(s) == 0) {
				grade.remove(g);
				break;
			}
		}
	}
	
	
	
	

		public String getESPB() {
				int sum=0;
					for(Grade o:grade)
							sum+=o.getSubject().getEspb();
	
						return Integer.toString(sum);
}
		
		
		
		
		
}
	
	
	
	
	
	
	
	
