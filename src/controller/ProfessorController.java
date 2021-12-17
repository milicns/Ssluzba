package controller;


import java.util.List;

import gui.TabbedPane;
import gui.MainFrame;
import view.ProfessorView;

import java.text.SimpleDateFormat;

public class ProfessorController {
	
	 private static ProfessorController instance = null;
		
		public static ProfessorController getInstance() {
			if (instance == null) {
				instance = new ProfessorController();
			}
			return instance;
		}
		
		
		private ProfessorController() {}
		
		private ProfessorView ProfessorView;
		
		
		
		

	
	
}
