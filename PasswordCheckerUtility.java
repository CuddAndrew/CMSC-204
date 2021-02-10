package main;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class: CMSC204 
 * Instructor: Alexander
 * Description: This program checks passwords to see if they meet the listed parameters.
 * Due: 2/10/2021
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Andrew Cudd  
 * @author Andrew Cudd
*/
public final class PasswordCheckerUtility {
	public PasswordCheckerUtility() {
	}
	/**
	 * 
	 * @param passwordString
	 * @return bool
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 * @throws UnmatchedException
	 * @throws NoSpecialCharacterException
	 */
	public static boolean isValidPassword(String passwordString)
			throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException,
			InvalidSequenceException, UnmatchedException, NoSpecialCharacterException {
		boolean bool = true;
		for (int i = 0; i < passwordString.length(); i++) {
			if (passwordString.length() < 6) {
				throw new LengthException();
			} else if (!Character.isUpperCase(passwordString.charAt(i))) {
				boolean hasUppercase = !passwordString.equals(passwordString.toLowerCase());
				if (!hasUppercase) {
					throw new NoUpperAlphaException(
							"The password must contain at least one uppercase alphabetic character.");
				}
			} else if (!Character.isLowerCase(passwordString.charAt(i))) {
				boolean hasLowercase = !passwordString.equals(passwordString.toUpperCase());
				if (!hasLowercase) {
					throw new NoLowerAlphaException(
							"The password must contain at least one uppercase alphabetic character.");
				}
			}
			else if (!Character.isDigit(passwordString.charAt(i))) {
				for (int j = 0; j <= passwordString.length(); j++) {
					boolean hasDigit = false;
					if (Character.isDigit(passwordString.charAt(j))) {
						hasDigit = true;
					}
					if (hasDigit = false) {
						throw new NoDigitException();
					}
				}

			} else {
				Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
				Matcher matcher = pattern.matcher(passwordString);
				if (!matcher.matches()) {
					throw new NoSpecialCharacterException();
				}

			}

		}
		if (bool) {
			for (int i = 0; i <= passwordString.length() - 2; i++) {
				if (passwordString.charAt(i) == passwordString.charAt(i + 1)
						&& (passwordString.charAt(i) == passwordString.charAt(i + 2))) {
					throw new InvalidSequenceException();
				}
			}
		}
		return bool;
	}
	/**
	 * Checks if a password is weak by being long enough but less than 10
	 * @param passwordString
	 * @return boolean
	 */
	public static boolean isWeakPassword(String passwordString) {
		if (passwordString.length() >= 6 && passwordString.length() <= 9) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Creates an ArrayList of the invalid passwords from a list of passwords.
	 * @param passwords
	 * @return InvalidPasswordsList
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswordsList = new ArrayList<String>();
		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			} catch (LengthException e) {
				invalidPasswordsList.add(passwords.get(i) + " The password must be at least 6 characters long.");
			} catch (NoUpperAlphaException e) {
				invalidPasswordsList.add(
						passwords.get(i) + " The password must contain at least one uppercase alphabetic character.");
			} catch (NoLowerAlphaException e) {
				invalidPasswordsList.add(
						passwords.get(i) + " The password must contain at least one lowercase alphabetic character.");
			} catch (NoDigitException e) {
				invalidPasswordsList.add(passwords.get(i) + " The password must contain at least one digit.");
			} catch (NoSpecialCharacterException e) {
				invalidPasswordsList
						.add(passwords.get(i) + " The password must contain at least one special character.");
			} catch (InvalidSequenceException e) {
				invalidPasswordsList.add(passwords.get(i)
						+ " The password cannot contain more than two of the same character in sequence.");
			}
		}
		return invalidPasswordsList;
	}
}
