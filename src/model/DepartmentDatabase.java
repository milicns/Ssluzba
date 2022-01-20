package model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDatabase {
	
	private static DepartmentDatabase instance = null;

	public static DepartmentDatabase getInstance() {
		if (instance == null) {
			instance = new DepartmentDatabase();
		}
		return instance;
	}
	
	private List<Department> departments;
	private List<String> columns;
	
	private DepartmentDatabase() {
		
		departments = new ArrayList<Department>();
		columns = new ArrayList<String>();
		
		this.columns.add("Šifra katedre");
		this.columns.add("Naziv");
		this.columns.add("Šef");
	}
	
	
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public Department getRow(int rowIndex) {
		return this.departments.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Department dep = this.departments.get(row);
		switch (column) {
		case 0:
			return dep.getDepartmentCode();
		case 1:
			return dep.getDepartmentName();
		case 2:
			return dep.getDepartmentManager().getName()+" "+dep.getDepartmentManager().getSurname();
		default:
			return null;
		}
	}
	
	
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	

}
