package concurrency;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NumberFactory {

	private static Object lock = new Object();
	private static List<Integer> list = new ArrayList<>();
	private static boolean printOdd = true;

	static class EvenFactory {

		private static int num = 2;

		public void produce() {

			for (int i = 0; i < 10; i++) {
				
				synchronized (lock) {
					
					if (printOdd) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					list.add(num);
					
					
					num += 2;

					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					printOdd = true;
					
					lock.notify();
				}

			}

		}

	}

	static class OddFactory {

		private static int num = 1;

		public void produce() {

			for (int i = 0; i < 10; i++) {

				synchronized (lock) {

					if (!printOdd) {
						
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					list.add(num);
					
					
					num += 2;
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					printOdd = false;
					
					lock.notify();

				}
				


			}

		}

	}

	public static void main(String[] args) throws InterruptedException {

		EvenFactory evenFac = new EvenFactory();
		OddFactory oddFac = new OddFactory();

		Thread t1 = new Thread(() -> evenFac.produce(), "Even Factory");
		Thread t2 = new Thread(() -> oddFac.produce(), "Odd Factory");

		t2.start();
		t1.start();

		t1.join();
		t2.join();

		System.out.println(list);

	}

}
