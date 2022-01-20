package controller;

import model.Department;
import model.DepartmentDatabase;
import model.Professor;

public class DepartmentController {

	private static DepartmentController instance = null;
	
	public static DepartmentController getInstance() {
		if (instance == null) {
			instance = new DepartmentController();
		}
		return instance;
	}
	
	public void addManager(Department d, Professor p) {
		DepartmentDatabase.getInstance().addManager(d, p);
	}
	
}
