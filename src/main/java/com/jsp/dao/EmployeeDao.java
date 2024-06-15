package com.jsp.dao ;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.jsp.configuration.Configuration;
import com.jsp.dto.EmployeeDto;
import com.jsp.exception.EmployeeException;

public class EmployeeDao 
{
//	Insertion Of Data in the db 
	public void create(EmployeeDto dto) throws Exception
	{
		PreparedStatement ps = Configuration.configure().prepareStatement("INSERT INTO employee values (?,?,?,?,?)");
		
		ps.setInt(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setDouble(3, dto.getContact());
		ps.setString(4, dto.getDesignation());
		ps.setDouble(5, dto.getSalary());
		
		boolean flag = ps.execute();
		
		if (flag == false)
		{
			System.out.println(dto.getId() + " Employee Details Added Successfully ...........");
			
		}else {
			System.out.println(dto.getId() + " Employee Details Not Added ..........");
		}
		
	}
	
//	Fetching of Data From the db by Condition 
	public void fetchbyId(EmployeeDto dto) throws Exception
	{
		PreparedStatement ps = Configuration.configure().prepareStatement("SELECT * FROM employee WHERE employee_id = ?");
		ps.setInt(1, dto.getId());
		
		ResultSet resultset = ps.executeQuery();
		
		if (resultset.next())
		{
			System.out.println("Employee Id : " + resultset.getInt(1) );
			System.out.println("Employee Name : " + resultset.getString(2));
			System.out.println("Employee Contact : " + resultset.getString(3));
			System.out.println("Employee Designation : " + resultset.getString(4));
			System.out.println("Employee Salary : " + resultset.getDouble(5));
		}else {
			throw new EmployeeException(dto.getId()+" Employee Id Not Found !!!!!!");
		}
	}
	
//	Fetching of data from db without any Condition
	public void fetchAll() throws Exception
	{
		PreparedStatement ps = Configuration.configure().prepareStatement("SELECT * FROM employee ");
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next())
		{
			System.out.println("Employee Id : " + resultSet.getInt(1) );
			System.out.println("Employee Name : " + resultSet.getString(2));
			System.out.println("Employee Contact : " + resultSet.getString(3));
			System.out.println("Employee Designation : " + resultSet.getString(4));
			System.out.println("Employee Salary : " + resultSet.getDouble(5));
			System.out.println("-------------------------------------");
		}
	}
	
//	Updation of Record based on Employee Id 
	public void update(EmployeeDto dto) throws Exception
	{
//		Checking the Id inserted by the user is present or not 
		
		PreparedStatement ps = Configuration.configure().prepareStatement("SELECT * FROM employee WHERE employee_id = ?");
		ps.setInt(1, dto.getId());
		
		ResultSet resultset = ps.executeQuery();
		
//		 If any data is present it will go inside this block otherwise go to 'else' block 
		
		if (resultset.next())
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Employee Name : ");
			dto.setName(sc.next());
			
			System.out.println("Enter Employee Contact : ");
			dto.setContact(sc.nextDouble());
			
			System.out.println("Enter Employee Designation : ");
			dto.setDesignation(sc.next());
			
			System.out.println("Enter Employee Salary : ");
			dto.setSalary(sc.nextDouble());
			
			PreparedStatement ps_update = Configuration.configure().prepareStatement("UPDATE employee SET employee_name = ? , employee_contact = ? , employee_desg = ? , employee_sal = ? WHERE employee_id = ? ");
			ps_update.setString(1, dto.getName());
			ps_update.setDouble(2, dto.getContact());
			ps_update.setString(3, dto.getDesignation());
			ps_update.setDouble(4, dto.getSalary());
			ps_update.setInt(5, dto.getId());
			
			int result = ps_update.executeUpdate();
			
			if (result == 1)
			{
				System.out.println(dto.getId() + " Employee Details Updated Successfully !!!!! ");
			}else {
				throw new EmployeeException(dto.getId() + " Employee Details Not Updated .....");
			}
			
		}else {
			throw new EmployeeException(dto.getId() + " Employee ID Not Found !!!!");
		}
	}
	
	
//	Deletion of Record based on Employee Id 
	public void delete(EmployeeDto dto) throws Exception
	{
//		Checking the Id inserted by the user is present or not 
		PreparedStatement ps = Configuration.configure().prepareStatement("SELECT * FROM employee WHERE employee_id = ?");
		ps.setInt(1, dto.getId());
		
		ResultSet resultset = ps.executeQuery();
		
//		If any data is present it will go inside this block otherwise go to 'else' block 
		
		if (resultset.next())
			{
				PreparedStatement ps_del = Configuration.configure().prepareStatement("DELETE FROM employee where employee_id = ?");
				ps_del.setInt(1, dto.getId());
				
				int result = ps_del.executeUpdate();
				
				if(result == 1)
				{
					System.out.println(dto.getId() + " Employee Details Deleted Successfully !!!!! ");
				}else {
					throw new EmployeeException(dto.getId() + " Employee Details Not Deleted .....");
				}
			}else {
				throw new EmployeeException(dto.getId() + " Employee ID Not Found !!!!");
			}
		}

}