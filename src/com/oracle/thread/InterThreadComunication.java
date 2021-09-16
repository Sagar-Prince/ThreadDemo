package com.oracle.thread;

class MyThread1 extends Thread {

	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("child thried start calculating");
			for (int i = 1; i <= 100; i++) {

				total=total+i;
			}
			System.out.println("chield thried trying to give notification");

			this.notify();

		}
	}

}

public class InterThreadComunication {

	public static void main(String[] args) {

		MyThread1 t = new MyThread1();
		t.start();

		try {
			synchronized (t) {
				System.out.println("main thried trying to call wait method");

				t.wait();

				System.out.println("main thried got notification");
				System.out.println(t.total);
			}
		} catch (InterruptedException i) {
			i.printStackTrace();
		}

	}

}
