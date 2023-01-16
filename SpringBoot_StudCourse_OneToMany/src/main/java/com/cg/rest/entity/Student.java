package com.cg.rest.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Stud_table")
public class Student {
	@Id
	private int id;
	private int roll;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
	public Student() {}

	public Student(int id, int roll, String name) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
	}


	public Student(List<Course> courses) {
		this.courses = courses;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", courses=" + courses + "]";
	}

	
    
}