package com.exa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="notes")

public class Notes {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
@Column
 private String title;
@Column
 private String description;
@Column
 private LocalDate date;
 public Notes() {
	super();
}
public Notes(String title, String description, LocalDate date, User user) {
	super();
	this.title = title;
	this.description = description;
	this.date = date;
	this.user = user;
}
@ManyToOne
 private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
