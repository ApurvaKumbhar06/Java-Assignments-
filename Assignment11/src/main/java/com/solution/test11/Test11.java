/*Que11.Create a Java servlet that reads the name of the user from a form and displays a
 welcome message on the web page. The servlet should use the GET method to read
 the input data from the user.*/


package com.solution.test11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Test11
 */
@WebServlet(urlPatterns="/test11", loadOnStartup=10)
public class Test11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static {
		System.out.println("InsertServlet File is loading");
	}
   
    public Test11() {
        super();
        System.out.println("InsertServlet is Instantiated");
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		 String name = request.getParameter("name");
	  
	  
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>Result</title></head><body>");
	    out.println("<center>");
	    out.println("<h1>Welcome</h1>");
	    out.println("</center></body></html>");
	  
	    out.close();
	   
	 
	}

}
