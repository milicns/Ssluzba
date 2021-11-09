package model;

import java.util.List;





public class Katedra {
	
	
	public Katedra() {
	}
	
	
	private String sifraKatedre;
	private String nazivKatedre;
	private String sefKatedre;
	private List<Profesor> profesoriNaKatedri;
	
	public String getSifraKatedre() {
		return sifraKatedre;
	}

	public void setSifraKatedre(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}

	public String getNazivKatedre() {
		return nazivKatedre;
	}

	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}

	public String getSefKatedre() {
		return sefKatedre;
	}

	public void setSefKatedre(String sefKatedre) {
		this.sefKatedre = sefKatedre;
	}

	public List<Profesor> getProfesoriNaKatedri() {
		return profesoriNaKatedri;
	}

	public void setProfesoriNaKatedri(List<Profesor> profesoriNaKatedri) {
		this.profesoriNaKatedri = profesoriNaKatedri;
	}

	public Katedra(String sifraKatedre, String nazivKatedre, String sefKatedre, List<Profesor> profesoriNaKatedri) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		this.profesoriNaKatedri = profesoriNaKatedri;
	}
	

}
