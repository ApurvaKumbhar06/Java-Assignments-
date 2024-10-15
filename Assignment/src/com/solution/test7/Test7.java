/*Que7.Write a Java program that creates two threads. The first thread should print even
 numbers between 1 and 10, and the second thread should print odd numbers
 between 1 and 10*/


package com.solution.test7;

class OddNumber extends Thread{
	@Override
	public void run() {
		
		for(int i=1; i<=10;i=i+2) {
			
			System.out.println(i);
		}
	}
}

public class Test7 {

	public static void main(String[] args) {
		
		OddNumber t = new OddNumber();
		t.start();
		for(int i=2; i<=10;i=i+2) {
			
			System.out.println(i);
		}
	}
}
