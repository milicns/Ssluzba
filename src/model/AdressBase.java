package model;

import java.util.ArrayList;
import java.util.List;

public class AdressBase {

	private static AdressBase instance = null;

	public static AdressBase getInstance() {
		if (instance == null) {
			instance = new AdressBase();
		}
		return instance;
	}
	
	private List<Adress> adrese;
	private Adress a1;
	private Adress a2;
	private Adress a3;
	private Adress a4;
	private Adress a5;
	private Adress a6;
	private Adress a7;
	private Adress a8;
	private Adress a9;
	private Adress a10;
	private Adress a11;
	private Adress a12;
	
	
	private AdressBase() {
		
		adrese = new ArrayList<Adress>();
		
		a1 = new Adress("Safarikova","2","Novi Sad","Srbija");
		a2 = new Adress("Nikole Tesle","56","Novi Sad","Srbija");
		a3 = new Adress("Bulevar Patrijarha Pavla","3","Beograd","Srbija");
		a4 = new Adress("Strazilovska","6a","Novi Sad","Srbija");
		a5 = new Adress("Nikole Pasica","2d","Kikinda","Srbija");
		a6 = new Adress("Bulevar Kralja Petra","22","Nis","Srbija");
		a7 = new Adress("Tolstojeva","31","Novi Sad","Srbija");
		a8 = new Adress("Mariceva","11","Kragujevac","Srbija");
		a9 = new Adress("Strazilovksa","3","Beograd","Srbija");
		a10 = new Adress("Nikole Pasica","6a","Novi Sad","Srbija");
		a11 = new Adress("Bulevar Kralja Petra","2d","Nis","Srbija");
		a12 = new Adress("Knez Mihajlova","22","Beograd","Srbija");
		adrese.add(a1);
		adrese.add(a2);
		adrese.add(a3);
		adrese.add(a4);
		adrese.add(a5);
		adrese.add(a6);
		adrese.add(a7);
		adrese.add(a8);
		adrese.add(a9);
		adrese.add(a10);
		adrese.add(a11);
		adrese.add(a12);
		
	}

	public List<Adress> getAdrese() {
		return adrese;
	}

	public void setAdrese(List<Adress> adrese) {
		this.adrese = adrese;
	}
	
}
