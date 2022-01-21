package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import gui.MainFrame;
import model.Professor.Title;

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
	private Department d1;
	private Department d2;
	private Department d3;
	private Department d4;
	private Department d5;
	private Department d6;
	private ArrayList<Professor> l1;
	private ArrayList<Professor> l2;
	private ArrayList<Professor> l3;
	private ArrayList<Professor> l4;
	private ArrayList<Professor> l5;
	private ArrayList<Professor> l6;
	
	
	private DepartmentDatabase() {
		
		
		departments = new ArrayList<Department>();
		
		try {
			deserializeDepartments();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		columns = new ArrayList<String>();
		/*
		l1 = new ArrayList<Professor>();
		l2 = new ArrayList<Professor>();
		l3 = new ArrayList<Professor>();
		l4 = new ArrayList<Professor>();
		l5 = new ArrayList<Professor>();
		l6 = new ArrayList<Professor>();
		l1.add(ProfessorDatabase.getInstance().getProfessors().get(0));
		l1.add(ProfessorDatabase.getInstance().getProfessors().get(1));
		l1.add(ProfessorDatabase.getInstance().getProfessors().get(18));
		
		l2.add(ProfessorDatabase.getInstance().getProfessors().get(2));
		l2.add(ProfessorDatabase.getInstance().getProfessors().get(7));
		l2.add(ProfessorDatabase.getInstance().getProfessors().get(13));
		
		l3.add(ProfessorDatabase.getInstance().getProfessors().get(3));
		l3.add(ProfessorDatabase.getInstance().getProfessors().get(8));
		l3.add(ProfessorDatabase.getInstance().getProfessors().get(14));
		
		l4.add(ProfessorDatabase.getInstance().getProfessors().get(6));
		l4.add(ProfessorDatabase.getInstance().getProfessors().get(9));
		l4.add(ProfessorDatabase.getInstance().getProfessors().get(15));
		
		l5.add(ProfessorDatabase.getInstance().getProfessors().get(4));
		l5.add(ProfessorDatabase.getInstance().getProfessors().get(10));
		l5.add(ProfessorDatabase.getInstance().getProfessors().get(12));
		l5.add(ProfessorDatabase.getInstance().getProfessors().get(16));
		
		l6.add(ProfessorDatabase.getInstance().getProfessors().get(5));
		l6.add(ProfessorDatabase.getInstance().getProfessors().get(11));
		l6.add(ProfessorDatabase.getInstance().getProfessors().get(17));
		
		
		d1 = new Department("e42","Katedra za matematiku",ProfessorDatabase.getInstance().getProfessors().get(1), l1);
		d2 = new Department("e43","Katedra za fiziku",ProfessorDatabase.getInstance().getProfessors().get(2), l2);
		d3 = new Department("e44","Katedra za elektrotehniku",ProfessorDatabase.getInstance().getProfessors().get(3), l3);
		d4 = new Department("e45","Katedra za primenjene računarske nauke",ProfessorDatabase.getInstance().getProfessors().get(6), l4);
		d5 = new Department("e46","Katedra za informatiku",ProfessorDatabase.getInstance().getProfessors().get(12), l5);
		d6 = new Department("e47","Katedra za automatiku",ProfessorDatabase.getInstance().getProfessors().get(17), l6);
		
		departments.add(d1);
		departments.add(d2);
		departments.add(d3);
		departments.add(d4);
		departments.add(d5);
		departments.add(d6);
		*/
		
		this.columns.add("Šifra katedre");
		this.columns.add("Naziv");
		this.columns.add("Šef");
	}
	
	
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public void addManager(Department d,Professor p) {
		d.setDepartmentManager(p);
	}
	
	public boolean checkManagers(Professor p) {
		for(Department d: departments) {
			if(d.getDepartmentManager().equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean check(Department d, Professor p) {
		if(d.getDepartmentProfessors().contains(p)) {
			return true;
		}
		return false;
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
			String s = "";
			if(dep.getDepartmentManager().getName()==null || dep.getDepartmentManager().getSurname()==null) {
				return s + s;
			}else {
			return dep.getDepartmentManager().getName()+" "+dep.getDepartmentManager().getSurname();
			}
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
	
	public void serializeDepartments() throws IOException{
		
		
		File f = new File("database/departments.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {

			XStream xs = new XStream();
			xs.addPermission(AnyTypePermission.ANY);
			xs.alias("department", Department.class);
			xs.toXML(departments, os); 
		} finally {
			os.close();
		}
	}
		
	@SuppressWarnings("unchecked")
	public void deserializeDepartments() throws IOException {
		File f = new File("database/departments.xml");
		
			XStream xs = new XStream();
			xs.allowTypes(new Class[] {Department.class,Professor.class});
			xs.alias("department", Department.class);
			this.departments = (List<Department>) xs.fromXML(f);
	
	}

}
