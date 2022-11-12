package com.cims.DAOfiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.exceptions.CrimeException;
import com.cims.exceptions.CriminalException;
import com.cims.structure.Crime;
import com.cims.structure.Criminal;
import com.cims.utility.DAOUtillity;

public class CriminalIntrImpl implements CriminalIntr {

	@Override
	public String recordACriminal(Criminal criminal) {

		/* inserts a criminal record */

		String message = "Failed to record the criminal";

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection
					.prepareStatement("insert into criminalInformation(criminalName, criminalAge"
							+ ", criminalGender, criminalAddress, identificationMarks, firstArrestedAreaPS, "
							+ "firstAttachedCrime) values" + "(?,?,?,?,?,?,?)");

			ps.setString(1, criminal.getCriminalName());
			ps.setInt(2, criminal.getAge());
			ps.setString(3, criminal.getGender());
			ps.setString(4, criminal.getAddress());
			ps.setString(5, criminal.getIdentificationMarks());
			ps.setString(6, criminal.getArea());
			ps.setString(7, criminal.getCrime());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Recorded the Criminal and his details!";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;

	}

	@Override
	public List<Criminal> displayAllCriminalRecords() throws CriminalException {

		/* displays the list of all crimes in database */

		List<Criminal> list = new ArrayList<>();

		try (Connection connection = DAOUtillity.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from criminalInformation");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Criminal criminal = new Criminal(rs.getInt("criminalId"), rs.getString("criminalName"),
						rs.getInt("criminalAge"), rs.getString("criminalGender"), rs.getString("criminalAddress"),
						rs.getString("identificationMarks"), rs.getString("firstArrestedAreaPS"),
						rs.getString("firstAttachedCrime"));

				list.add(criminal);
			}

		} catch (SQLException e) {
			throw new CriminalException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new CriminalException("No records found!");
		}

		return list;

	}

}
