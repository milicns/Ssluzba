package model;

public class Predmet {
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Profesor predmetniProfesor;
	private int espb;
	
	public Predmet() {}
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Profesor predmetniProfesor, int espb) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
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
	
	
	
}
