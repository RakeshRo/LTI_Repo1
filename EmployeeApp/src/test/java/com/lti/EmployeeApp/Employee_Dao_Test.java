package com.lti.EmployeeApp;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.lti.dao.Database_Conn;
import com.lti.dao.DeleteException;
import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;
public class Employee_Dao_Test {
	private static Employee_Dao d;	
	static Scanner sc= new Scanner(System.in);
	@Test
    public void getConnectionTest() throws SQLException
    {
        Connection conn = Database_Conn.getConn();
        assertNotNull(conn,"connection successful");
    }
	public static void insert() throws SQLException {
		Employee emp=new Employee();
		d.addEmp(emp); 
		System.out.println("Inserted");
	}
	@Test 
	public void Emptest() throws SQLException {
		System.out.println("Insert into db Y?N?");
		char s=sc.next().charAt(0);
		if(s=='y'){
			Employee_Dao_Test.insert();
		}
		//Employee_Dao d=new Employee_Dao();
		System.out.println("Enter the name");
		Employee edb=d.getEmpByName(sc.next());
		assertEquals("ABC",edb.getPass(),"Password Checked Succefully");	
	}
	@Test
	public void deleteTest()throws SQLException, DeleteException{
		System.out.println("Enter the name");
		String s=sc.next();
		d.deleteEmpByName(s);
		Employee ed=d.getEmpByName(s);
		assertNull(ed.getUname());
	}
	@Before
	public void getDao() throws SQLException {
		d=new Employee_Dao();
		
	}
}	
