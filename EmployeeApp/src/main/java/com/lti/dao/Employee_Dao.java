package com.lti.dao;
import java.sql.*;
import java.util.Scanner;

import com.lti.entity.Employee;



public class Employee_Dao {
	
	private Connection conn;
	
	public Employee_Dao() throws SQLException {
		this.conn=Database_Conn.getConn();
	}
	public void addEmp(Employee e) throws SQLException {
		Scanner sc= new Scanner(System.in);
		PreparedStatement ps=conn.prepareStatement("insert into Employee_table values(?,?,?)");
		ps.setString(1,sc.next());
		ps.setString(2,sc.next());
		ps.setString(3,sc.next());
		ps.executeUpdate();
		ps.close();
	}
	public Employee getEmpByName(String uname) throws SQLException {
		Employee emp=new Employee();
		PreparedStatement ps=conn.prepareStatement("select * from Employee_Table where username= ?");
		ps.setString(1,uname);
		ResultSet rs=ps.executeQuery();
		if(rs.next()!=false) {
			emp.setUname(rs.getString(1));
			emp.setPass(rs.getString(2));
			emp.setEmail(rs.getString(3));
		}
		ps.close();
		return emp;
	}
	public void deleteEmpByName(String uname) throws DeleteException, SQLException {
		
			PreparedStatement ps=conn.prepareStatement("delete from Employee_Table where username= ?");
			ps.setString(1,uname);
		try{
			int x=ps.executeUpdate();
			if(x==0) {
				throw new DeleteException("No such row ");
			}
			System.out.println("Deleted successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ps.close();
		}
	}
}
