package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Professor;
import model.Professor.Title;
import model.ProfessorDatabase;


public class ProfessorInformations extends JPanel{

	private JPanel pnl;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblSurname;
	private JTextField tfSurname;
	private JLabel lblBirthDate;
	private JTextField tfBirthDate;
	private JLabel lblStreet;
	private JTextField tfStreet;
	private JLabel lblNr;
	private JTextField tfNr;
	private JLabel lblCity;
	private JTextField tfCity;
	private JLabel lblState;
	private JTextField tfState;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblIdNr;
	private JTextField tfIdNr;
	private JLabel lblYears;
	private JTextField tfYears;
	private JLabel lblTitle;
	private String[] title = {"Redovni profesor","Docent","Vanredni profesor"};
	private JComboBox cbTitle;
	private JButton confirm;
	private JButton quit;
	private JPanel bPnl;
	private Professor prof;
	
	public ProfessorInformations(JDialog parent, int row) {
		prof = ProfessorDatabase.getInstance().getRow(row);
		initGui();
		constructGui();
		
	}
	
private void initGui() {
		
		setLayout(new BorderLayout());

		pnl = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		tfName.setText(prof.getName());
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		tfSurname.setText(prof.getSurname());
		
		lblBirthDate = new JLabel("Datum rođenja*");
		tfBirthDate = new JTextField(20);
		tfBirthDate.setText(new SimpleDateFormat("dd.mm.yyyy.").format(prof.getBirthDate()));
		
		lblStreet = new JLabel("Ulica");
		tfStreet = new JTextField(20);
		tfStreet.setText(prof.getAdress().getStreet());
		
		lblNr = new JLabel("Broj");
		tfNr = new JTextField(20);
		tfNr.setText(prof.getAdress().getNr());
		
		lblCity = new JLabel("Grad");
		tfCity = new JTextField(20);
		tfCity.setText(prof.getAdress().getCity());
		
		lblState = new JLabel("Drzava");
		tfState = new JTextField(20);
		tfState.setText(prof.getAdress().getState());
		
		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		tfPhone.setText(prof.getPhoneNr());
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		tfEmail.setText(prof.getEmail());
		
		lblIdNr = new JLabel("Broj indeksa*");
		tfIdNr = new JTextField(20);
		tfIdNr.setText(Integer.toString(prof.getIdNumber()));
		
		lblYears = new JLabel("Godine staža");
		tfYears = new JTextField(20);
		tfYears.setText(Integer.toString(prof.getInternshipYears()));
		
		lblTitle = new JLabel("Zvanje*");
		String t;
		if(prof.getTitle() == Title.REDOVNI_PROFESOR){
			t = title[0];
		} else if(prof.getTitle() == Title.DOCENT) {
			t = title[1];
		}  else {
			t = title[2];
		} 
		cbTitle = new JComboBox(title);
		cbTitle.setSelectedItem(t);
		
		confirm = new JButton("Potvrdi");
		quit = new JButton("Odustani");
		
		bPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
	}
	
	private void constructGui() {
	
		pnl.add(lblName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblSurname, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfSurname, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblBirthDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfBirthDate, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblStreet, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfStreet, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnl.add(lblNr, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
		pnl.add(tfNr, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnl.add(lblCity, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
			
		pnl.add(tfCity, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnl.add(lblState, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
				
		pnl.add(tfState, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblPhone, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfPhone, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblEmail, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfEmail, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblIdNr, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfIdNr, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblYears, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfYears, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblTitle, new GridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(cbTitle, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));

		bPnl.add(confirm);
		bPnl.add(quit);
		add(pnl, BorderLayout.CENTER);
		add(bPnl, BorderLayout.SOUTH);

	}
}
