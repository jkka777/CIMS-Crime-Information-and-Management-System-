package com.cims.DAOfiles;

import com.cims.exceptions.UserException;
import com.cims.structure.Crime;
import com.cims.structure.User;

public interface UserIntr {

	public String reportCrime(Crime crime);

	public String registerUser(User user);

	public User loginUser(String email, String password) throws UserException;

	public String getStatusOfCase(String date, String location, String crime);
}
