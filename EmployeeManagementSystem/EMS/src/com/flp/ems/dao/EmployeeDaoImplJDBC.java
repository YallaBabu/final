package com.flp.ems.dao;

import java.util.List;
import java.util.Map;
import java.sql.*;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDaoImplJDBC implements IemployeeDao {
	/*private String Employee_Id;
	private String Name;
	private String Kin_Id;
	private String Email_Id;
	private String Phone_No;
	private String DOB;
	private String DOJ;
	private String Address;
	private String names;*/
	Employee e = new Employee();

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test";
	//private String s;
	
	public void addEmployee(Employee e)
			throws ClassNotFoundException, SQLException {

		// TODO Auto-generated method stub

		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		//String query = "insert into Employee (kinid,empid,empname,mail,phoneNo,address,dob,doj,deptid,projId,roleId) values ('"+e.getKinid()+"','"+e.getEmpid()+"','"+e.getEmpname()+"','"+e.getMail()+"','"+e.getPhonNo()+"','"+e.getAddress()+"','"+e.getDob()+"','"+e.getDoj()+"','"+d.getDeptid()+"','"+p.getProjId()+"','"+r.getRoleId()+"')";
		//Statement Stmt = dbConnection.createStatement();
		String query = "insert into Employee values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt=(PreparedStatement) dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.getKinid());
		preparedStmt.setString(2,e.getEmpid());
		preparedStmt.setString(3, e.getEmpname());
		preparedStmt.setString(4, e.getMail());
		preparedStmt.setString(5, e.getPhoneNo());
		preparedStmt.setString(6, e.getAddress());
		preparedStmt.setString(7,e.getDob());
		preparedStmt.setString(8,e.getDoj());
		preparedStmt.setInt(9,e.getDeptid());
		preparedStmt.setInt(10,e.getProjId());
		preparedStmt.setInt(11,e.getRoleId());
		
		preparedStmt.execute();
		//Stmt.executeUpdate(query);
	}

	public void getAllEmployee() throws ClassNotFoundException,SQLException
	{
		 Class.forName(driver);
		 Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 java.sql.Statement stmt = dbConnection.createStatement();
		    java.sql.ResultSet rs = stmt.executeQuery("select * from Employee");
		    while (rs.next()) 
		    {
		    	    	 
		         System.out.println("empid: "+rs.getString("empid"));
		         System.out.println("kinid: "+rs.getString("kinid"));
		         System.out.println("mail: "+rs.getString("phoneId"));
		         System.out.println("dob: "+rs.getString("dob"));
		         System.out.println("doj: "+rs.getString("doj"));
		         System.out.println("address: "+rs.getString("address"));
		         System.out.println("Deptid: "+rs.getString("Deptid"));
		         System.out.println("projId: "+rs.getString("projId"));
		         System.out.println("roleId: "+rs.getString("roleId"));	
		    }

	
}

	public 
	

	
	/*public boolean RemoveEmployee(String name1, Employee e) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		 Class.forName(driver); Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 String query = "delete from Employee where name=?";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.setName(name1));
		preparedStmt.execute();
		 
		 

		return false;
	}
*/
	
	
/*
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
*/
	/*@Override
	public Employee ModifyEmployee(Map<String, Object> modify, String name, String emailid, String kinid, int ch) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		String query = "update Employee set where name=?";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.getEmpname());
		preparedStmt.execute();
		
		return null;
	}*/

	
	


	
	




	@Override
	public Employee searchEmployee(String kinid, String empName, String mail) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void modifyEmployee(Map empModifiedDetails, Employee emp, int ch) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean removeEmployee(String kinid, String empName, String mail) {
		// TODO Auto-generated method stub
		return false;
	}

/*	@Override
	public boolean RemoveEmployee(String name) {
		// TODO Auto-generated method stub
		return false;
	}*/

}
