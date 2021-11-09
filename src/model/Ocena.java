package model;

public class Ocena {
	
	private Student student;
	private Predmet predmet;
	
	public Ocena() {}
	
	public Ocena(Student student, Predmet predmet) {
		super();
		this.student = student;
		this.predmet = predmet;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	
	
	
	
}
