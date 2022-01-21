package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;


import model.Grade;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





////OVO MOZDA I NIJE TREBALA ZASEBNA KLASA, VIDI KAKO SI KOD SEBE UKLOPIO JA CU OSTAVITI ZAKOMENTARISANO 




public class EnteringGrade extends JDialog{
	
	
private static final long serialVersionUID = 1L;
	
	//
	private JPanel pnlContent;
	private JPanel pnlButtons;
    private JPanel pnlcntr; 
	private JButton btnConfirm;
	private JButton btnCancel;
	
	
	JPanel panPassword;
    JLabel lblPassword;
    JTextField txtPassword;
    JPanel panName;
    JLabel lblName;
    JTextField txtName;
    JComboBox<String> cbGrade;
    JPanel panGrade;
    JLabel lblGrade;
    JPanel panDate;
    JLabel lblDate;
    JTextField txtDate;
	 
     String Date;
     ///GradeValue gv; OVO JE ZA VREDNOST OCENE OPET DA LI ENUM ILI OGRANICENJE ili nesto 3ce 
	 
	public  EnteringGrade(Frame parent,int selRow,int subject) throws ParseException {
		super(parent, "Upis Ocene", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450,400);
		setLocationRelativeTo(parent);
		
	
		initGUI(selRow,subject);
		constructGUI(selRow,subject);
	}

	

	private void initGUI(int selRow, int subject) {

		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		pnlContent = new JPanel();
		pnlcntr =new JPanel();
		pnlButtons = new JPanel(new FlowLayout());
		btnConfirm = new JButton("Confirm");
		
		panPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    lblPassword = new JLabel("Password ");
	    txtPassword = new JTextField();
	     
	    panName = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    lblName = new JLabel("Name ");
	    txtName = new JTextField();
	     
	   /*
	    cbGrade = new JComboBox<String>(grade);
	    panGrade = new JPanel(new FlowLayout(FlowLayout.LEFT)); --------OVDE U ZAVISNOSTI OD IMPLEMENTACIJE OCENE.....
	    lblGrade=new JLabel(" Grade ");
	     */
	    
	     
	
	    panDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    lblDate = new JLabel(" Date  ");
	    txtDate= new JTextField();
		
		
		
		
		
	}
	
	
private void constructGUI(int selRow, int subject) {
	// TODO Auto-generated method stub
	
	
	Dimension dimension = new Dimension(130,30);
	pnlButtons.add(btnConfirm);
	pnlButtons.add(btnCancel);	
	
	
	
	
	lblPassword.setPreferredSize(dimension);  
	txtPassword.setPreferredSize(dimension);
	
	//txtPassword.setText(DA LI JE FAILED SUBJECT ? .getInstance().getRow(subject).getSpr()); ///MISLIM DA JE OVDE JFAILED SUBJECT NISAM SIGURAN
	
	txtPassword.setBackground(Color.WHITE);
	txtPassword.setEditable(false);
    panPassword.add(lblPassword);
    panPassword.add(txtPassword);
	
    lblName.setPreferredSize(dimension);
    txtName.setBackground(Color.WHITE);
    
   // txtName.setText(DA LI JE FAILED SUBJECT ?.getInstance().getRow(subject).getNaziv()); ///MISLIM DA JE OVDE JFAILED SUBJECT NISAM SIGURAN

    txtName.setEditable(false);
    txtName.setPreferredSize(dimension);
    panName.add(lblName);
    panName.add(txtName);
        
        
    
    
    cbGrade.setPreferredSize(dimension);
    lblGrade.setPreferredSize(dimension);
    panGrade.add(lblGrade);
    panGrade.add(cbGrade);
	   
    lblDate.setPreferredSize(dimension);
    txtDate= new JTextField();
    txtDate.setPreferredSize(dimension);
    panDate.add(lblDate);
    panDate.add(txtDate);
        
        
    Box boxCentar = Box.createVerticalBox();
    boxCentar.add(Box.createVerticalStrut(20));
    boxCentar.add(panPassword);
    boxCentar.add(panName);
    boxCentar.add(panGrade);
    boxCentar.add(panDate);
    boxCentar.add(Box.createGlue());
    add(boxCentar, BorderLayout.NORTH);
        
    pnlcntr.add(pnlContent);
    add(pnlcntr,BorderLayout.CENTER);
	add(pnlButtons,BorderLayout.SOUTH);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}

	
	
	
	
	
	
	
	


