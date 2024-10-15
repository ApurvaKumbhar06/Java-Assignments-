/* Que8.Write a Java program that reads a set of integers from the user and stores them in a
 List. The program should then find the second largest and second smallest elements
 in the List.*/

package com.solution.test8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test8 {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many elements you want to add in list ::");
		int n = sc.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i=0; i<n;i++) {
		  
			int x = sc.nextInt();
			arrayList.add(x);
		}
		 Collections.sort(arrayList);
		 
		 int min = arrayList.get(1);
		 int max = arrayList.get(n-2);
	
		 System.out.println("The second smallest element is "+min);
		 System.out.println("The second largest element is "+max);


	}
}
