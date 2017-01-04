package model;

public class Location {

	private String continent;
	private String locale;
	private String country;
	private String capital;

	public Location(String continent, String locale, String country, String capital) {
		this.continent = continent;
		this.locale = locale;
		this.country = country;
		this.capital = capital;
	}

	public Location(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}

	public String getContinent() {
		return continent;
	}

	public String getLocale() {
		return locale;
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}
}
