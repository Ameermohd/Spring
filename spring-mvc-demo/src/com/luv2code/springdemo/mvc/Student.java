package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstname;
	
	private String lastname;
	
	private String country;
	
	private LinkedHashMap<String,String > countryoptions = new LinkedHashMap<String, String>();

	private String favoritelanguage;
	
	private LinkedHashMap<String, String> favoritelanguageoptions = new LinkedHashMap<String, String>();
	
	private String[] operatingsystems =null;
	
	public String[] getOperatingsystems() {
		return operatingsystems;
	}

	public void setOperatingsystems(String[] operatingsystems) {
		this.operatingsystems = operatingsystems;
	}

	Student(){
		countryoptions.put("BRAZIL", "Brazil");
		countryoptions.put("CHINA", "China");
		countryoptions.put("RUSSIA", "Russia");
		countryoptions.put("ITALY", "Italy");
		countryoptions.put("EUROPE","Europe");	
		favoritelanguageoptions.put("JAVA", "Java");
		favoritelanguageoptions.put("C#", "C#");

	}
	
	public LinkedHashMap<String, String> getFavoritelanguageoptions() {
		return favoritelanguageoptions;
	}

	public String getFavoritelanguage() {
		return favoritelanguage;
	}

	public void setFavoritelanguage(String favoritelanguage) {
		this.favoritelanguage = favoritelanguage;
	}

	
	
	public LinkedHashMap<String, String> getCountryoptions() {
		return countryoptions;
	}



	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
