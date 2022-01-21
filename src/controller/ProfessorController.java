package controller;


import java.util.Date;
import java.util.List;

import gui.TabbedPane;
import model.ProfessorDatabase;
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
		
		
		
		public String addProfessor(String name, String surname, String birthDate, String adress, String phoneNr, String email, String officeAdress, String idNumber, Title title, int internshipYears) throws ParseException {
		
		
		
		if (surname == null) 
			return " Unesite prezime* ";
			surname = surname.trim();
		
		if (surname.isEmpty()) 
			return " Unesite prezime* ";
			
		if (name == null) 
			return " Unesite ime* ";
		name = name.trim();
		
		if (name.isEmpty()) 
			return " Unesite prezime* ";
		
		
		if (birthDate == null) 
			return " Unesite datum*  ";
		birthDate = birthDate.trim();
		
		
		if (birthDate.isEmpty()) 
			return " Unesite datum*  ";
		
		if(birthDate.length()!=11)
			return " Format nije dobar ";
		
		if (adress == null) 
			return " Unesite adresu stanovanja* ";
		adress = adress.trim();
		
		if (adress.isEmpty()) 
			return " Unesite adresu stanovanja* ";
		
		if (phoneNr == null) 
			return " Unesite kontakt* ";
		
		phoneNr = phoneNr.trim();
		

		if (phoneNr.isEmpty()) 
			return "Unesite kontakt* ";
		
		if (email == null)
			return " Unesite e-mail adresu* ";
		email = email.trim();
		
		
		if (email.isEmpty()) 
			return "  Unesite e-mail adresu*  ";
		
		if (officeAdress == null)
			return " Unesite adresu kancelarije* ";
		officeAdress = officeAdress.trim();
		
		
		if (officeAdress.isEmpty()) 
			return "Unesite adresu kancelarije* ";
		
		if(idNumber == null)
			return "Unesite broj licne karte* ";
		idNumber = idNumber.trim();
		
		if(idNumber.length()<8)
			return "  Broj licne karte mora imati 8+ karaktera*  ";
		
		
		
		if (idNumber.isEmpty()) 
			return "  Unesite broj licne karte* ";
		
		
	
		
		//ProfessorDatabase.getInstance().findById
//		return "  Broj licne karte već postoji, unesite novi br licne karte  ";
		
			
		
		///nisam siguran za ovo ! 
		 ////////----------------------------------------------------------------------------------
		
		MainFrame.getInstance().refreshTables("Added", -1);
		return "Profesor uspesno dodat";
		//***************------------------------------------------------------------------
	}
		
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
