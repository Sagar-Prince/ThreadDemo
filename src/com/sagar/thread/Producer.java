package com.sagar.thread;

public class Producer extends Thread {
	
	Company c;
	Producer(Company c){
		this.c=c;
	}
	
	@Override
	public void run() {
		int n=1;
		while(true) {
			this.c.produce_item(n);
			
			n++;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
