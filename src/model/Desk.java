package model;

import java.util.List;

public class Desk {
	
	public Desk() {}
	
	private String deskCode;
	private String deskName;
	private Professor deskManager;
	private List<Professor> deskProfessors;
	
	public Desk(String deskCode, String deskName, Professor deskManager, List<Professor> deskProfessors) {
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

	public Professor getDeskManager() {
		return deskManager;
	}

	public void setDeskManager(Professor deskManager) {
		this.deskManager = deskManager;
	}

	public List<Professor> getDeskProfessors() {
		return deskProfessors;
	}

	public void setDeskProfessors(List<Professor> deskProfessors) {
		this.deskProfessors = deskProfessors;
	}
	
}