package com.jsp.exception;

public class EmployeeException extends Exception
{
	private String msg ;
	
	public EmployeeException(String msg)
	{
		this.msg = msg ;
	}
	public String getmsg() 
	{
		return msg;
	}
}