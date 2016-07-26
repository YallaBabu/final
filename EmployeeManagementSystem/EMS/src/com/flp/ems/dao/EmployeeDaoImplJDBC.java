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
	
	 Employee e=new Employee();
	 Department d=new Department();
	 Project p=new Project();
	 Role r=new Role();

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
		preparedStmt.setInt(9,d.getDeptid());
		preparedStmt.setInt(10,p.getProjId());
		preparedStmt.setInt(11,r.getRoleId());
		
		preparedStmt.execute();
		//Stmt.executeUpdate(query);
	}

	public void getAllEmployee() throws ClassNotFoundException,SQLException
	{
		 Class.forName(driver);
		 Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 java.sql.Statement stmt = dbConnection.createStatement();
		    java.sql.ResultSet rs = stmt.executeQuery("select * from Employee inner join Department on Employee.deptid=Department.deptid inner join Role on Employee.roleId=Role.roleId inner join Project on Employee.projId=Project.projId");
		    

		   
		    while (rs.next()) 
		    {
		    	    	 
		         System.out.println("empid: "+rs.getString("empid"));
		         System.out.println("kinid: "+rs.getString("kinid"));
		         System.out.println("empname: "+rs.getString("empname"));
		         System.out.println("mail: "+rs.getString("mail"));
		         System.out.println("phoneNo: "+rs.getString("phoneNo"));
		         System.out.println("address: "+rs.getString("address"));
		         System.out.println("dob: "+rs.getString("dob"));
		         System.out.println("doj: "+rs.getString("doj"));
		         System.out.println("Deptid: "+rs.getInt("Deptid"));
		         System.out.println("DeptName: "+rs.getString("deptName"));
		         System.out.println("projId: "+rs.getInt("projId"));
		         System.out.println ("projName: "+rs.getString("projName"));
		         System.out.println("roleId: "+rs.getInt("roleId"));
		         System.out.println("roleName: "+rs.getString("roleName"));
		    }

	
}

	@Override
	public Employee searchEmployee(String kinid, String empName, String mail) throws ClassNotFoundException, SQLException 
	{
		 Class.forName(driver);
		 Connection dbConnection;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 java.sql.Statement stmt = dbConnection.createStatement();
		
		 java.sql.ResultSet rs=stmt.executeQuery("select * from Employee inner join Department on Employee.deptid=Department.deptid inner join Role on Employee.roleId=Role.roleId inner join Project on Employee.projId=Project.projId where kinid=? or empname=? or mail=?"); 
		 ((PreparedStatement) stmt).setString(1, kinid);
		 ((PreparedStatement) stmt).setString(3, empName);
		 ((PreparedStatement) stmt).setString(4, mail);
		if(rs!=null){
		 e.setEmpid((String)rs.getString("empid"));
		 e.setKinid((String)rs.getString("kinid"));
		 e.setEmpname((String)rs.getString("empname"));
		 e.setMail((String)rs.getString("mail"));
		 e.setPhoneNo((String)rs.getString("phoneNo"));
		 e.setAddress((String)rs.getString("address"));
		 e.setDob((String)rs.getString("dob"));
		 e.setDoj((String)rs.getString("doj"));
		 d.setDeptid((int)rs.getInt("Deptid"));
		 d.setDeptName((String)rs.getString("DeptName"));
		 p.setProjId((int)rs.getInt("projId"));
		 p.setProjName((String)rs.getString("projName"));
		 r.setRoleId((int)rs.getInt("roleId"));
		 r.setRoleName((String)rs.getString("roleName"));
		 
		 return e;
		}
		else
		{
			return null;
		}
	}
	

	@Override
	public Employee modifyEmployee(Map empModifiedDetails, Employee emp, int ch) throws SQLException, ClassNotFoundException {
		 Class.forName(driver);
		 Connection dbConnection=null;
		 dbConnection=(Connection)DriverManager.getConnection(url);
		 PreparedStatement stmt;
	
		
		switch(ch)
		{
		       case 1:emp.setEmpname((String) empModifiedDetails.get("empName"));
		              stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set name=? where kinid="+emp.getKinid());
		              stmt.setString(1,emp.getEmpname());
		              break;
		       case 2:emp.setMail((String) empModifiedDetails.get("email"));
		             stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set mail=? where kinid="+emp.getKinid());
		             stmt.setString(1, emp.getMail());
				     break;
		       case 3:emp.setPhoneNo((String) empModifiedDetails.get("phoneNo"));
		              stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set phoneNo=? where kinid="+emp.getKinid());
		             stmt.setString(1, emp.getPhoneNo());
		              break;
		       case 4:emp.setAddress((String) empModifiedDetails.get("address"));
		       		stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set address=? where kinid="+emp.getKinid());
	                stmt.setString(1, emp.getAddress());
	        		break;
		       	case 5:emp.setDob((String) empModifiedDetails.get("dob"));
		       			stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set dob=? where kinid="+emp.getKinid());
		       			stmt.setString(1,emp.getDob());
						break;
		       	case 6:emp.setDoj((String) empModifiedDetails.get("doj"));
		       			stmt=(PreparedStatement) dbConnection.prepareStatement("update Employee set doj=? where kinid="+emp.getKinid());
		       			stmt.setString(1,emp.getDoj());
				        break;
		}
	
		return emp;
		
	}

	@Override
	public boolean removeEmployee(String kinid, String empName, String mail) 
	{
		
		return false;
	}

} 
	

	
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

	
	


	
	




	


