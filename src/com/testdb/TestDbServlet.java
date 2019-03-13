package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*; //ADDED MANUALLY
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//SETUP CONNECTION VARIBALES
		String user = "hbstudent";
		String pass = "hbstudent";
		
		String jdbcUr1 = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter out =  response.getWriter();
			
			out.println("Connecting to DB "+jdbcUr1);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUr1, user, pass);
			
			out.println("Success!!!");
			
			myConn.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		//GET CONNECTION
		
		
	}

}
