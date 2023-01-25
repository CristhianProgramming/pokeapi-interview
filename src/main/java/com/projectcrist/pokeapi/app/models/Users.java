package com.projectcrist.pokeapi.app.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45)
	private String userName;
	
	@Email
	@Column(length = 100,nullable = false,unique = true)
	private String userEmail;
	
	private String userPassword;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date creationDate;

	@PrePersist
	private void newDateCreation() {
		creationDate = new Date();
	}
	
	public Users() {};
	
	public Users(String userName, @Email String userEmail, String userPassword, Date creationDate) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
}
