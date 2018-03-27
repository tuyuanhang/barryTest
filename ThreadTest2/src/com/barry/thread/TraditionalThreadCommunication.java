package com.barry.thread;

public class TraditionalThreadCommunication {
	
	final static Business business = new Business();
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int j=1; j<=50; j++) {
					business.sub(j);
				}
				
			}
		}).start();
		
		
		for (int j=1; j<=50; j++) {
			business.main(j);
		}
		
	}

}

class Business {
	
	private boolean bShouldSub = true;
	
	public synchronized void sub(int j) {
		while (!bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i=1; i<=10; i++) {
			System.out.println("sub thread sequence of " + i + "loop of: " + j) ;
		}
		bShouldSub = false;
		this.notify();
	}
	
	public synchronized void main(int j) {
		while (bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i=1; i<=100; i++) {
			System.out.println("main thread sequence of " + i + "loop of: " + j) ;
		}
		bShouldSub = true;
		this.notify();
	}
}
