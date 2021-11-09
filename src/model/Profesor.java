package model;

public class Profesor {
	
	private String prezime;
	private Adresa adresaStanovanja;
	private String brojTelefona;
	private int brLicneKarte;
	private String zvanje;
	
	public Profesor() {}
	
	public Profesor(String prezime, Adresa adresaStanovanja, String brojTelefona, int brLicneKarte, String zvanje) {
		super();
		this.prezime = prezime;
		this.adresaStanovanja = adresaStanovanja;
		this.brojTelefona = brojTelefona;
		this.brLicneKarte = brLicneKarte;
		this.zvanje = zvanje;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
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
	
	
	
}
