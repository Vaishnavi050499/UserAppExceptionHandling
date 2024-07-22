package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidationServiceImpl implements IValidationService {

	@Override
	public boolean validatePassword(String password) throws TooShortException, TooLongException {
		if (password.length() < 6) {
			throw new TooShortException("Password is too small");
		} else if (password.length() > 15) {
			throw new TooLongException("Password is too long");
		} else
			return true;
	}

	@Override
	public boolean validateUsername(String username) throws NameExistsException {
		String usernames[] = { "Vaishu", "Varun", "Yethusha", "Sai" };
		boolean found = false;
		for (String user : usernames) {
			if (username.equalsIgnoreCase(user)) {
				found = true;
				break;
			}
		}
		if (found) {
			throw new NameExistsException("UserName is already available");
		}
		return true;
	}

}
