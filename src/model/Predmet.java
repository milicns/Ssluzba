package model;

import java.util.List;



enum Semestar {
	L, Z
}

public class Predmet {
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	private int espb;
	private List <Student> studentPolozio;
	private List <Student> studentNijePolozio;

	public Predmet() {
		
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			Profesor predmetniProfesor, int espb, List<Student> studentPolozio, List<Student> studentNijePolozio) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
		this.studentPolozio = studentPolozio;
		this.studentNijePolozio = studentNijePolozio;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getStudentPolozio() {
		return studentPolozio;
	}

	public void setStudentPolozio(List<Student> studentPolozio) {
		this.studentPolozio = studentPolozio;
	}

	public List<Student> getStudentNijePolozio() {
		return studentNijePolozio;
	}

	public void setStudentNijePolozio(List<Student> studentNijePolozio) {
		this.studentNijePolozio = studentNijePolozio;
	}
	
}
