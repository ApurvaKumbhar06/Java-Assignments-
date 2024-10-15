/* Que 1.Write a Java program that uses polymorphism by defining an interface called Shape
 with methods to calculate the area and perimeter of a shape. Then create classes
 that implement the Shape interface for different types of shapes, such as circles and
 triangles.*/

package com.solution.test1;

import java.util.Scanner;

interface IShape{
	
	public void calArea();
	public void calPerimeter();
	
}

class Circle implements IShape{
	
	double pie = 3.14;
	
	double radius;
	
	 Circle(double r) {
		
		 this.radius = r;
		
		
	}

	@Override
	public void calArea() {
		
	 	double area = 2*pie*radius;
		
		System.out.println("Area of circle is"+area);
		
		
	}

	@Override
	public void calPerimeter() {
		
		double perimeter = 2*pie*radius;
		
		System.out.println("Perimeter of circle is"+perimeter);
		
		
	}
	
	
	
}

class Triangle implements IShape{
	
	double sideA , sideB, sideC;
	
	Triangle( double sideA, double sideB, double sideC) {
	
		 this.sideA = sideA;
		 this.sideB = sideB;
		 this.sideC = sideC;
		
   }

	@Override
	public void calArea() {
		
		double s = (sideA + sideB + sideC) / 2; // semi-perimeter
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        
        System.out.println("Area of  Triangle is "+area);
        
        
		
		
	}

	@Override
	public void calPerimeter() {
		
		double perimeter = (sideA + sideB + sideC) ;
		
		System.out.println("Perimeter of Triangle is"+perimeter);
		
		
	}
	
	
	
}
public class Test1 {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("******Circle*******");
		System.out.println("");
		System.out.println("Enter radius :: ");
		
		double r = sc.nextDouble();
		
		Circle c = new Circle(r);
		c.calArea();
		c.calPerimeter();
		
		System.out.println("******Triangle*******");
		System.out.println("");
		
		System.out.println("Enter length of Side A :");
		Double SideA = sc.nextDouble();
		System.out.println("Enter length of Side B :");
		Double SideB = sc.nextDouble();

		
		System.out.println("Enter length of Side C :");
		Double SideC = sc.nextDouble();

		
		Triangle t = new Triangle(SideA, SideB, SideC);
		c.calArea();
		c.calPerimeter();


		
		
	}
}
