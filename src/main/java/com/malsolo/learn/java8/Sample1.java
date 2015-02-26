package com.malsolo.learn.java8;

/**
 * Interfaces
 */
public class Sample1 {
	
	public void use() {
		SeaPlane seaPlane = new SeaPlane();
		seaPlane.land();
	}
	
	public static void main(String[] args) {
		new Sample1().use();
	}

}

interface Fly {
	
	default public void takeOff() 	{ System.out.println("Fly::takeOff");}
	default public void turn()		{ System.out.println("Fly::turn");}
	default public void cruise()	{ System.out.println("Fly::turn");}
	default public void land()		{ System.out.println("Fly::turn");}
	
	//Four rules:
	//1. Default methods get inheritate inmediatly
	//2. You can overrride default methods
	//3. Methods in a class hierarchy doens't matter about the place where the method is defined
	
	
}

//1. Default methods get inheritate inmediatly
interface FastFly extends Fly {
	public default void takeOff() {
		{ System.out.println("FastFly::takeOff");}
	}
}

class Vehicle {
	public void land()		{ System.out.println("Vehicle::turn");}
}

//3. Methods in a class hierarchy doens't matter about the place where the method is defined
class SeaPlane extends Vehicle implements FastFly {}