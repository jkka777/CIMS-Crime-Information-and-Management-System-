
package com.cims.DAOfiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.structure.Crime;
import com.cims.utility.DAOUtillity;

public class CrimeIntrImpl implements CrimeIntr {

	@Override
	public String recordAcrime(Crime crime) {

		/* inserts a crime record */

		String message = "Failed to record the crime";

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("insert into crimeInformation(crimeDate,crimeLocation,crimeType,victimName,"
							+ "crimeDetails,suspectName,policeStation,crimeStatus) " + "values(?,?,?,?,?,?,?,?)");

			ps.setString(1, crime.getDate());
			ps.setString(2, crime.getPlace());
			ps.setString(3, crime.getCrimeType());
			ps.setString(4, crime.getVictim());
			ps.setString(5, crime.getCrimeDescription());
			ps.setString(6, crime.getSuspectNames());
			ps.setString(7, crime.getPoliceStation());
			ps.setString(8, crime.getCrimeStatus());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Recorded the crime! Please wait until we take certain action!";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<Crime> displayAllCrimes() throws CrimeException {

		/* displays the list of all crimes in database */

		List<Crime> list = new ArrayList<>();

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from crimeInformation");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Crime crime = new Crime(rs.getInt("crimeId"), rs.getString("crimeDate"), rs.getString("crimeLocation"),
						rs.getString("crimeType"), rs.getString("victimName"), rs.getString("crimeDetails"),
						rs.getString("suspectName"), rs.getString("crimeStatus"), rs.getString("policeStation"));

				list.add(crime);
			}

		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CrimeException("No records found!");
		}

		return list;
	}

	@Override
	public List<Crime> displayAllCrimesOfCriminal(String criminalName) throws CrimeException {

		/* displays the list of all crimes by a criminal in database */

		List<Crime> list = new ArrayList<>();

		try {
			Connection connection = DAOUtillity.provideConnection();
			PreparedStatement ps = connection.prepareStatement("select crimeDate,crimeLocation,crimeType, "
					+ "policeStation from crimeInformation where suspectName = ?");

			ps.setString(1, criminalName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Crime crime = new Crime(rs.getString("crimeDate"), rs.getString("crimeLocation"),
						rs.getString("crimeType"), rs.getString("policeStation"));

				list.add(crime);
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CrimeException("No records found!");
		}

		return list;
	}

	@Override
	public List<Crime> displayAllCrimesUnderAreaPolceStation(String psName) throws CrimeException {

		/* displays the list of all crimes under a particular police station */

		List<Crime> list = new ArrayList<>();

		try {
			Connection connection = DAOUtillity.provideConnection();
			PreparedStatement ps = connection
					.prepareStatement("select * from crimeInformation where policeStation = ?");

			ps.setString(1, psName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Crime crime = new Crime(rs.getInt("crimeId"), rs.getString("crimeDate"), rs.getString("crimeLocation"),
						rs.getString("crimeType"), rs.getString("victimName"), rs.getString("crimeDetails"),
						rs.getString("suspectName"), rs.getString("crimeStatus"), rs.getString("policeStation"));

				list.add(crime);
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CrimeException("No records found!");
		}

		return list;

	}

	@Override
	public int numberOfPendingCasesInAreaPS(String psName) throws CrimeException {

		/* returns the number of pending cases in a police station */

		int number = 0;

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("select count(crimeStatus) from crimeInformation where crimeStatus = 'pending' "
							+ "and policeStation = ? group by policeStation");

			ps.setString(1, psName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				number = rs.getInt(1);

			} else {
				throw new CrimeException("No records found");
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());

		}

		return number;
	}

	@Override
	public int numberOfSolvedCasesInAreaPS(String psName) throws CrimeException {

		/* returns the number of solved cases in a police station */

		int number = 0;

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("select count(crimeStatus) from crimeInformation where crimeStatus = 'solved' "
							+ "and policeStation = ? group by policeStation");

			ps.setString(1, psName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				number = rs.getInt(1);

			} else {
				throw new CrimeException("No records found");
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());

		}

		return number;
	}

	@Override
	public List<Crime> listOutRecordsOfACrimeCategory(String crimeCategory) throws CrimeException {

		/* lists out all records of a particular crime category */

		List<Crime> list = new ArrayList<>();

		try {
			Connection connection = DAOUtillity.provideConnection();
			PreparedStatement ps = connection
					.prepareStatement("select crimeDate, crimeLocation, crimeType ,policeStation "
							+ "from crimeInformation " + "where crimeType = ? order by crimeDate desc;");

			ps.setString(1, crimeCategory);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Crime crime = new Crime(rs.getString("crimeDate"), rs.getString("crimeLocation"),
						rs.getString("crimeType"), rs.getString("policeStation"));

				list.add(crime);
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CrimeException("No records found!");
		}

		return list;

	}

	@Override
	public List<Crime> displayPendingCrimes() throws CrimeException {

		List<Crime> list = new ArrayList<>();

		try (Connection connection = DAOUtillity.provideConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("select * from crimeInformation where crimeStatus = 'pending'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Crime crime = new Crime(rs.getInt("crimeId"), rs.getString("crimeDate"), rs.getString("crimeLocation"),
						rs.getString("crimeType"), rs.getString("victimName"), rs.getString("crimeDetails"),
						rs.getString("suspectName"), rs.getString("crimeStatus"), rs.getString("policeStation"));

				list.add(crime);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CrimeException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CrimeException("No records found!");
		}

		return list;
	}

	@Override
	public int numberOfCrimesInAGivenTimeFrame(String startDate, String endDate) throws CrimeException {

		int number = 0;

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement(
					"select count(crimeType) from crimeInformation " + "where crimeDate between ? and ?");

			ps.setString(1, startDate);
			ps.setString(2, endDate);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				number = rs.getInt(1);

			} else {
				throw new CrimeException("No records found");
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());

		}

		return number;
	}

	@Override
	public String changeStatusOfCrimePendingToSolved(String date, String location, String crime) {

		String message = "Failed to update the status!";

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement(" update crimeInformation set crimeStatus = 'solved' where crimeDate = ? "
							+ "and crimeLocation = ? and crimeType = ?;");

			ps.setString(1, date);
			ps.setString(2, location);
			ps.setString(3, crime);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Changed the status of crime successfully!";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;

	}

	@Override
	public List viewPoliceStation() throws CrimeException {

		/* gets the police station list in our database */

		List<Object> list = new ArrayList<>();

		try {
			Connection connection = DAOUtillity.provideConnection();
			PreparedStatement ps = connection
					.prepareStatement("select distinct policeStation from crimeInformation order by policeStation");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				list.add(rs.getString("policeStation"));
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CrimeException("No records found!");
		}

		return list;

	}

	@Override
	public int numberOfCrimesInAreaPoliceStation(String psName) throws CrimeException {

		int number = 0;

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("select count(crimeType) from crimeInformation where policeStation = ?;");

			ps.setString(1, psName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				number = rs.getInt(1);

			} else {
				throw new CrimeException("No records found");
			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());

		}

		return number;

	}

}
