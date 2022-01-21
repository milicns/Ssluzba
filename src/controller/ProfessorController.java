package controller;


import java.util.Date;
import java.util.List;

import gui.TabbedPane;
import model.ProfessorDatabase;
import model.ProfessorSubjectsDatabase;
import model.Subject;
import model.Adress;

import model.Professor;
import model.Professor.Title;
import gui.MainFrame;

import view.ProfessorView;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProfessorController{
	
	 private static ProfessorController instance = null;
		private ProfessorView ProfessorView;
		
		
		public static ProfessorController getInstance() {
			if (instance == null) {
				instance = new ProfessorController();
			}
			return instance;
		}
		
		
		
		public void addSubjectToProfessor(Professor p, Subject sb) {
			ProfessorDatabase.getInstance().addSubjectToProfessor(p, sb);
		}
		
		public void removeSubjectFromProfessor(Professor p, String i) {
			ProfessorDatabase.getInstance().removeSubjectFromProfessor(p,i);
		}
		
		public void deleteProfessor(int id) {
			ProfessorDatabase.getInstance().deleteProfessor(id);
			MainFrame.getInstance().refreshProfessors();
		}
		

		
		public String addProfessor(String name, String surname, String birthDate, String adress, String phoneNr, String email,
				String officeAdress, String idNumber, Title title, int internshipYears) throws ParseException {
			
		
		
		
		
		if (surname == null) 
			return " Unesite prezime* ";
			surname = surname.trim();
		
		if (surname.isEmpty()) 
			return " Unesite prezime* ";
			
			return "Uspesno Dodat";
			
		}
	/*	public String addProfessor(String name, String surname, String birthDate, String adress, String phoneNr, String email, String officeAdress, String idNumber, Title title, int internshipYears) throws ParseException {
	}
		*/
		private ProfessorController() {}
		
	
	
		

		private void setProfessorView(ProfessorView ProfessorView) {
			if (ProfessorView == null) {
				throw new NullPointerException();
			}
			this.ProfessorView = ProfessorView;
		}
		
		public ProfessorController(ProfessorView ProfessorView) {
			setProfessorView(ProfessorView);
		}
		
		

		public ProfessorView getProfessorView() { 
			return ProfessorView;
		}
		
}
