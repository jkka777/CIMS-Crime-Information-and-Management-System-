package com.cims.userinterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfDouble;

import com.cims.DAOfiles.CrimeIntr;
import com.cims.DAOfiles.CrimeIntrImpl;
import com.cims.DAOfiles.CriminalIntr;
import com.cims.DAOfiles.CriminalIntrImpl;
import com.cims.DAOfiles.UserIntr;
import com.cims.DAOfiles.UserIntrImpl;
import com.cims.exceptions.CrimeException;
import com.cims.exceptions.CriminalException;
import com.cims.exceptions.UserException;
import com.cims.structure.Crime;
import com.cims.structure.Criminal;
import com.cims.structure.User;

public class MainUserInterface {

	public static void main(String[] args) {

		System.out.println(
				"                                                                  _____ _____ __  __  _____ \r\n"
						+ "                                                                 / ____|_   _|  \\/  |/ ____|\r\n"
						+ "                                                                | |      | | | \\  / | (___  \r\n"
						+ "                                                                | |      | | | |\\/| |\\___ \\ \r\n"
						+ "                                                                | |____ _| |_| |  | |____) |\r\n"
						+ "                                                                 \\_____|_____|_|  |_|_____/ \r\n"
						+ "                                                                                            \r\n"
						+ "                                                                                           ");

		System.out.println(
				"                            _____      _                     _____        __                           _   _                         \r\n"
						+ "                           / ____|    (_)                   |_   _|      / _|                         | | (_)                  ___   \r\n"
						+ "                          | |     _ __ _ _ __ ___   ___       | |  _ __ | |_ ___  _ __ _ __ ___   __ _| |_ _  ___  _ __       ( _ )  \r\n"
						+ "                          | |    | '__| | '_ ` _ \\ / _ \\      | | | '_ \\|  _/ _ \\| '__| '_ ` _ \\ / _` | __| |/ _ \\| '_ \\      / _ \\/\\\r\n"
						+ "                          | |____| |  | | | | | | |  __/     _| |_| | | | || (_) | |  | | | | | | (_| | |_| | (_) | | | |    | (_>  <\r\n"
						+ "                           \\_____|_|  |_|_| |_| |_|\\___|    |_____|_| |_|_| \\___/|_|  |_| |_| |_|\\__,_|\\__|_|\\___/|_| |_|     \\___/\\/\r\n"
						+ "                                                                                                                                     \r\n"
						+ "                                                                                                                                     ");

		System.out.println(
				"                           __  __                                                   _         _____           _                 \r\n"
						+ "                          |  \\/  |                                                 | |       / ____|         | |                \r\n"
						+ "                          | \\  / | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_     | (___  _   _ ___| |_ ___ _ __ ___  \r\n"
						+ "                          | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|     \\___ \\| | | / __| __/ _ \\ '_ ` _ \\ \r\n"
						+ "                          | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_      ____) | |_| \\__ \\ ||  __/ | | | | |\r\n"
						+ "                          |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__|    |_____/ \\__, |___/\\__\\___|_| |_| |_|\r\n"
						+ "                                                     __/ |                                           __/ |                      \r\n"
						+ "                                                    |___/                                           |___/                       ");

		System.out.println(
				"                             _  _                                         _                      _                \r\n"
						+ "                           _| || |_                                      | |                    (_)               \r\n"
						+ "                          |_  __  _|  ___  __ _ _   _     _ __   ___     | |_ ___       ___ _ __ _ _ __ ___   ___ \r\n"
						+ "                           _| || |_  / __|/ _` | | | |   | '_ \\ / _ \\    | __/ _ \\     / __| '__| | '_ ` _ \\ / _ \\\r\n"
						+ "                          |_  __  _| \\__ \\ (_| | |_| |   | | | | (_) |   | || (_) |   | (__| |  | | | | | | |  __/\r\n"
						+ "                            |_||_|   |___/\\__,_|\\__, |   |_| |_|\\___/     \\__\\___/     \\___|_|  |_|_| |_| |_|\\___|\r\n"
						+ "                                                 __/ |                                                            \r\n"
						+ "                                                |___/                                                             ");

		System.out.println("     _             _              _    _            _  ___    _                \r\n"
				+ "  __| |_____ _____| |___ _ __  __| |  | |__ _  _   | |/ (_)__| |_  ___ _ _ ___ \r\n"
				+ " / _` / -_) V / -_) / _ \\ '_ \\/ _` |  | '_ \\ || |  | ' <| (_-< ' \\/ _ \\ '_/ -_)\r\n"
				+ " \\__,_\\___|\\_/\\___|_\\___/ .__/\\__,_|  |_.__/\\_, |  |_|\\_\\_/__/_||_\\___/_| \\___|\r\n"
				+ "                        |_|                 |__/                               ");

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("WELCOME TO CIMS" + '\n');
			System.out.println("Select user (please use only number to enter)" + '\n');
			System.out.println("1. Admin");
			System.out.println("2. Citizen");

			int user_choice = scanner.nextInt();

			switch (user_choice) {
			case 1:
				System.out.println('\n' + "----CIMS----" + '\n');
				System.out.println("Welcome Admin!" + '\n');
				System.out.println("Login to Continue");
				System.out.println("1. Login");

				int admin_choice = scanner.nextInt();

				if (admin_choice == 1) {

					String adminEmailString = "admin";
					String adminPassString = "admin";

					System.out.println("Please enter your official username");
					String adminEmail = scanner.next();

					System.out.println("Enter your password");
					String adminPass = scanner.next();

					if (adminEmailString.equals(adminEmail) && adminPassString.equals(adminPass)) {
						System.out.println("----CIMS----" + '\n');
						System.out.println(
								"Welcome " + adminEmail.substring(0, 5) + " ! You have logged in successfully!" + '\n');

						System.out.println("Now choose one option (please use only number to enter)" + '\n');

						System.out.println("1. Record a crime");
						System.out.println("2. View Police Station List");
						System.out.println("3. Search a Crime record");
						System.out.println("4. Search a Criminal and his records in Crime database");
						System.out.println("5. View all pending cases");
						System.out.println("6. View all pending cases in area wise police station");
						System.out.println("7. Get the number of pending cases in area wise police station");
						System.out.println("8. Get the number of solved cases in area wise police station");
						System.out.println("9. View number of recorded crimes in an area Police station");
						System.out.println("10. View number of cases recorded in a given Date");
						System.out.println("11. Display all cases");
						System.out.println(
								"12. Change the status of a case from 'pending' to 'solved'(use small cases only)");
						System.out.println("13. Record a Criminal in Criminal database");
						System.out.println("14. Display all criminal records available");

						int aChoice = scanner.nextInt();

						switch (aChoice) {
						case 1:

							System.out.println("Enter the date when crime happend in YYYY-MM-DD format");
							String date = scanner.next();

							System.out.println("Enter the place of crime");
							String place = scanner.next();

							System.out.println("Enter the type of crime (robbery, homicide, abduction etc,.)");
							String type = scanner.next();

							System.out.println("Enter the victim name if there are multiple enter the "
									+ "names with (,) separator without spaces");
							Scanner s = new Scanner(System.in);
							String victim = s.nextLine();

							System.out.println("Enter the details of crime");
							String details = s.nextLine();

							System.out.println("Enter the suspect name, if name is not known type 'un-known'!");
							String suspect = scanner.next();

							System.out.println("Enter the crime status 'pending' or 'solved'");
							String status = scanner.next();

							System.out.println("Enter the nearby police station name");
							String psName = scanner.next();

							CrimeIntr cint = new CrimeIntrImpl();

							Crime crime = new Crime(date, place, type, victim, details, suspect, status, psName);

							System.out.println('\n' + cint.recordAcrime(crime));

							break;

						case 2:

							CrimeIntr cintrA_2 = new CrimeIntrImpl();
							try {
								List Stationlist = cintrA_2.viewPoliceStation();

								System.out.println('\n' + "List of Police stations" + '\n');

								for (int i = 0; i < Stationlist.size(); i++) {
									System.out.println(Stationlist.get(i));
								}

							} catch (CrimeException e) {
								System.out.println(e.getMessage());
							}

							break;

						case 3:

							System.out.println(
									"Enter the crime category (robbery, abduction etc,.) you wish you to see the records of");
							String crimeCat = scanner.next();

							CrimeIntr cintrA_3 = new CrimeIntrImpl();

							try {
								List<Crime> crimeCatList = cintrA_3.listOutRecordsOfACrimeCategory(crimeCat);

								for (int i = 0; i < crimeCatList.size(); i++)
									System.out.println(crimeCatList.get(i).toStringCrimeCategory());

							} catch (CrimeException e) {
								System.out.println(e.getMessage());
							}

							break;

						case 4:

							System.out.println("Enter the crminal name you wish you to see the record of");
							String cName = scanner.next();

							CrimeIntr cintrA_4 = new CrimeIntrImpl();

							try {
								List<Crime> criminalRecord = cintrA_4.displayAllCrimesOfCriminal(cName);

								for (int i = 0; i < criminalRecord.size(); i++)
									System.out.println(criminalRecord.get(i).toStringCriminalInCrimeRecord());

							} catch (CrimeException e) {
								System.out.println(e.getMessage());
							}

							break;

						case 5:

							CrimeIntr cintrA_5 = new CrimeIntrImpl();
							try {
								List<Crime> list = cintrA_5.displayPendingCrimes();
								list.forEach(i -> System.out.println(i));

							} catch (CrimeException e) {
								System.out.println(e.getMessage());
							}

							break;

						case 6:

							System.out.println("Enter the Police station name you wish you to see the record of");
							String psname = scanner.next();

							CrimeIntr cintrA_6 = new CrimeIntrImpl();

							try {
								List<Crime> psRecord = cintrA_6.displayAllCrimesUnderAreaPolceStation(psname);

								psRecord.forEach(i -> System.out.println(i));

							} catch (CrimeException e) {
								System.out.println(e.getMessage());
							}

							break;

						case 7:

							System.out.println(
									'\n' + "Enter the Police station name to get the number of pending cases" + '\n');

							String pendingCasePSName = scanner.next();

							CrimeIntr cintrA_7 = new CrimeIntrImpl();

							try {
								System.out.println(
										'\n' + "Total cases pending in " + pendingCasePSName + " Police station are - "
												+ cintrA_7.numberOfPendingCasesInAreaPS(pendingCasePSName) + "!");
							} catch (CrimeException e1) {

								System.out.println(e1.getMessage());
							}

							break;

						case 8:

							System.out.println(
									'\n' + "Enter the Police station name to get the number of solved cases" + '\n');

							String solvedCasePSName = scanner.next();

							CrimeIntr cintrA_8 = new CrimeIntrImpl();

							try {
								System.out.println(
										'\n' + "Total cases solved in " + solvedCasePSName + " Police station are - "
												+ cintrA_8.numberOfSolvedCasesInAreaPS(solvedCasePSName) + "!");
							} catch (CrimeException e1) {

								System.out.println(e1.getMessage());
							}

							break;

						case 9:

							System.out.println("Enter the Police station to see the total number of crimes recorded");

							String psNameCase9 = scanner.next();

							CrimeIntr cIntrA_9 = new CrimeIntrImpl();

							try {
								System.out.println(
										'\n' + "Total number of cases in " + psNameCase9 + " Police station are - "
												+ cIntrA_9.numberOfCrimesInAreaPoliceStation(psNameCase9) + "!");
							} catch (CrimeException e1) {

								System.out.println(e1.getMessage());
							}

							break;

						case 10:

							System.out.println("Enter the start date in YYYY-MM-DD (2000-01-01) format "
									+ "to view the number of " + "cases recorded in a given time");

							String date1 = scanner.next();

							System.out.println("Enter the end date in YYYY-MM-DD (2000-12-31) format "
									+ "to view the number of " + "cases recorded in a given time");

							String date2 = scanner.next();

							CrimeIntr cIntrA_10 = new CrimeIntrImpl();

							try {
								System.out.println('\n' + "Total number of cases between " + date1 + " and " + date2
										+ " are - " + cIntrA_10.numberOfCrimesInAGivenTimeFrame(date1, date2) + "!");
							} catch (CrimeException e1) {

								System.out.println(e1.getMessage());
							}

							break;

						case 11:

							CrimeIntr cintrA_11 = new CrimeIntrImpl();
							try {
								List<Crime> list = cintrA_11.displayAllCrimes();
								list.forEach(i -> System.out.println(i));

							} catch (CrimeException e) {
								System.out.println(e.getMessage());
							}

							break;

						case 12:

							CrimeIntr cintrA_12 = new CrimeIntrImpl();

							System.out.println("Enter the date when crime happend in YYYY-MM-DD format");
							String statuschangeDate1 = scanner.next();

							System.out.println("Enter the place");
							String statusChagnePlace1 = scanner.next();

							System.out.println("Enter the crime category (robbery, abduction, homicide etc,.)");
							String statusChagneCrime1 = scanner.next();

							String statusChangeResult = cintrA_12.changeStatusOfCrimePendingToSolved(statuschangeDate1,
									statusChagnePlace1, statusChagneCrime1);

							System.out.println('\n' + statusChangeResult);

							break;

						case 13:

							System.out.println("Enter the criminal name");
							String criminalName = scanner.next();

							System.out.println("Enter age of criminal");
							;
							int criminalAge = scanner.nextInt();

							System.out.println("Enter the gender of criminal");
							String criminalGender = scanner.next();

							System.out.println("Enter the address of criminal");
							String criminalAddress = scanner.next();

							Scanner sc = new Scanner(System.in);

							System.out.println("Enter the identification marks");
							String criminalIdentification = sc.nextLine();

							System.out.println("Enter the first attached Police station");
							String criminalPoliceStation = scanner.next();

							System.out.println("Enter the first attached crime category");
							String criminalCrime = scanner.next();

							CriminalIntr criminalIntr = new CriminalIntrImpl();

							Criminal criminal = new Criminal(criminalName, criminalAge, criminalGender, criminalAddress,
									criminalIdentification, criminalPoliceStation, criminalCrime);

							System.out.println('\n' + criminalIntr.recordACriminal(criminal));

							break;

						case 14:

							CriminalIntr criminalIntr2 = new CriminalIntrImpl();
							try {
								List<Criminal> list = criminalIntr2.displayAllCriminalRecords();
								list.forEach(i -> System.out.println(i));

							} catch (CriminalException e) {
								System.out.println(e.getMessage());
							}

							break;

						default:
							System.out.println("Invalid selection of choice!");
							break;
						}

					} else {
						System.out.println("Wrong password or invalid email entered. Please try again...");
					}
				}

				else {

					System.out.println("Invalid Selection! Please try again...");

				}

				break;
			case 2:
				System.out.println("Select an option (please use only number to enter)" + '\n');
				System.out.println("1. Register");
				System.out.println("2. Login");

				int uChoice = scanner.nextInt();

				switch (uChoice) {
				case 1:
					System.out.println("Please enter your email Id");
					String userEmail = scanner.next();

					System.out.println("Enter password");
					String userPass = scanner.next();

					System.out.println("Enter city");
					String userCity = scanner.next();

					UserIntr ui = new UserIntrImpl();

					User user = new User(userEmail, userPass, userCity);

					String message = ui.registerUser(user);

					System.out.println(message + '\n');

					break;

				case 2:

					System.out.println("Enter emailID");
					String username = scanner.next();

					System.out.println("Enter Password :");
					String password = scanner.next();

					UserIntr uitIntr = new UserIntrImpl();

					try {
						User userValidation = uitIntr.loginUser(username, password);

						System.out.println("Welcome " + userValidation.getEmail());

						System.out.println("Choose an option" + '\n');

						System.out.println("1. Report the crime");
						System.out.println("2. Check the status of your report");

						int c_choice = scanner.nextInt();

						switch (c_choice) {
						case 1:

							System.out.println("Enter the date when crime happend in YYYY-MM-DD format");
							String date = scanner.next();

							System.out.println("Enter the crime location");
							String place = scanner.next();

							System.out.println("Enter the category of crime (robbery, homicide etc,.)");
							String type = scanner.next();

							System.out.println("Enter the victim name if there are multiple enter the "
									+ "names with (,) separator without spaces");

							Scanner s = new Scanner(System.in);
							String victim = s.nextLine();

							System.out.println("Enter the details of crime");
							String details = s.nextLine();

							System.out.println("Enter the suspect name if known else write 'un-known'");
							String suspect = scanner.next();

							System.out.println("Enter the nearby Police station");
							String psName = scanner.next();

							UserIntr cint = new UserIntrImpl();

							Crime crime = new Crime(date, place, type, victim, details, suspect, psName);

							String res = cint.reportCrime(crime);

							System.out.println('\n' + res);

							break;

						case 2:

							System.out.println("Enter the date when crime happend in YYYY-MM-DD format");
							String dateU = scanner.next();

							System.out.println("Enter the place");
							String placeU = scanner.next();

							System.out.println("Enter the type of crime");
							String crimeU = scanner.next();

							UserIntr userInnrU_2 = new UserIntrImpl();

							String reportStatus = userInnrU_2.getStatusOfCase(dateU, placeU, crimeU);

							System.out.println('\n' + reportStatus);

							break;
						default:
							System.out.println("Invalid choice! Please try again..");
						}

					} catch (UserException e) {

						System.out.println(e.getMessage());
					}

					break;

				default:
					System.out.println("Invalid selection please try again!");
				}
				break;

			default:
				System.out.println("Invalid Selection! Please try again...");
			}

			scanner.close();

		} catch (InputMismatchException e) {

			System.out.println("Input did not match. Please try again with vaild input!");
		}
	}
}
