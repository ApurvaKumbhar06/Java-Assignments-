package com.solution.test4;

import java.util.Scanner;

interface BankAccount{
	
	public void checkBalance();
    public void deposit(int amount);
	public void withdraw(int amount);
}
 
class BankAccountImpl implements BankAccount{
	int balance;

	@Override
	public void checkBalance() {
		
		System.out.println("your account balance is: "+balance);
	}

	@Override
	public void deposit(int amount) {
		
	   balance = balance + amount;
	   
	   System.out.println("Amount deposited sucessfully");

	}

	@Override
	public void withdraw(int amount) {
		
		if(amount > balance) {
			System.out.println("your balance is in sufficient");
		}
		else {
		balance = balance - amount;
		   
		System.out.println("Amount withdrawn sucessfully");
        }
	}
	
}

public class Test4 {
	public static void main(String[] args) {
		BankAccountImpl  b = new BankAccountImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
		System.out.println("*********Welcome*********");
		System.out.println("");
		System.out.println("please select your option\n1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit");
		System.out.println("Enter your option :: ");
		int x = sc.nextInt();
		
		if(x==1) {
			
			b.checkBalance();
		}
		else if(x==2) {
			System.out.println("Enter your amount: ");
			int amount = sc.nextInt();
			b.deposit(amount);
		}
		else if(x==3) {
			System.out.println("Enter your amount: ");
			int amount = sc.nextInt();
			b.withdraw(amount);
		}
		else if(x==4) {
			
			flag = false;
			System.out.println("Thank you for using this application!");
			break;
		}
		else{
			System.out.println("your option is invalid");
		}
	}
  }
}



