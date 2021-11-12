package model;

public class Ocena {
	
	private Student student;
	private Predmet predmet;
	private int brojcanaVrednostOcene; /// must be in interval 6-10
	private String datumPolaganja;
		
	public Ocena () {
		
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


	public int getBrojcanaVrednostOcene() {
		return brojcanaVrednostOcene;
	}


	public void setBrojcanaVrednostOcene(int brojcanaVrednostOcene) {
		this.brojcanaVrednostOcene = brojcanaVrednostOcene;
	}


	public String getDatumPolaganja() {
		return datumPolaganja;
	}


	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}


	public Ocena(Student student, Predmet predmet, int brojcanaVrednostOcene, String datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.brojcanaVrednostOcene = brojcanaVrednostOcene;
		this.datumPolaganja = datumPolaganja;
	}
	
}
