package com.cims.DAOfiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.Media;

import com.cims.exceptions.UserException;
import com.cims.structure.Crime;
import com.cims.structure.User;
import com.cims.utility.DAOUtillity;

public class UserIntrImpl implements UserIntr {

	@Override
	public String registerUser(User user) {

		String message = "Registration failed";

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("insert into user values(?,?,?)");

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getCity());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Registration success";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public User loginUser(String email, String password) throws UserException {

		User user = null;

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from user where email = ? and password = ?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String em = rs.getString("email");
				String pword = rs.getString("password");
				String ci = rs.getString("city");

				user = new User(em, pword, ci);

			} else {
				throw new UserException("Login Failed! invalid username or password entered.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());

		}

		return user;
	}

//	ZonedDateTime.now().toInstant().toEpochMilli())

	@Override
	public String reportCrime(Crime crime) {
		String message = "Failed to record the crime";

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("insert into crimeInformation(crimeDate,crimeLocation,crimeType,victimName,"
							+ "crimeDetails,suspectName,policeStation) " + "values(?,?,?,?,?,?,?)");

			ps.setString(1, crime.getDate());
			ps.setString(2, crime.getPlace());
			ps.setString(3, crime.getCrimeType());
			ps.setString(4, crime.getVictim());
			ps.setString(5, crime.getCrimeDescription());
			ps.setString(6, crime.getSuspectNames());
			ps.setString(7, crime.getPoliceStation());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Recorded the crime! Please wait until we take certain action!";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String getStatusOfCase(String date, String location, String crime) {

		String message = "No records found!";

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("select crimeStatus from crimeInformation where crimeDate = ? "
							+ "and crimeLocation = ? and crimeType = ?");

			ps.setString(1, date);
			ps.setString(2, location);
			ps.setString(3, crime);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				message = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;

	}

}
