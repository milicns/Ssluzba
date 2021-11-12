package model;

public class Katedra {
	
	private String sifraKatedre;
	private String nazivKatedre;
	
	public Katedra() {}
	
	public Katedra(String sifraKatedre, String nazivKatedre) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
	}

	public String getSifra() {
		return sifraKatedre;
	}

	public void setSifra(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}

	public String getNaziv() {
		return nazivKatedre;
	}

	public void setNaziv(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}
	
	
	
	
}
