package com.barry.thread.task;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

class Event {
	private Date date;
	private String event;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	
}

public class WriteTask implements Runnable {
	
	private Deque<Event> deque;
	
	public WriteTask(Deque<Event> deque) {
		this.deque = deque;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event", 
					Thread.currentThread().getId()));
			deque.addFirst(event);
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("add task sleep, count: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

