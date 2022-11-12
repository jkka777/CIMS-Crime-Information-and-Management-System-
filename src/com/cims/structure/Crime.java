package com.cims.structure;

public class Crime {

	private int crimeId;
	private String date;
	private String place;
	private String crimeType;
	private String victim;
	private String crimeDescription;
	private String suspectNames;
	private String crimeStatus;
	private String policeStation;

	public Crime(int crimeId, String date, String place, String crimeType, String victim, String crimeDescription,
			String suspectNames, String crimeStatus, String policeStation) {
		super();
		this.crimeId = crimeId;
		this.date = date;
		this.place = place;
		this.crimeType = crimeType;
		this.victim = victim;
		this.crimeDescription = crimeDescription;
		this.suspectNames = suspectNames;
		this.crimeStatus = crimeStatus;
		this.policeStation = policeStation;
	}

	public Crime(String date, String place, String crimeType, String victim, String crimeDescription,
			String suspectNames, String crimeStatus, String policeStation) {
		super();
		this.date = date;
		this.place = place;
		this.crimeType = crimeType;
		this.victim = victim;
		this.crimeDescription = crimeDescription;
		this.suspectNames = suspectNames;
		this.crimeStatus = crimeStatus;
		this.policeStation = policeStation;
	}

	public Crime(String date, String place, String crimeType, String victim, String crimeDescription,
			String suspectNames, String policeStation) {
		super();

		this.date = date;
		this.place = place;
		this.crimeType = crimeType;
		this.victim = victim;
		this.crimeDescription = crimeDescription;
		this.suspectNames = suspectNames;
		this.policeStation = policeStation;
	}

	public Crime(String date, String place, String crimeType, String policeStation) {

		/*
		 * this constructor is for printing the criminal record of a particular criminal
		 */

		this.date = date;
		this.place = place;
		this.crimeType = crimeType;
		this.policeStation = policeStation;

	}

	public Crime() {

	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	public String getCrimeDescription() {
		return crimeDescription;
	}

	public void setCrimeDescription(String crimeDescription) {
		this.crimeDescription = crimeDescription;
	}

	public String getSuspectNames() {
		return suspectNames;
	}

	public void setSuspectNames(String suspectNames) {
		this.suspectNames = suspectNames;
	}

	public String getCrimeStatus() {
		return crimeStatus;
	}

	public void setCrimeStatus(String crimeStatus) {
		this.crimeStatus = crimeStatus;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	@Override
	public String toString() {
		return "Crime [crime Id =" + crimeId + ", date =" + date + ", Place = " + place + ", Crime = " + crimeType
				+ ", Victim(s) = " + victim + ", Details of crime = " + crimeDescription + ", Suspect Name = "
				+ suspectNames + ", Status = " + crimeStatus + ", Police station = " + policeStation + "]";
	}

	public String toStringCriminalInCrimeRecord() {
		return "Date of crime commited = " + date + ", Place = " + place + ", Crime = " + crimeType
				+ ", Area Police station = " + policeStation + "";
	}

	public String toStringCrimeCategory() {

		return "Crime = " + crimeType + " , Date = " + date + " , Place = " + place + " , Area PoliceStation = "
				+ policeStation + "";

	}

	public String toStringPoliceStation() {
		return policeStation;
	}

}
