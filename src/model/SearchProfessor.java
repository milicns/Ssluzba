package model;

import java.text.ParseException;


import java.util.ArrayList;
import gui.TabbedPane;
import java.util.List;

import javax.swing.JOptionPane;

import model.ProfessorDatabase;



public class SearchProfessor {
	
	
	public SearchProfessor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private static SearchProfessor instance = null;
	
	

	public static SearchProfessor getInstance() throws ParseException {
		if (instance == null) {
			
		
			instance = new   SearchProfessor();
			
		}
		return instance;
	}
	
	
	
	
	
	public List<Professor> search;
	public List<Professor> remove;
	
	

	public SearchProfessor(String SearchProfessors) throws ParseException  {

		search= new ArrayList<Professor>(ProfessorDatabase.getInstance().getProfessors());
		
        remove =new ArrayList<Professor>();
	
		String[] splits = SearchProfessors.split("  ");
		   
		   for(Professor prof: search ) {
			   
			   
			   
			   if(splits.length==1) {
			   if(!prof.getSurname().toUpperCase().contains(splits[0].toUpperCase()))
				
				   remove.add(prof);
			   
			   }else if(splits.length==2) {
				   
				   
				   if(!prof.getSurname().toUpperCase().contains(splits[0].toUpperCase()))
						
					   remove.add(prof);
				   
				   
				   else if(!prof.getName().toUpperCase().contains(splits[1].toUpperCase()))
					   
					   
				       remove.add(prof);
	
			   }
		   }
		   
		   
		   search.removeAll(remove);
		   
			
			if(search.isEmpty()) {
				
				
				
				JOptionPane.showMessageDialog(null, "There is no professor ", "Search", JOptionPane.WARNING_MESSAGE,null);
				
			}else {
				
				ProfessorDatabase.getInstance().setProfessors(search);
				
				
			
				
				
		///		TabbedPane.getInstance().refreshProfessors(null, -1); E sad ja bih ovo stavio u TabbedPane(model) tamo za azuiranje i refresovanje 
			}
			
			
			
			
			
			
			
			
			
			
			
			
		   
		   }	
			
	
	
	
	
	
	
	
	
	
	
	
	

}
