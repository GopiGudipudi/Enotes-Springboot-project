package com.exa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String qualification;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String gender;
	@Column
	private String password;
	@Column
	private String role;
	public User() {
		super();
	
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", qualification=" + qualification + ", email=" + email
				+ ", address=" + address + ", gender=" + gender + ", password=" + password + ", role=" + role + "]";
	}
	public User(String name, String qualification, String email, String address, String gender, String password,
			String role) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
