package com.barry.thread;

public class TraditionalThreadTest {
	
	public static void main(String[] args) {
		Thread threadObj = new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("1:" + this.getName());
				}
			}
		};
		threadObj.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("2:" + Thread.currentThread().getName());
				}
			}
		});
		thread2.start();
	}	
}
