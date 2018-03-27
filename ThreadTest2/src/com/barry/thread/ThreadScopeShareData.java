package com.barry.thread;

import java.util.Random;

public class ThreadScopeShareData {

	private static int data = 0;
	public static void main(String[] args) {
		for (int i=0; i < 2; i++) {
			new Thread (new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() +
							"has put data:" + data);
					new A().get();
					new B().get();
				}
			}).start();
		}

	}
	
	static class A {
		public void get() {
			System.out.println("A from " + Thread.currentThread().getName() +
					"has put data:" + data);
			
		}
	}
	
	static class B {
		public void get() {
			System.out.println("B from " + Thread.currentThread().getName() +
					"has put data:" + data);
		}
	}

}
