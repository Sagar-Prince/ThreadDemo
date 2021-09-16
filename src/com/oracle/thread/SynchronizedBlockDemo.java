package com.oracle.thread;

class Display{
	
	public void wish(String name) {
		
		//;;;;;;;; 1 lake line of code
		
		
		synchronized (Display.class) {
			for(int i=0; i<10; i++) {
				
				System.out.println("GoodMorming : "+name);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
		//;;;;;;;1 lake line of code
		
	}
	
}

class Mythread extends Thread{
	
	Display d;
	String name;
	
	Mythread(Display d, String name){
		
		this.d=d;
		this.name=name;
	}
	
	@Override
	public void run() {
		d.wish(name);
	}
	
}



public class SynchronizedBlockDemo {

	public static void main(String[] args) {
		Display d= new Display();
		Display d1= new Display();
		Mythread m=new Mythread(d,"Dhoni");
		Mythread m1=new Mythread(d1,"yuvraj");
		
		m.start();
		m1.start();

	}

}
