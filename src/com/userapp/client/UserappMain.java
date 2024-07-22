package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.IValidationService;
import com.userapp.service.ValidationServiceImpl;

public class UserappMain {

	public static void main(String[] args) {
		IValidationService service = new ValidationServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the username");
		String user = sc.nextLine();
		try {
			service.validateUsername(user);
			System.out.println("Please Enter the password:");
			String password = sc.nextLine();

			try {
				service.validatePassword(password);
			} catch (TooShortException | TooLongException e) {
				System.out.println("Password is not valid" + e.getMessage());
			}

		} catch (NameExistsException e) {
			System.out.println("Username exists:" + e.getMessage());
		}

	}

}
