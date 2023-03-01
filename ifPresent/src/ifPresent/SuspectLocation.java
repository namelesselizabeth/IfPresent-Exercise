package ifPresent;

public class SuspectLocation {

	private String name;
	private String country;
	
	public SuspectLocation() {
		
	}
	
	public SuspectLocation(String country, String name) {
		name = this.name;
		country = this.country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
