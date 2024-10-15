/* Que9.Write a Java program that connects to a MySQL database using JDBC. The program
 should read data from a table and display the results in the console.*/

package com.solution.test9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test9 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
	
//		2. Establish the connection with Database.
			String user = "postgres";
			String password = "root123";
			String url = "jdbc:postgresql:///employee";
			
			 connection = DriverManager.getConnection(url,user,password);
			System.out.println("Connection established Succesfully");
			
//		3. Create Statement Object and execute the Query.
			statement = connection.createStatement();
			System.out.println("Statement Object created");
			
			String sqlSelectQuery = "SELECT * FROM information";
			
//		4. Process the ResultSet.
			 resultSet = statement.executeQuery(sqlSelectQuery);
			 System.out.println("Processing the ResultSet");
			 
			System.out.println("ID\tNAME\t\t\tAGE\t\tSalaray\t\tCITY");
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				int salary = resultSet.getInt(4);
				String city = resultSet.getString(5);
				
				System.out.println(id +"\t"+ name+"\t\t" + age+"\t" +salary+"\t"+ city);
				
			}
			
			
//		5. Handle the SQLException if it gets generated.
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
//		6. Close the Connection.
		 finally {
			 try {
				resultSet.close();
				statement.close();
				connection.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		
		
		

	}
	
}





	


