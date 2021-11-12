package model;

import java.util.List;

public class Katedra {
	
	public Katedra() {}
	
	private String deskCode;
	private String deskName;
	private String deskManager;
	private List<Profesor> deskProfessors;
	
	public Katedra(String deskCode, String deskName, String deskManager, List<Profesor> deskProfessors) {
		super();
		this.deskCode = deskCode;
		this.deskName = deskName;
		this.deskManager = deskManager;
		this.deskProfessors = deskProfessors;
	}

	public String getDeskCode() {
		return deskCode;
	}

	public void setDeskCode(String deskCode) {
		this.deskCode = deskCode;
	}

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public String getDeskManager() {
		return deskManager;
	}

	public void setDeskManager(String deskManager) {
		this.deskManager = deskManager;
	}

	public List<Profesor> getDeskProfessors() {
		return deskProfessors;
	}

	public void setDeskProfessors(List<Profesor> deskProfessors) {
		this.deskProfessors = deskProfessors;
	}
	
}