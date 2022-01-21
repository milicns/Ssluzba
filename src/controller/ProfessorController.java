package controller;


import java.util.Date;
import java.util.List;

import gui.TabbedPane;
import model.ProfessorDatabase;
import model.ProfessorSubjectsDatabase;
import model.Subject;
import model.Adress;

import model.Professor;
import gui.MainFrame;

import view.ProfessorView;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProfessorController<Title> {
	
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
		
		public void removeSubjectFromProfessor1(Professor p, String i) {
			ProfessorDatabase.getInstance().removeSubjectFromProfessor(p,i);
		}
		
		public void deleteProfessor(int id) {
			ProfessorDatabase.getInstance().deleteProfessor(id);
			MainFrame.getInstance().refreshProfessors();
		}
		
		
		public String addProfessor(String name, String surname, String birthDate, String adress, String phoneNr, String email,
				String officeAdress, String idNumber, Title title, int internshipYears) throws ParseException {
		
			
			return "Uspesno Dodat";
			
		}
	/*	public String addProfessor(String name, String surname, String birthDate, String adress, String phoneNr, String email, String officeAdress, String idNumber, Title title, int internshipYears) throws ParseException {
	}
		*/
		private ProfessorController() {}
		
	
		public void removeSubjectFromProfessor(Professor p, String id) {
			ProfessorDatabase.getInstance().removeSubjectFromProfessor(p, id);
		}

		

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
