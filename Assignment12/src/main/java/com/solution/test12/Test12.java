/*Que 12.Write a Java servlet that reads the data from a MySQL database table and displays it
 in an HTML table on the web page. The servlet should use JDBC to connect to the
 database and retrieve the data*/



package com.solution.test12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solution.dao.SelectApp;
import com.solution.data.Employee;

/**
 * Servlet implementation class Test12
 */
@WebServlet("/test12")
public class Test12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("SearchServlet File is loading");
	}
   
    public Test12() {
        super();
        System.out.println("SerachServlet is Instantiated");
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   String id1 = request.getParameter("id");
	   
	   Integer id = Integer.parseInt(id1);
	   
	   SelectApp sapp = new SelectApp();
	  Employee emp = sapp.select(id);
	  
	  PrintWriter out = response.getWriter();
	  out.println("<html><head><title>Result</title></head><body>");
	  out.println("<center>");
	  out.println("<h1>Employee Data</h1>");
	  out.println("<table border='1'>");
	  out.println("<tr> <th>ID</th>  <td>"+emp.getId()+"</td> </tr>");
	  out.println("<tr> <th>Name</th>  <td>"+emp.getName()+"</td> </tr>");
	  out.println("<tr> <th>Salary</th>  <td>"+emp.getSalary()+"</td> </tr>");
	  out.println("<tr> <th>City</th>  <td>"+emp.getCity()+"</td> </tr>");
	  out.println("</table>");
	  out.println("</br>");
	  out.println("<button> <a href='index.html'> home page</a></button> ");
	  out.println("</center></body></html>");
	  
	   out.close();
	   
	 
	
	}
}
