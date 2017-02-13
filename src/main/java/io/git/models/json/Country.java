package io.git.models.json;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "country", nullable = false)
	String country;
	@Column(name = "continent", nullable = false)
	String continent;
	@Column(name = "locale", nullable = false)
	String locale;
	@Column(name = "capital", nullable = false)
	String capital;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@Override
	public String toString(){
		return "["+getCountry()+","+getCapital()+","+getContinent()+","+getId()+","+getLocale()+"]";
	}
}
