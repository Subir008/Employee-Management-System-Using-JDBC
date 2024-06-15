# Employee Management System Using JDBC
This is a Employee Management System made using JDBC

----

##### 1st Step 
Create a Maven Project

** How to create Maven Project **

* Go to file 
* New 
* Select Maven Project 
* Check the Simple project 
* Give file location 
* Click on Next 
* Give GroupId which is package name 
* Give ArtifactId which is Project Name 
* Finish

*If got any error in the Maven Project*

* Right click on the Maven Project 
* Click on Maven 
* Update 
* Check the checkbox of force update
* Next

##### 2nd Step

Add the Persistence code in the pom.xml file within dependencies tag.

** How to add the persistence code **

* Search [Maven Repository](https://mvnrepository.com/) 
* Then search for Mysql Connector and click on the result with high usages 
* Click on the version with high usage 
* Copy the dependency codes 

##### 3rd Step

Create packages for DTO(Data Transfer Object), DAO (Data Access Object), Controller , and other packages like Exception,Configuration.

##### Final Step

Start writing the codes for different packages.

* **Configuration Package**

This package will contain the codes for connection with the database will be present separately so that we don't have to write the same code multiple times . <br>
The code will be written in a separate static method so that directly have access to it.

	public static Connection configure() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","****");
		
		return connection;
	}
	
* **Exception Package**

This package will contain the codes for User Defined Exception.
	
	private String msg ;
	
	public EmployeeException(String msg)
	{
		this.msg = msg ;
	}
	public String getmsg() 
	{
		return msg;
	}
	
* **DTO Package**

This package will contain the variables that will store the user given data, it will be store in private and we will get access to it through the use of **getter()** and **setter()** method and then we have to create **tostring()** of it.
 
* **DAO Package** 

This package will contain all the logical and main condition for the program.

* ** Controller Package**

This package will control the total program, according to the user choice it will invoke the Dao package and run the program.
