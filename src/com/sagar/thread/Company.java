package com.sagar.thread;

public class Company {

	int n;
	boolean f=false;
//if f=false then its a chance of producer to produce 
	public synchronized void  produce_item(int n) {
		
		if(f) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		this.n = n;
		System.out.println("Produce : " + this.n);
		f=true;
		this.notify();
				
	}

	public synchronized int consume_item() {
		if(!f) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("consumer : " + this.n);
		f=false;
		this.notify();
		return this.n;
	}

}
