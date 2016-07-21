package com.flp.ems.dao;

import java.util.Map;
import java.sql.*;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.mysql.jdbc.Connection;

public class EmployeeDaoImplJDBC implements IemployeeDao {
	private String Employee_Id;
	private String Name;
	private String Kin_Id;
	private String Email_Id;
	private String Phone_No;
	private String DOB;
	private String DOJ;
	private String Address;
	private String names;
	Employee e = new Employee();

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test";
	private String s;
	

	

	@Override
	public void getAllEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Class.forName(driver); Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 Statement stmt = dbConnection.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from Employee");
		    while (rs.next()) {
		    	 s = rs.getString("name"); 
		      
		         System.out.println(s);
		       
		    }
	}

	@Override
	public boolean RemoveEmployee(String name1, Employee e) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		 Class.forName(driver); Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 String query = "delete from Employee where name=?";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.setName(name1));
		preparedStmt.execute();
		 
		 

		return false;
	}

	
	

	public EmployeeDaoImplForJDBC() {
		this.e=e;
		this.names=Name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee SearchEmployee(String name, String email, String kinid) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Employee ModifyEmployee(Map<String, Object> modify, String name, String emailid, String kinid, int ch) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		String query = "update Employee set where name=?";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.getName());
		preparedStmt.execute();
		
		return null;
	}

	@Override
	public void AddEmployee(Employee e, Department dept, Project p, Role r)
			throws ClassNotFoundException, SQLException {

		// TODO Auto-generated method stub

		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		String query = "insert into Employee (name)" + " values (?)";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.getName());
		preparedStmt.execute();

	}

	@Override
	public boolean RemoveEmployee(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
