package com.sagar.thread;

class A{
	public synchronized void d1(B b) {
		System.out.println("Thread 1 call d1 method");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("inside a b last method is called");
		b.last();
	}
	public synchronized void last() {
		System.out.println("this is last method of a class");
	}
}

class B{
	public synchronized void d2(A a) {
		System.out.println("Thread 2 cals d2 method");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("inside b a last method is called");
		a.last();
	}
	public synchronized void last() {
		System.out.println("this is last method of b class");
	}
}
public class DedlockDemo extends Thread {

	A a=new A();
	B b=new B();
	
	public void m1() {
		this.start();
		a.d1(b);
	}
	
	@Override
	public void run() {
		b.d2(a);
	}
	
	
	public static void main(String[] args) {
		
		DedlockDemo dd= new DedlockDemo();
		dd.m1();
		
	}

}
