package com.lti.EmployeeApp;

import java.sql.SQLException;

import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class App {

	public static void main(String[] args) throws SQLException {
		Employee_Dao ed=new Employee_Dao();
		Employee e=new Employee();
		e.setUname("LMN");
		e.setPass("lmn");
		e.setEmail("lmn@gmail.com");
		ed.addEmp(e);
		System.out.println("Employee inserted succesfully");
	}

}
