package com.cims.structure;

public class Criminal {

	private int criminlId;
	private String criminalName;
	private int age;
	private String gender;
	private String address;
	private String identificationMarks;
	private String area;
	private String crime;

	/*
	 * 
	 * create table criminalInformation( criminalId int not null auto_increment,
	 * criminalName varchar(24), criminalAge int, criminalGender varchar(12) not
	 * null, criminalAddress varchar(24), identificationMarks varchar(150) not null,
	 * firstArrestedAreaPS varchar(24) not null, firstAttachedCrime varchar(24) not
	 * null ); *
	 */

	public Criminal() {

	}

	public Criminal(int criminalId, String criminalName, int age, String gender, String address,
			String identificationMarks, String area, String crime) {
		super();
		this.criminlId = criminalId;
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identificationMarks = identificationMarks;
		this.area = area;
		this.crime = crime;
	}

	public Criminal(String criminalName, int age, String gender, String address, String identificationMarks,
			String area, String crime) {
		super();
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identificationMarks = identificationMarks;
		this.area = area;
		this.crime = crime;
	}

	public int getCriminlId() {
		return criminlId;
	}

	public void setCriminlId(int criminlId) {
		this.criminlId = criminlId;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentificationMarks() {
		return identificationMarks;
	}

	public void setIdentificationMarks(String identificationMarks) {
		this.identificationMarks = identificationMarks;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	@Override
	public String toString() {
		return "CriminalId = " + criminlId + ", CriminalName = " + criminalName + ", age = " + age + ", gender = "
				+ gender + ", address = " + address + ", identificationMarks = " + identificationMarks
				+ ", first reported Police station  = " + area + ", first attached crime = " + crime + "";
	}

}
