package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.luv2code.springdemo.mvc.customvalidation.Coursecode;

public class Customer {
	
	private String firstname/*="firstname"*/;//checking whether the 
	//MVC will call get methods when the form is loaded initially
	
	@NotNull(message="is Required")
	@Size(min = 1, message = "is required")
	private String lastname;
	
	@NotNull(message="is Required")
	@Min(value=0, message="value should be >= to zero")
	@Max(value=100, message="value should be <= to hundered")
	private Integer freepasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="only 5 char/digits are allowed")
	private String postalcode;
	
	@Coursecode(value="LUVV",message = "Must start with LUVV")
	private String coursecode;
	
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
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public Integer getFreepasses() {
		return freepasses;
	}
	public void setFreepasses(Integer freepasses) {
		this.freepasses = freepasses;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	
	
	
	
	

}
