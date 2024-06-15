package com.jsp.controller;

import java.util.Scanner;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.EmployeeDto;
import com.jsp.exception.EmployeeException;

public class EmployeeController 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println(" **** Employee Management System **** ");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
//		Creating object for the class EmployeeDto & EmployeeDao
		EmployeeDto dto = new EmployeeDto();
		EmployeeDao dao = new EmployeeDao();
		
		System.out.println("*** Enter Your Choice ***");
		System.out.println();
		System.out.println("1. Add Employee Details");
		System.out.println("2. Get Employee By Id");
		System.out.println("3. Get all The Employees");
		System.out.println("4. Update Details");
		System.out.println("5. Delete Employee");
		System.out.println();
		
//		Taking the input from the user 
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			int adding = 0 ;
			while (adding == 0)
			{
				System.out.println("Enter Employee Id : ");
				dto.setId(sc.nextInt());
				
				System.out.println("Enter Employee Name : ");
				dto.setName(sc.next());
				
				System.out.println("Enter Employee Contact : ");
				dto.setContact(sc.nextDouble());
				
				System.out.println("Enter Employee Designation : ");
				dto.setDesignation(sc.next());
				
				System.out.println("Enter Employee Salary : ");
				dto.setSalary(sc.nextDouble());
				
				try {
				dao.create(dto);
				}catch (EmployeeException e)
				{
					System.out.println(e.getmsg());
				}
				System.out.println();
				System.out.println("Do you want to add more Employee Details Press 0 or Press 1 to Exit");
				adding = sc.nextInt();
				
				if(adding == 1)
				{
					System.out.println(" *** THANK YOU *** ");
				}
				
			}
			break;
			
		case 2:
			System.out.println("Enter Employee Id : ");
			dto.setId(sc.nextInt());
			try {				
				dao.fetchbyId(dto);
			}catch (EmployeeException e) {
				System.out.println(e.getmsg());
			}
			
			break;
			
		case 3:
			dao.fetchAll();
			break;
			
		case 4:
			System.out.println("Enter Employee Id To Be Updated : ");
			dto.setId(sc.nextInt());
			try {				
				dao.update(dto);
			}catch (EmployeeException e) {
				System.out.println(e.getmsg());
			}
			
			break;
			
		case 5:
			System.out.println("Enter Employee Id To Be Deleted : ");
			dto.setId(sc.nextInt());
			try {				
				dao.delete(dto);
			}catch (EmployeeException e) {
				System.out.println(e.getmsg());
			}
			break;

		default:
			System.out.println("Invalid Choice Value");
			break;
		}
		
		
		
	}
}