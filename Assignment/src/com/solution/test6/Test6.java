/* Que6.Create a Java program that implements a binary search algorithm. The program
 should accept user input for the target value and search for it in a sorted array. The
 program should return the index of the target value if found or a message if not
 found.*/


package com.solution.test6;

import java.util.Scanner;



public class Test6 {
	
	static int binarySearch(int x[], int n , int data) {
		
		int l = 0, h= n-1;
		
		while(l<h) {
		
        int mid = (l+h)/2;
        
		if(data== x[mid]) {
			
			return mid;
		}
		else if(data<x[mid]) {
			
			h = mid - 1;
		}
		else {
			
			l = mid + 1;
		}
		
		
		
	}
		
		return -1;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of array ::");
		int n = sc.nextInt();
		int x[] = new int[n];
		System.out.println("Enter array elements in sorted order");
		for(int i=0; i<n;i++) {
			
			System.out.println("Enter a array element ::");
			
		    x[i]= sc.nextInt();
		    
			System.out.println(x[i]+"");

		}
		
		boolean flag = true;
		while(flag) {
		System.out.println("Enter a number you want to find ::");
		int data = sc.nextInt();
		
		
        int result = binarySearch(x,n,data);
        
        if(result != -1) {
        
        System.out.println(data+" found at index "+result);
        }
        else {
            System.out.println(data+" is not found in array");

        }
        
		System.out.println("Enter 1 if you want to search another element index else enter 0 ::");
		
		int choice = sc.nextInt();
		if(choice == 0) {
			
			flag = false;
			break;
		}
	}

		
	}
}
