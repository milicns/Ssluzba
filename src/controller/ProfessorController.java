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
		
		public static ProfessorController getInstance() {
			if (instance == null) {
				instance = new ProfessorController();
			}
			return instance;
		}
		
		
		private ProfessorController() {}
		
		private ProfessorView ProfessorView;
		
		
		public ProfessorController(ProfessorView ProfessorView){
			setProfessorView(ProfessorView);
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
		
		List<Professor> checking = ProfessorDatabase.getInstance().getProfessors();
		
		
		if (surname == null) {
			return "Unesite prezime profesora";
		}
		surname = surname.trim();
		if (surname.isEmpty()) {
			return "Unesite prezime profesora";
		}

		if (name == null) {
			return "Unesite ime profesora";
		}
		name = name.trim();
		if (name.isEmpty()) {
			return "Unesite prezime profesora";
		}
		
		if (birthDate == null) {
			return "Unesite datum rodjenja ";
		}
		birthDate = birthDate.trim();
		if (birthDate.isEmpty()) {
			return "Unesite datum rodjenja ";
		}
		if(birthDate.length()!=11){
			return "Nepravilan format";
		}
		if (adress == null) {
			return "Unesite adresu stanovanja";
		}
		adress = adress.trim();
		if (adress.isEmpty()) {
			return "Unesite adresu stanovanja";
		}
		if (phoneNr == null) {
			return "Unesite kontakt telefon";
		}
		phoneNr = phoneNr.trim();
		if (phoneNr.isEmpty()) {
			return "Unesite kontakt telefon";
		}
		if (email == null) {
			return "Unesite e-mail adresu";
		}
		email = email.trim();
		if (email.isEmpty()) {
			return "Unesite e-mail adresu";
		}
		if (officeAdress == null) {
			return "Unesite adresu kancelarije";
		}
		officeAdress = officeAdress.trim(); // kako klasu adresa pretvoriti da moze kao sa stringom . 
		if (officeAdress.isEmpty()) {
			return "Unesite adresu kancelarije";
		}
		
		idNumber = idNumber.trim();
		if (idNumber.isEmpty()) {
			return "Unesite broj licne karte";
		}
		if(idNumber.length()<8){
			return "Broj licne karte mora imati 8+ karaktera";
		}
		
		//if(ProfessorView.getInstance().findById(tfIdNumber.getText()))
			//	return "Broj licne karte već postoji, unesite novi br licne karte";
		
		//ProfessorDatabase.getInstance().findById(tfIndex.getText()))
		
		
		
		
		
		
		
		
		 
		//ProfessorDatabase.getInstance().addProfessor(surname,name,new SimpleDateFormat("dd.MM.yyyy").parse(birthDate), adress, phoneNr, email, officeAdress, idNumber, title,  internshipYears);
	
		MainFrame.getInstance().refreshTables("DODAT", -1);
		return "Profesor uspesno dodat";
	}
		
	///////////////-----------------------------------------------------------------------------------------------///////////////////////////////////////////////
	/*	public String editProfesor(String surname,String name,Date  birthDate,Adress adress,String phoneNr,String email,String adrk,String brlk,String titula,String zvanje,String licna_p) throws ParseException {
			
			List<Professor> checking = ProfessorDatabase.getInstance().getProfessors();
			
			
			if (surname == null) {
				return "Unesite prezime profesora";
			}
			surname = surname.trim();
			if (surname.isEmpty()) {
				return "Unesite prezime profesora";
			}

			if (name == null) {
				return "Unesite ime profesora";
			}
			name = name.trim();
			if (name.isEmpty()) {
				return "Unesite prezime profesora";
			}
			
			if (birthDate == null) {
				return "Unesite datum rodjenja ";
			}
			birthDate = birthDate.trim();
			if (birthDate.isEmpty()) {
				return "Unesite datum rodjenja ";
			}
			if(birthDate.length()!=11){
				return "Nepravilan format";
			}
			if (adress == null) {
				return "Unesite adresu stanovanja";
			}
			adress = adress.trim();
			if (adress.isEmpty()) {
				return "Unesite adresu stanovanja";
			}
			if (phoneNr == null) {
				return "Unesite kontakt telefon";
			}
			phoneNr = phoneNr.trim();
			if (phoneNr.isEmpty()) {
				return "Unesite kontakt telefon";
			}
			if (email == null) {
				return "Unesite e-mail adresu";
			}
			email = email.trim();
			if (email.isEmpty()) {
				return "Unesite e-mail adresu";
			}
			if (officeAdress == null) {
				return "Unesite adresu kancelarije";
			}
			officeAdress = officeAdress.trim();
			if (officeAdress.isEmpty()) {
				return "Unesite adresu kancelarije";
			}
			
			idNumber = idNumber.trim();
			if (idNumber.isEmpty()) {
				return "Unesite broj licne karte";
			}
			if(idNumber.length()<8){
				return "Broj licne karte mora imati 8+ karaktera";
			}	
		
*/
		public ProfessorView getProfessorView() {
			return ProfessorView;
		}

		private void setProfessorView(ProfessorView ProfessorView) {
			if (ProfessorView == null) {
				throw new NullPointerException();
			}
			this.ProfessorView = ProfessorView;
		}
		
}
