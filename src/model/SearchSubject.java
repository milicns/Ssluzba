package model;

import java.text.ParseException;

import gui.TabbedPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.SubjectDatabase;

import model.SearchSubject;

public class SearchSubject {
	
	public SearchSubject() {
		super();
		
	}

	
	
	  private static SearchSubject instance = null;

	public static SearchSubject getInstance() throws ParseException {
		if (instance == null) {
			instance = new SearchSubject();
		}
		return instance;
	}
	
	public List<Subject> search;
	public List<Subject> remove;
	
	
	public SearchSubject(String SearchSubject) throws ParseException  {

		search= new ArrayList<Subject>(SubjectDatabase.getInstance().getSubjects());
		
        remove =new ArrayList<Subject>();
        
        String[] splits = SearchSubject.split("  ");
        
		 
		   for(Subject sub: search ) {
		       
			       for(int i=0;i<splits.length;i++) {
			    	   
				   if(!sub.getSubjectName().toUpperCase().contains(splits[i].toUpperCase()))
					
					   remove.add(sub);
			       }
			 
	
		       
		   }
		   
		   search.removeAll(remove);
			
			if(search.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "There is no subject ", " Search ", JOptionPane.WARNING_MESSAGE,null);
				
			}else {
				
				
				SubjectDatabase.getInstance().setSubjects(search);
				
				///TabbedPane.getInstance().refreshSubject(null, -1); ISTO KO I ZA PROFESORE I PREDMETE-ZAKOMENTARISAN JE TAJ DEO KOD TABBEDPANE
			}
		   
		   }	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
