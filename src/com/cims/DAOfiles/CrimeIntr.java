package com.cims.DAOfiles;

import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.structure.Crime;

public interface CrimeIntr {

	/* inserts a crime record */

	public String recordAcrime(Crime crime);

	/* gets the police station list in our database */

	public List<Crime> viewPoliceStation() throws CrimeException;

	/* displays the list of all crimes in database */

	public List<Crime> displayAllCrimes() throws CrimeException;

	/* displays the list of all crimes by a criminal in database */

	public List<Crime> displayAllCrimesOfCriminal(String criminalName) throws CrimeException;

	/* displays the list of all crimes under a particular police station */

	public List<Crime> displayAllCrimesUnderAreaPolceStation(String psName) throws CrimeException;

	/* returns the number of pending cases in a police station */

	public int numberOfPendingCasesInAreaPS(String psName) throws CrimeException;

	/* returns the number of solved cases in a police station */

	public int numberOfSolvedCasesInAreaPS(String psName) throws CrimeException;

	/* show cases all pending crimes in a list format */

	public List<Crime> displayPendingCrimes() throws CrimeException;

	/* returns number of crimes happened in a particular month */

	public int numberOfCrimesInAGivenTimeFrame(String startDate, String endDate) throws CrimeException;

	/* returns number of crimes recorded in a particular police station */

	public int numberOfCrimesInAreaPoliceStation(String psName) throws CrimeException;

	/* lists out all records of a particular crime category */

	public List<Crime> listOutRecordsOfACrimeCategory(String crimeCategory) throws CrimeException;

	/* change the status of crime from pending to 'solved' */

	String changeStatusOfCrimePendingToSolved(String date, String location, String crime);
}
