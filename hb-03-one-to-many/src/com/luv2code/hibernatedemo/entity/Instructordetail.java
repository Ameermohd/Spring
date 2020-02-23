package com.luv2code.hibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name="instructor_detail")
public class Instructordetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail",cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
														CascadeType.REFRESH})
	private Instructor instructor;
	
	public Instructordetail() {
		// TODO Auto-generated constructor stub
	}

	

	public Instructordetail( String youtubeChannel, String hobby) {
		super();
		//Id = id;
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}



	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getYoutubeChannel() {
		return youtubeChannel;
	}


	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}



	
	public String toString() {
		return "Instructordetail [Id=" + Id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby
				+ ", instructor=" + instructor + "]";
	}



//	@Override
//	public String toString() {
//		return "Instructordetail [Id=" + Id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby
//				+ ", instructor=" + instructor + "]";
//	}
	 
	
	

}
