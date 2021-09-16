package com.sagar.thread;

public class Main {

	public static void main(String[] args) {
		Company c=new Company();
		Producer p=new Producer(c);
		Consumer con=new Consumer(c);
		p.start();
		con.start();
	}

}
