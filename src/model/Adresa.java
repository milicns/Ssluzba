package model;

public class Adresa {

	private String ulica;
	private int broj;
	
	public Adresa() {}
	
	public Adresa(String ulica, int broj) {
		super();
		this.ulica = ulica;
		this.broj = broj;
	}

	public String getUlica() {
		return ulica;
	}
	
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	public int getBroj() {
		return broj;
	}
	
	public void setBroj(int b) {
		this.broj = b;
	}
}
