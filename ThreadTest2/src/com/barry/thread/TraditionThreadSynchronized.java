package com.barry.thread;

public class TraditionThreadSynchronized {
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			final Outputer outputer = new Outputer();
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					outputer.output("barry");
				}
				
			}
			
		}).start();
		
		
		new Thread(new Runnable() {
			final Outputer outputer = new Outputer();
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					outputer.output("test");
				}
				
			}
			
		}).start();
		
	}

}

class Outputer {
	
	public void output(String name) {
		int len = name.length();
		synchronized(this) {
			for(int i=0; i<len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
}
