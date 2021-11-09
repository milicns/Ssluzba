package model;

import java.util.List;


public class Profesor {
	
public Profesor() {
	
}

private String prezime;
private String ime;
private String datumRodjenja;
private Adresa adresaStanovanja;
private String kontaktTelefon;
private String email;
private String adresaKancelarije;
private int brLicneKarte;
private String zvanje;
private int godineStaza;
private List <Predmet> predmetiNaKojimaJeProfesor;


public Profesor(String prezime, String ime, String datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
		String email, String adresaKancelarije, int brLicneKarte, String zvanje, int godineStaza,
		List<Predmet> predmetiNaKojimaJeProfesor) {
	super();
	this.prezime = prezime;
	this.ime = ime;
	this.datumRodjenja = datumRodjenja;
	this.adresaStanovanja = adresaStanovanja;
	this.kontaktTelefon = kontaktTelefon;
	this.email = email;
	this.adresaKancelarije = adresaKancelarije;
	this.brLicneKarte = brLicneKarte;
	this.zvanje = zvanje;
	this.godineStaza = godineStaza;
	this.predmetiNaKojimaJeProfesor = predmetiNaKojimaJeProfesor;
}


public String getPrezime() {
	return prezime;
}


public void setPrezime(String prezime) {
	this.prezime = prezime;
}


public String getIme() {
	return ime;
}


public void setIme(String ime) {
	this.ime = ime;
}


public String getDatumRodjenja() {
	return datumRodjenja;
}


public void setDatumRodjenja(String datumRodjenja) {
	this.datumRodjenja = datumRodjenja;
}


public Adresa getAdresaStanovanja() {
	return adresaStanovanja;
}


public void setAdresaStanovanja(Adresa adresaStanovanja) {
	this.adresaStanovanja = adresaStanovanja;
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


public String getAdresaKancelarije() {
	return adresaKancelarije;
}


public void setAdresaKancelarije(String adresaKancelarije) {
	this.adresaKancelarije = adresaKancelarije;
}


public int getBrLicneKarte() {
	return brLicneKarte;
}


public void setBrLicneKarte(int brLicneKarte) {
	this.brLicneKarte = brLicneKarte;
}


public String getZvanje() {
	return zvanje;
}


public void setZvanje(String zvanje) {
	this.zvanje = zvanje;
}


public int getGodineStaza() {
	return godineStaza;
}


public void setGodineStaza(int godineStaza) {
	this.godineStaza = godineStaza;
}


public List<Predmet> getPredmetiNaKojimaJeProfesor() {
	return predmetiNaKojimaJeProfesor;
}


public void setPredmetiNaKojimaJeProfesor(List<Predmet> predmetiNaKojimaJeProfesor) {
	this.predmetiNaKojimaJeProfesor = predmetiNaKojimaJeProfesor;
}






}
