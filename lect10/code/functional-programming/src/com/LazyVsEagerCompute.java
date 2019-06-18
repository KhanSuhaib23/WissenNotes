package com;

interface I1 {
	
	default void m1() {
		System.out.println("I1: m1()");
	}

}

interface I2 {
	
	default void m1() {
		System.out.println("I2: m1()");
	}
}

class C implements I1, I2 {
	
	@Override
	public void m1() {
		I1.super.m1();
		I2.super.m1();
	}
	
}

public class LazyVsEagerCompute {
	
	public static void main(String[] args) {
		
		C c = new C();
		
		c.m1();
		
		
	}

}
