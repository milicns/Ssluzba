package model;

import java.util.ArrayList;
import java.util.List;
public class Department {
	
	private String departmentCode;
	private String departmentName;
	private Professor departmentManager;
	private ArrayList<Professor> departmentProfessors;
	
	public Department() {}

	public Department(String departmentCode, String departmentName, Professor departmentManager,
		 ArrayList<Professor> departmentProfessors) {
		super();
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.departmentManager = departmentManager;
		this.departmentProfessors = departmentProfessors;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Professor getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(Professor departmentManager) {
		this.departmentManager = departmentManager;
	}

	public ArrayList<Professor> getDepartmentProfessors() {
		return departmentProfessors;
	}

	public void setDepartmentProfessors(ArrayList<Professor> departmentProfessors) {
		this.departmentProfessors = departmentProfessors;
	}
	
}
	
