package com.luv2code.hibernatedemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	List<Review> reviews;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
			)
	List<Student> Students;
	
	
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

	

	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review thereview)
	{
		
		if(reviews==null)
		{
			reviews= new ArrayList<Review>();
		}
		
		reviews.add(thereview);
	}
	
	
	
	public List<Student> getStudents() {
		return Students;
	}


	public void setStudents(List<Student> students) {
		Students = students;
	}
	
	public void  addStudent(Student thestudent)
	{
		if(Students ==null)
		{
			Students = new ArrayList<Student>();
		}
		
		Students.add(thestudent);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle + "]";
	}
	
}
