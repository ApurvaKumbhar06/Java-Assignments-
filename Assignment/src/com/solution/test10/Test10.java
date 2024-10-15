package com.solution.test10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

interface CurdOprations{
	
	public void select();
	public void insert();
	public void update();
	public void delete();
}

public class Test10 implements CurdOprations {
	
	static String user = "postgres";
	static String password = "root123";
	static String url = "jdbc:postgresql:///employee";
	static Connection connection = null;
	static Scanner sc = new Scanner(System.in);

	

	public static void main(String[] args) {
		
		Test10 t = new Test10();
		
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection established Succesfully");
		
		System.out.println("*****************************************");
		System.out.println("Select your option :\n1.select\n2.insert\n3.update\n4.delete");
		while (true) {
            System.out.print("\nEnter your option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    t.select();
                    break;
                case 2:
                    t.insert();
                    break;
                case 3:
                    t.update();
                    break;
                case 4:
                    t.delete();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

		
	}
    public void select() {
        Statement statement= null;

		ResultSet resultSet = null;
		
		try {
	
//		2. Establish the connection with Database.
			
			
//		3. Create Statement Object and execute the Query.
			statement = connection.createStatement();
			System.out.println("Statement Object created");
			
			String sqlSelectQuery = "SELECT * FROM information";
			
//		4. Process the ResultSet.
			 resultSet = statement.executeQuery(sqlSelectQuery);
			 System.out.println("Processing the ResultSet");
			 
			System.out.println("ID\tNAME\t\t\tAGE\t\tSalaray\t\tCITY");
			while(resultSet.next()) {
				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				int salary = resultSet.getInt(4);
				String city = resultSet.getString(5);
				
				System.out.println(id1 +"\t"+ name+"\t\t" + age+"\t" +salary+"\t"+ city);
				
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
	
		
	

	@Override
	public void insert() {
		
		    PreparedStatement pstmt = null;
	        
			String sqlInsertQuery ="INSERT INTO information(id,name,age,salaray,city) VALUES (?,?,?,?,?)";

	        try {
				
				
				pstmt = connection.prepareStatement(sqlInsertQuery);
				System.out.print("ID :: ");
				int id = sc.nextInt();
				
				System.out.print("Name :: ");
				String name = sc.next();
						
				System.out.print("Age :: ");
				int age = sc.nextInt();
				
				System.out.println("Salary :: ");
				int salary =sc.nextInt();
				
				System.out.print("City :: ");
				String city = sc.next();
				
				 pstmt.setInt(1, id);
				 pstmt.setString(2, name);
				 pstmt.setInt(3, age);
				 pstmt.setInt(4,salary);
				 pstmt.setString(5, city);
				
				
				//System.out.println(sqlInsertQuery);
	      	int rowCount = pstmt.executeUpdate();
				
				if(rowCount != 0) {
					System.out.println("The no of rows Affected :: "+rowCount);
				}
				else {
					System.out.println("Recound insertion failed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
				finally {
					try {
						pstmt.close();
						connection.close();
						System.out.println("Connection closed");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		       
			}

	@Override
	public void update() {
		
		PreparedStatement pstmt = null;
	
		
		String sqlUpdateQuery = "Update information set name =?, age =?, salaray = ?, city =?  Where id = ?";

		
		
		try {
			
			
			pstmt = connection.prepareStatement(sqlUpdateQuery);

			System.out.print("Enter Id which you want to update :: ");
			int id1 = sc.nextInt();
			
			System.out.print("Name :: ");
			String name = sc.next();
					
			System.out.print("Age :: ");
			int age = sc.nextInt();
			
			System.out.println("Salary :: ");
			int salary =sc.nextInt();
			
			System.out.print("City :: ");
			String city = sc.next();
			
			pstmt.setInt(1, id1);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setInt(4,salary);
			pstmt.setString(5, city);
			
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount != 0) {
				System.out.println("The no of rows Affected :: "+rowCount);
			}
			else {
				System.out.println("Recound updation failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
			finally {
				try {
					pstmt.close();
					connection.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	       
		}

	@Override
	public void delete() {
		
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		
		try {
			
			
			String sqlDeleteQuery = "Delete from information Where id = ?";
			System.out.print("Enter Id which you want to delete :: ");
			int id1 = sc.nextInt();
			pstmt.setInt(1, id1);
			
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1,id1);
				 rowCount = pstmt.executeUpdate();
			}
			
			if(rowCount != 0) {
				System.out.println("The no of rows Affected :: "+rowCount);
			}
			else {
				System.out.println("Recound updation failed");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
			finally {
				try {
					pstmt.close();
					connection.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	       
		}
}

