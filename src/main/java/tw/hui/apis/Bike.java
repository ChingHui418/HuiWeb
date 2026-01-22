package tw.hui.apis;

import java.io.Serializable;

public class Bike extends Object implements Serializable {
	protected double speed;
	
	public Bike() {
		System.out.println("Bike()");
	}
	
	public Bike(int a) {
		System.out.println("Bike(int)");
	}
	
//	public void upSpeed() {
//		speed = speed < 1 ? 1 : speed * 1.3;
//	}
	// 1/7
	public Bike upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.3;
		return this;
	}
	public Bike downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
		return this;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "Speed: " + speed;
		
	}
}
