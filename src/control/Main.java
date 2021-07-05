package control;

import java.util.Scanner;

import service.AdminService;
import service.UserService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int option;
		String name, emailId, password, confirmPassword;
		String response;
		
		AdminService adminService = new AdminService();
		UserService userService = new UserService();
		
		while(true) {
			
			System.out.println("\n1. Admin Signup\n2. Admin Signin\n3. User Signup\n4. User Signin\n5. exit\n");
			option = Integer.parseInt(sc.nextLine());
			
			switch (option) {
				case 1:
					
					System.out.println("Enter Admin name: \n");
					name = sc.nextLine();
					System.out.println("Enter email id: \n");
					emailId = sc.nextLine();
					System.out.println("Enter password: \n");
					password = sc.nextLine();
					System.out.println("Enter confirm password: \n");
					confirmPassword = sc.nextLine();
					response = adminService.signup(name, emailId, password, confirmPassword);
					System.out.println(response + "\n");
					break;
				
				case 2:
					
					System.out.println("Enter Admin email id: \n");
					emailId = sc.nextLine();
					System.out.println("Enter password: \n");
					password = sc.nextLine();
					response = adminService.signin(emailId, password);
					System.out.println(response + "\n");
					break;
					
				case 3:
					
					System.out.println("Enter User name: \n");
					name = sc.nextLine();
					System.out.println("Enter email id: \n");
					emailId = sc.nextLine();
					System.out.println("Enter password: \n");
					password = sc.nextLine();
					System.out.println("Enter confirm password: \n");
					confirmPassword = sc.nextLine();
					response = userService.signup(name, emailId, password, confirmPassword);
					System.out.println(response + "\n");
					break;
					
				case 4:
					
					System.out.println("Enter User email id: \n");
					emailId = sc.nextLine();
					System.out.println("Enter password: \n");
					password = sc.nextLine();
					response = userService.signin(emailId, password);
					System.out.println(response + "\n");
					break;
					
				case 5:
					
					System.exit(0);
					
				default:
					
					System.out.println("\nInvalid input\n");
			}
		}
		
	}

}
