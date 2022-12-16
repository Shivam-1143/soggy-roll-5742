package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;

public class LoginEmployee {
	
	void loginEmployee() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username : ");
		String username = sc.next();
		
		System.out.println("Enter password : ");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
			
		Employee employee;
		 try {
			employee = dao.loginEmployee(username, password);
			System.out.println("Welcome "+employee.getEmpName()+"\n");
			
			employeeTasks(employee.getEmpId());
			
		 } catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}

	}
	
	void employeeTasks(int empId) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n************************\n");
		
		System.out.println("1. View profile");
		System.out.println("2. Update profile");
		System.out.println("3. Change password");
		System.out.println("4. Send request for leave");
		System.out.println("5. Logout");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
		case 1: EmployeeProfile ep = new EmployeeProfile();
				ep.viewProfile(empId);
		break;
		
		case 2: UpdateProfileUsecase up = new UpdateProfileUsecase();
				up.updateEmployeeProfile(empId);
		break;
		
		case 3: ChangedPassword cp = new ChangedPassword();
				cp.changedPassword(empId);
		break;
		
		case 5: System.out.println("Thank you 👋"+"\n");
		
		break;
		
		default: System.out.println("Invalid choice"+"\n");
		  		 employeeTasks(empId);
		break;
		
		}
		
	}
}
