package com.solution.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solution.data.Employee;




/**
 * Servlet implementation class SelectApp
 */
@WebServlet("/select")
public class SelectApp {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Employee select(Integer id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Employee emp = null;
		
		try {
			connection  = DriverManager.getConnection("jdbc:postgresql:///employee", "postgres", "root123");
			
			String sqlSelectQuery = "SELECT ID ,NAME,SALARAY,CITY FROM information WHERE ID = ?";
			
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, id);
				
				resultSet = pstmt.executeQuery();
			}
			
			if(resultSet != null) {
			   emp = new Employee();
				while(resultSet.next()) {
			   emp.setId(resultSet.getInt(1));
			   emp.setName(resultSet.getString(2));
			   emp.setSalary(resultSet.getInt(3));
			   emp.setCity(resultSet.getString(4));
				}
				return emp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
		
	}
}
