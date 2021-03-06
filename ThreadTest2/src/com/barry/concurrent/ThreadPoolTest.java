package com.barry.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i=1; i<=10; i++) {
			final int task = i;
			threadPool.execute(new Runnable(){
				@Override
				public void run() {
					for (int j=1; j<10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " looping of " + j + " task of " + task);
						
					}
					
				}
			});
		}
		System.out.println("all 10 tasks had been commited.");
		threadPool.shutdown();
	}

}
