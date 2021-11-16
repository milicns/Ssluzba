package model;

import java.util.List;

public class Department {
	
	private String departmentCode;
	private String departmentName;
	private Professor departmentManager;
	private List<Professor> departmentProfessors;
	
	public Department() {}

	public Department(String departmentCode, String departmentName, Professor departmentManager,
			List<Professor> departmentProfessors) {
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

	public List<Professor> getDepartmentProfessors() {
		return departmentProfessors;
	}

	public void setDepartmentProfessors(List<Professor> departmentProfessors) {
		this.departmentProfessors = departmentProfessors;
	}
	
}
	
