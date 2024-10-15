package com.solution.test5;

abstract class TicketBooking{
	
	//1.We have to write abstract keyword before abstract method
	//2.In abstract class we can write both abstract as well as normal methods
	public abstract void bookTicket();
	public void cancleTicket() {}
}

interface BookingPayment{
	
	//3.All methods of interface are by default abstract
	//4.The class which implements the interface, have to implement all methods in that interface
	public void payThroughOnline();
	
	public void PayThroughCash();
}

interface PaymentHistory{
	
	public void getPaymentHistory();
}

public class Test5 extends TicketBooking implements BookingPayment, PaymentHistory{
	
	//5.One class can extends only one class 
	//6.one class can implements multiple interfaces

	@Override
	public void getPaymentHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payThroughOnline() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PayThroughCash() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		
	}

}
