package concurrency;

import java.util.concurrent.TimeUnit;

class A {

	final Object res1 = new Object();
	final Object res2 = new Object();

	void m1() {

		String name = Thread.currentThread().getName();
		System.out.println(name + " attempting to access res1");

		synchronized (res1) {

			System.out.println(name + " accessed res1");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(name + " attempting to access res2");

			synchronized (res2) {
				
				System.out.println(name + " accessed res2");
				
			}

		}

	}
	

	void m2() {

		String name = Thread.currentThread().getName();
		System.out.println(name + " attempting to access res2");

		synchronized (res2) {

			System.out.println(name + " accessed res2");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(name + " attempting to access res1");

			synchronized (res1) {
				
				System.out.println(name + " accessed res1");
				
			}

		}

	}
}

public class Deadlock {
	
	public static void main(String[] args) {
		
		
		A a = new A();
		
		Thread thread1 = new Thread(() -> a.m1(), "T1");
		Thread thread2 = new Thread(() -> a.m2(), "T2");
		
		
		thread1.start();
		thread2.start();
	}

}
