package service;

import model.Admin;

public class AdminService {
	private Admin admin;
	
	public AdminService() {
		admin = null;
	}
	
	public String signup(String name, String emailId, String password, String comfirmPassword) {
		
		if(admin != null) {
			return "Admin already exists!";
		}
		
		if(!emailId.matches("[A-Za-z0-9]+@[A-Za-z]+\\.[A-za-z]{3}")) {
			return "Invalid email id...";
		}
		
		boolean containsUppercase = password.matches(".*[A-Z]+.*");
		boolean containsLowercase = password.matches(".*[a-z]+.*");
		boolean containsDigit = password.matches(".*[0-9]+.*");
		boolean containsSpecialCharacter = password.matches(".*[!@#$&*./?]+.*");
		boolean isValidPasswordLength = password.length() >= 8;
		
		if(!containsUppercase || !containsLowercase || !containsDigit || !containsSpecialCharacter || !isValidPasswordLength) {
			return "Password doesnot satisfy the requirement...";
		}
		
		if(!password.matches(comfirmPassword)) {
			return "Password and confirm password doesnot match...";
		}
		
		admin = new Admin(name, emailId, password);
		return "Admin Signup Successful!";
		
	}
	
	public String signin(String emailId, String password) {
		
		if(admin == null) {
			return "Admin doesnot exist!";
		}
		if(emailId.equals(admin.getEmailId())) {
			if(password.equals(admin.getPassword())) {
				return "Admin Signin Successful!";
			}
			return "Password doesnot match!"; 
		}
		return "Email doesnot exist!";
		
	}
}
