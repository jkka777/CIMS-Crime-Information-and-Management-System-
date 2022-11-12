package com.cims.DAOfiles;

import java.util.List;

import com.cims.exceptions.CriminalException;
import com.cims.structure.Criminal;

public interface CriminalIntr {

	public String recordACriminal(Criminal criminal);

	public List<Criminal> displayAllCriminalRecords() throws CriminalException;

}
