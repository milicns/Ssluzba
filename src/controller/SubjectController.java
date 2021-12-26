package controller;

import java.text.ParseException;
import java.util.List;

import javax.security.auth.Subject;

import gui.MainFrame;


import model.SubjectDatabase;

import view.SubjectView;






public class SubjectController {
	
	private static SubjectController instance = null;
	
	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	private SubjectController() {}
	
	private SubjectView SubjectView;
	
	/*public SubjectController(SubjectView SubjectView){
		setSubjectView(SubjectView);
		}
	*/
	
	public String addSubject(String subjectCode, String subjectName, String semester, String studyYear, String espb) throws ParseException{
		
		if (subjectCode == null) {
			return "Unesite sifru predmeta";
		}
		subjectCode = subjectCode.trim();
		if (subjectCode.isEmpty()) {
			return "Unesite sifru predmeta";
		}
		//List<Subject> List = SubjectDatabase.getInstance().getSubject(); ///OVDE MI GET SUBJECT PRAVI PROB NZM ZASTO
		//for(Subject sb: List)
		{
		//	if(sb.getSubjectCode().compareTo(subjectCode)==0)  ///OVDE ISTO GET SUBJCODE 
			//	return "sifra predmeta postoji, unesite drugu sifru";
		}
		
		if (subjectName == null) {
			return "Unesite naziv predmeta";
		}
		subjectName = subjectName.trim();
		if (subjectName.isEmpty()) {
			return "Unesite naziv predmeta";
		}
		
		if (semester == null) {
			return "Unesite semestar";
		}
		semester = semester.trim();
		if (semester.isEmpty()) {
			return "Unesite semestar";
		}
		
		if (studyYear == null) {
			return "Unesite godinu";
		}
		studyYear = studyYear.trim();
		if (studyYear.isEmpty()) {
			return "Unesite godinu";
		}
		
		if (espb == null) {
			return "Unesite ESPB predmeta";
		}
		espb = espb.trim();
		if (espb.isEmpty()) {
			return "Unesite ESPB predmeta";
		}
		if(espb.length()>2){
			return "ESPB ne moze biti dvocifren";
		}
		
		int i = Integer.parseInt(semester);
	//	SubjectDatabase.getInstance().addSubject(subjectCode, subjectName, ((index == 0) ? Subject.Semester.Z : Subject.Semester.L), Integer.parseInt(studyYear)+1, Integer.parseInt(espb));
		///Semester mi pravi problem u addSubject ! 
		MainFrame.getInstance().refreshTables("DODAT", -1);
		return "Predmet dodat";
		
		
		
		
	}
	
	
}
