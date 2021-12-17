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
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.Adress;
import model.Student.Status;


public class StudentDialog extends JDialog {
	
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
	
	public StudentDialog(JFrame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		setSize(500,500);
		setLocationRelativeTo(parent);
		setTitle(title);
		initGui();
		constructGui();
		buttonActions();
		
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());

		pnl = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		
		lblBirthDate = new JLabel("Datum rođenja*");
		tfBirthDate = new JTextField(20);
		
		lblAdress = new JLabel("Adresa stanovanja");
		tfAdress = new JTextField(20);

		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		
		lblIndex = new JLabel("Broj indeksa*");
		tfIndex = new JTextField(20);
		
		lblEnroll = new JLabel("Godina upisa*");
		tfEnroll = new JTextField(20);
		
		lblCurrent = new JLabel("Trenutna godina studija*");
		cbCurrent = new JComboBox(years);
		
		lblStatus = new JLabel("Način finansiranja*");
		cbStatus = new JComboBox(status);
		
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
				dispose();	
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
					inputCheck();
					StudentController.getInstance().addStudent(tfName.getText(), tfSurname.getText(), new SimpleDateFormat("dd.mm.yyyy.").parse(tfBirthDate.getText()), adress , tfPhone.getText(), tfEmail.getText(), tfIndex.getText(), Integer.parseInt(tfEnroll.getText()), currYear, status); 
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				dispose();	
			}
			
		});			
	}
	
	public void inputCheck() {
		
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
		
		//https://security.dev/secure-coding-java/input-string-validation-java/
		if(!Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+",tfName.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite validno ime, bez specijalnih znakova");
			confirm.setEnabled(false);
		}
		if(!Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+",tfSurname.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite validno prezime, bez specijalnih znakova");
			confirm.setEnabled(false);
		}
		if(!Pattern.matches("[0-9]{8,11}",tfPhone.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite validan broj telefona");
			confirm.setEnabled(false);
		}
		if(!Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", tfEmail.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite validnu email adresu. Na primer: imeprezime@gmail.com");
			confirm.setEnabled(false);
		}
		if(!Pattern.matches("[A-za-z]{1,3}-[0-9]{1,4}-[0-9]{4}", tfIndex.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite validan broj indeksa. Na primer: ra-11-2018");
			confirm.setEnabled(false);
		}
		if(!Pattern.matches("20[0-9]{2}", tfEnroll.getText())) {
			JOptionPane.showMessageDialog(null, "Unesite validnu godinu upisa");
			confirm.setEnabled(false);
		}
	}
}
