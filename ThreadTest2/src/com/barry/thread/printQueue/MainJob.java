package com.barry.thread.printQueue;

public class MainJob {
	
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		
		Thread thread[] = new Thread[10];
		
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread " + i);
		}
		
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
		}
	}

}
