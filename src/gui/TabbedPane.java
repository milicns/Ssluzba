package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.TabbedPane;

import tables.AbstractTableProfessor;
import tables.AbstractTableSubject;
import tables.TableProfessor;
import tables.TableSubject;

public class TabbedPane extends JTabbedPane{
	
	
	private static final long serialVersionUID = 1L;
	
private static int selectedIndex1=0;
	
public static int getSelectedIndex1() {
	    System.out.println(String.valueOf(selectedIndex1));
		return selectedIndex1;
	}
	
private static TabbedPane instance=null;

    public static TabbedPane getInstance() throws ParseException {
        if (instance == null) {
            instance = new TabbedPane();
        }
        return instance;
    }
    
    
    private Toolkit t=Toolkit.getDefaultToolkit();
    private Dimension dim=t.getScreenSize();
	private int w=dim.width*3/4;
    private int h=dim.height*3/4;
    
    
    
    private JPanel prof=new JPanel();
    private JPanel sub=new JPanel();
    
    
    private JTable TableProfessors;
    private JTable TableSubject;
    private TabbedPane() throws ParseException {


        
        add("Profesori",prof);
        showTableProfessors();
        add("Predmeti",sub);
        showTableSubjects();
         prof.setBackground(new Color(91, 102, 117));  ///promeni u white kasnije 
         sub.setBackground(new Color(91, 102, 117));



    }

    
    
   


    public void refreshProfessors(String akcija, int vrednost) {
    	AbstractTableProfessor model = (AbstractTableProfessor) TableProfessors.getModel();

         model.fireTableDataChanged();
         validate();
     }
    public void refreshSubject(String akcija, int vrednost) {
    	AbstractTableSubject model = (AbstractTableSubject) TableSubject.getModel();

        model.fireTableDataChanged();
        validate();
    }

   public void showTableProfessors() throws ParseException {

	   TableProfessors  = new TableProfessor();

         JScrollPane scrollPane = new JScrollPane(TableProfessors);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         prof.add(scrollPane, BorderLayout.CENTER);


         this.refreshProfessors(null, -1);
     }
  
     
   private void showTableSubjects() throws ParseException {

	   TableSubject  = new TableSubject();

         JScrollPane scrollPane = new JScrollPane( TableSubject);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         sub.add(scrollPane, BorderLayout.CENTER);


         this.refreshSubject(null, -1);
     }



public JTable getTableSubject() {
	return TableSubject;
}
public void setTableSubject(JTable tableSubject) {
	this.TableSubject = tableSubject;
}



public JTable getTableProfessors() {
	return TableProfessors;
}
public void setTableProfessors(JTable tableProfessors) {
	this.TableProfessors = tableProfessors;
}
   	

	

    }
    
   
    
    
    

	
	
