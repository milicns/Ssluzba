package model;

public class Adress {
	
	private String street;
	private String nr;
	private String city;
    private String state;
    
    public Adress() {}

	public Adress(String street, String nr, String city, String state) {
		super();
		this.street = street;
		this.nr = nr;
		this.city = city;
		this.state = state;
	}
	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


       
}
