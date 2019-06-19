package com.app;

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
	public
	void m1() {
		System.out.println("C : m1()");
	}
}

class Gen {
	
	static <T> {
		
	}
	
	
}

public class TestApp {
	
	public static void main(String[] args) {
		
		
		I1 i1 = new C();
		I2 i2 = new C();
		
		
		i1.m1();
		i2.m1();
		
		
	}

}
