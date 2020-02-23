package com.luv2code.hibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

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
	
	
	

}
