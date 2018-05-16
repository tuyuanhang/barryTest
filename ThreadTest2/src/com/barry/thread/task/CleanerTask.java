package com.barry.thread.task;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {
	
	private Deque<Event> deque;
	
	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true);
	}
	
	@Override
	public void run() {
		while(true) {
			Date date = new Date();
			clean(date);
		}
	}
	
	private void clean(Date date) {
		System.out.println("start clean date: " + date.toString());
		long difference;
		boolean isDelete;
		if (deque.size() == 0) {
			return;
		} 
		
		isDelete = false;
		
		do {
			Event e = deque.getLast();
			difference = date.getTime() - e.getDate().getTime();
			System.out.println("difference value is: " + difference);
			if (difference > 10000) {
				System.out.printf("Cleaner: %s\n", e.getEvent());
				deque.removeLast();
				isDelete = true;
			}
		} while (difference > 10000); 
		
		if (isDelete) {
			System.out.printf("Cleaner:size of the queue: %d\n", deque.size());
		}
		
	}
}
