package com.luv2code.hibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String courseTitle;
	
	@ManyToOne(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
							CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	Instructor instructor;
	
	public Course(){}
	
	
	public Course(String title) {
		
		this.courseTitle =title;
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle + "]";
	}
	
}
