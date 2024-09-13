package com.practice.model;

public class Student {
	private int id;
	private String nameString;
	private int marks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Student(int id, String nameString, int marks) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nameString=" + nameString + ", marks=" + marks + "]";
	}
}
