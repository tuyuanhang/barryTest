package com.barry.thread.test;

import java.io.FileWriter;
import java.io.PrintWriter;


public class TestThread_02 {
	public static void main(String[] args) {
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		
		for (int i=0; i<10; i++) {
			threads[i] =  new Thread(new Calculator(i));
			if ((i%2) == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}
		
		PrintWriter pw = null;
		try {
			FileWriter file = new FileWriter(".\\data\\log.txt");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
