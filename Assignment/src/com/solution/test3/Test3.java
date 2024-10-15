/* Que3.Write a Java programme that takes an integer from the user and throws an exception
 if it is negative.Demonstrate Exception handling of same program as solution.*/


package com.solution.test3;

import java.util.*;

class NException extends Exception{
	
}


public class Test3 {
	
	public static void main(String [] args){

	Scanner sc =  new Scanner(System.in);
	System.out.println("Enter an integer ::");
	int x = sc.nextInt();
	try {
    if(x<0) {
    	
    	throw new NException();
    }
	}
	catch(Exception e){
		
		System.out.println("Enter a positive integer");
	
	}
	finally {
		System.out.println("program is normally terminated");
	}
	
	}
}
