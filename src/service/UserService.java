package service;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserService {
	
	private List<User> userList = new ArrayList<>();
	
	public String signup(String name, String emailId, String password, String confirmPassword) {
		
		for(User user: userList) {
			if(emailId.equals(user.getEmailId())) {
				return "Email id already exist!";
			}
		}
		
		if(!emailId.matches("[A-za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{3}")) {
			return "Invallid email";
		}
		
		boolean containsUppercase = password.matches(".*[A-Z]+.*");
		boolean containsLowercase = password.matches(".*[a-z]+.*");
		boolean containsDigit = password.matches(".*[0-9]+.*");
		boolean containsSpecialCharacter = password.matches(".*[!@#$&*./?]+.*");
		boolean isValidPasswordLength = password.length() >= 8;
		
		if(!containsUppercase || !containsLowercase || !containsDigit || !containsSpecialCharacter || !isValidPasswordLength) {
			return "Password doesnot satisfy requirements";
		}
		if(!password.equals((confirmPassword))) {
			return "password and confirmpassword doesnot match";
		}
		
		User newUser = new User(name, emailId, password);
		userList.add(newUser);
		return "User Signup Successful!";
		
	}
	
	public String signin(String emailId, String password) {
		
		for(User user: userList) {
			if(emailId.equals(user.getEmailId())) {
				if(password.equals((user.getPassword()))) {
					return " User Signin successfully";
				}
				return "password doesnot match";
			}
		}
		return "email id doesnot exist";
	}
	
}
