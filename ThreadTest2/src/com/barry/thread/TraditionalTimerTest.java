package com.barry.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			public void run() {
				System.out.println("bombing");
			}
		}, 1000,3000);
		
		new Timer().schedule(new MyTimerTask(), 3000);
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}

class MyTimerTask extends TimerTask {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("bombing");
		new Timer().schedule(new MyTimerTask(), 2000);
	}
}

