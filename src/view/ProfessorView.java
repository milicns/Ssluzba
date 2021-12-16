package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;

import model.Professor;

public class ProfessorView extends JPanel{
	
private static final long serialVersionUID = 1L;
	
	private static ProfessorView instance = null;

	public static ProfessorView getInstance() {
		if (instance == null) {
			instance = new ProfessorView();
		}
		return instance;
	}
	private Professor profesor;
	private ProfessorController profesoriController;
	
	private JPanel pnlContent;
	private JLabel lblSurname;
	private JTextField tfSurname;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblBirthDate;
	private JTextField tfBirthDate;
	private JLabel lblAdress;
	private JTextField tfAdress;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblOffAdress;
	private JTextField tfOffAdress;
	private JLabel lblIdNumber;
	private JTextField tfIdNumber;
	private JLabel lblTitle;
	private JComboBox<String> cbTitle;
	private JLabel lblinternshipYears;
	private JComboBox<String> cbinternshipYears;
	private JButton confirm;
	private JButton quit;
	private JPanel pnlButton;
	
	
	
	public ProfessorView()
	{
		initGUI(false);
		constructGUI();
	}





	private void initGUI(boolean b) {
		// TODO Auto-generated method stub
		
		
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		
		
		
		
		lblBirthDate = new JLabel("Datum rođenja*");
		tfBirthDate = new JTextField(20);
		
	   
		lblAdress = new JLabel("Adresa stanovanja*");
		tfAdress = new JTextField(20);
		
		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		
		
		lblOffAdress = new JLabel("Adresa kancelarije*");
		tfOffAdress = new JTextField(20);
		
		

		
		lblIdNumber = new JLabel("Broj lične karte*");
		tfIdNumber = new JTextField(20);
		
		
		lblTitle = new JLabel("Titula*");
		String[] TitleStrings = {"Mr","Dr","Prof"};  ///TREBA OVDE VALJDA JOS DA SE DODA
		cbTitle = new JComboBox<String>(TitleStrings);
		
		
		lblinternshipYears = new JLabel("Zvanje*");
		String[] lblinternshipYearsStrings = {"Dekan","Redovni profesor","Docent","Vanredni profesor","Asistent","Redovni profesor","Saradnik"};
		cbinternshipYears = new JComboBox<String>(lblinternshipYearsStrings);
		

		
		quit = new JButton("Odustani");
		confirm = new JButton("Potvrdi");
		
		
		
		
		
	}
	
	

	private void constructGUI() {
		// TODO Auto-generated method stub
		
		
		pnlContent.add(lblSurname, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfSurname, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfName, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblBirthDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfBirthDate, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblAdress, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfAdress, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblPhone, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfPhone, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblEmail, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfEmail, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblOffAdress, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfOffAdress, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblIdNumber, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfIdNumber, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblTitle, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbTitle, new GridBagConstraints(1, 8, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblinternshipYears, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbinternshipYears, new GridBagConstraints(1, 9, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(confirm, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(quit, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		add(pnlContent, BorderLayout.CENTER);
		add(pnlButton, BorderLayout.SOUTH);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
