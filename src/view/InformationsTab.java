package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import gui.MainFrame;
import model.Adress;
import model.Student;
import model.StudentsDatabase;
import model.Student.Status;

public class InformationsTab extends JPanel {

	private JPanel pnl;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblSurname;
	private JTextField tfSurname;
	private JLabel lblBirthDate;
	private JTextField tfBirthDate;
	private JLabel lblAdress;
	private JTextField tfAdress;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblIndex;
	private JTextField tfIndex;
	private JLabel lblEnroll;
	private JTextField tfEnroll;
	private JLabel lblCurrent;
	private String[] years = {"I(prva)","II(druga)","III(treća)","IV(četvrta)"};
	private JComboBox cbCurrent;
	private JLabel lblStatus;
	private String[] status = {"Budžet","Samofinansiranje"};
	private JComboBox cbStatus;
	private JButton confirm;
	private JButton quit;
	private JPanel bPnl;
	private Student student;
	
	public InformationsTab(int row) {
	
		student = StudentsDatabase.getInstance().getRow(row);
		
		initGui();
		constructGui();
		buttonActions();
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());

		pnl = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		tfName.setText(student.getName());
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		tfSurname.setText(student.getSurname());
		
		lblBirthDate = new JLabel("Datum rođenja*");
		tfBirthDate = new JTextField(20);
		tfBirthDate.setText(new SimpleDateFormat("dd.mm.yyyy.").format(student.getBirthDate()));
		
		lblAdress = new JLabel("Adresa stanovanja");
		tfAdress = new JTextField(20);
		tfAdress.setText(student.getAdress().getStreet()+" "+student.getAdress().getNr()+", "+student.getAdress().getCity()+", "+student.getAdress().getState());

		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		tfPhone.setText(student.getPhoneNr());
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		tfEmail.setText(student.getEmail());
		
		lblIndex = new JLabel("Broj indeksa*");
		tfIndex = new JTextField(20);
		tfIndex.setText(student.getIndex());
		
		lblEnroll = new JLabel("Godina upisa*");
		tfEnroll = new JTextField(20);
		tfEnroll.setText(Integer.toString(student.getEnrollYear()));
		
		lblCurrent = new JLabel("Trenutna godina studija*");
		String currYear;
		if(student.getCurrentYear() == 1){
			currYear = years[0];
		} else if(student.getCurrentYear() == 2) {
			currYear = years[1];
		}  else if(student.getCurrentYear() == 3) {
			currYear = years[2];
		} else {
			currYear = years[3];
		}
		cbCurrent = new JComboBox(years);
		cbCurrent.setSelectedItem(currYear.toString());
		
		
		lblStatus = new JLabel("Način finansiranja*");
		String stat;
		if(student.getStatus() == Status.B) {
			stat = "Budžet";
		} else {
			stat = "Samofinansiranje";
		}
		cbStatus = new JComboBox(status);
		cbStatus.setSelectedItem(stat);
		
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
	
		pnl.add(lblAdress, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfAdress, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblPhone, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfPhone, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblEmail, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfEmail, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblIndex, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfIndex, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblEnroll, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(tfEnroll, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblCurrent, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(cbCurrent, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		pnl.add(lblStatus, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
	
		pnl.add(cbStatus, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
			GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
	
		bPnl.add(confirm);
		bPnl.add(quit);
		add(pnl, BorderLayout.CENTER);
		add(bPnl, BorderLayout.SOUTH);
	}
	
	private void buttonActions() {
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//dispose();	
			}
		});
		
		
		confirm.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					String[] adr = tfAdress.getText().split(",");
					String[] a = adr[0].split(" ");
					Adress adress = new Adress(a[0], a[1], adr[1], adr[2]);
					
					Status status;
					if(cbStatus.getSelectedItem().toString().equals("Budžet")) {
						status = Status.B;
					} else {
						status = Status.S;
					}
					
					int currYear;
					if(cbCurrent.getSelectedItem().equals("I(prva)")){
						currYear = 1;
					} else if(cbCurrent.getSelectedItem().equals("II(druga)")) {
						currYear = 2;
					} else if(cbCurrent.getSelectedItem().equals("III(treća)")) {
						currYear = 3;
					} else {
						currYear = 4;
					}
					
				try {	
					StudentController.getInstance().editStudent(MainFrame.getInstance().getStudentTable().getSelectedRow(), tfName.getText(), tfSurname.getText(), new SimpleDateFormat("dd.mm.yyyy.").parse(tfBirthDate.getText()), adress , tfPhone.getText(), tfEmail.getText(), tfIndex.getText(), Integer.parseInt(tfEnroll.getText()), currYear, status); 
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				//dispose();	
			}
			
		});
				
	}
	
}
