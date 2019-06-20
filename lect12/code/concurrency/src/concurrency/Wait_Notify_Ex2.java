
package concurrency;

import java.util.concurrent.TimeUnit;

class Pool {

	private Object lock = new Object();
	static boolean b = false;
	static String lastThread = "";

	public void swim() {
		String name = Thread.currentThread().getName();
		synchronized (lock) {
			if (lastThread.equals(name)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				

			System.out.println(name + " -- swimming started..");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " -- swimming finished..");
			lastThread = name;
			lock.notify();
		}
	}

}

public class Wait_Notify_Ex2 {

	public static void main(String[] args) {

		Pool pool = new Pool();

		Runnable swimTask = () -> {
			for (int i = 0; i < 5; i++) {
				pool.swim();
			}
		};

		Thread thread1 = new Thread(swimTask, "boy");
		Thread thread2 = new Thread(swimTask, "girl");

		thread1.start();
		thread2.start();

	}

}
