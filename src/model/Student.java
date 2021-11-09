package model;

import java.util.List;

enum Status {
	B,S
}

public class Student {
	
	private String ime;
	private String prezime;
	private String kontaktTelefon;
	private String email;
	private int trenutnaGodina;
	private Status status;
	private List<Predmet> nepolozeniIspiti;
	
	public Student() {}
	public Student(String ime, String prezime, String kontakt, String email, int trenutnaGodina, Status status, List<Predmet> nepolozeni) {
		this.ime = ime;
		this.prezime = prezime;
		this.kontaktTelefon = kontakt;
		this.email = email;
		this.trenutnaGodina = trenutnaGodina;
		this.status = status;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}
	
	public void setTrenutnaGodina(int trenutnaGodina) {
		this.trenutnaGodina = trenutnaGodina;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status s) {
		this.status = s;
	}
	
	public List<Predmet> getNepolozeni() {
		return nepolozeniIspiti;
	}
	
	public void setNepolozeni(List<Predmet> nepolozeni) {
		this.nepolozeniIspiti = nepolozeni;
	}
}
