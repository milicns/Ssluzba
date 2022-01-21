package model;

import java.text.ParseException;
import gui.TabbedPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import model.SearchStudent;

public class SearchStudent {
	
	
	public SearchStudent() {
		super();
		
	}
	
	
	
	private static SearchStudent instance = null;

	public static SearchStudent getInstance() throws ParseException {
		if (instance == null) {
			instance = new SearchStudent();
		}
		return instance;
	}
	
	public List<Student> search;
	public List<Student> remove;
	
	

	public SearchStudent(String searchStudent) throws ParseException  {

		search= new ArrayList<Student>(StudentsDatabase.getInstance().getStudents());
		
		
        remove =new ArrayList<Student>();
	
		String[] splits = searchStudent.split(" ");
		   
		   for(Student stud: search ) {
			   
			   if(splits.length==1) {
				   
			   if(!stud.getSurname().toUpperCase().contains(splits[0].toUpperCase()))   
				
				   remove.add(stud);
			   
			   }else if(splits.length==2) {
				   
				   if(!stud.getSurname().toUpperCase().contains(splits[0].toUpperCase()))
						
					   remove.add(stud);
				   
				   else if(!stud.getName().toUpperCase().contains(splits[1].toUpperCase()))
				       remove.add(stud);
	
			   }
		   }
		   
		   search.removeAll(remove);
			
			if(search.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "There is no such subject", " Search ", JOptionPane.WARNING_MESSAGE,null);
				
			}else {
				StudentsDatabase.getInstance().setStudents(search);
				
				
				/////TabbedPane.getInstance().refreshStudent(null, -1); opet ista fora ko i kod Profesora i studenta, ja sam ovaj refresh implementirao u tabbedpane 
				                                                        //-  refresuj  ga iz svoje klase nmg da nadjem gde je
			}
		   
		   }	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
