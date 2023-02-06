package org.student.dto;


public class Student {

	private int id;
	private String name;
	private long phoneNumber;
	private double marks;
	private String mailId;
	private String gender;

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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Student() {
		super();
	}

	public Student(int id, String name, long phoneNumber, double marks, String mailId, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.marks = marks;
		this.mailId = mailId;
		this.gender = gender;
	}
}
