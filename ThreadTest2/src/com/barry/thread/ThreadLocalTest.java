package com.barry.thread;

public class ThreadLocalTest {
	
	static ThreadLocal<MyThreadScopeData> scopeData = new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		
		for (int i=0; i<2; i++) {
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					/**MyThreadScopeData myData = new MyThreadScopeData();
					myData.setName("barry");
					myData.setAge(39);
					scopeData.set(myData);*/
					MyThreadScopeData.getInstance().setName("barry");
					MyThreadScopeData.getInstance().setAge(39);
				}
			}).start();
		}
		
	}

}


class MyThreadScopeData {
	
	private MyThreadScopeData(){};
	

	/*
	private static MyThreadScopeData instance = null;
	
	public static synchronized MyThreadScopeData getInstance() {
		if (instance == null) {
			instance = new MyThreadScopeData();
		}
		return instance;
	}
	*/
	
	public static  MyThreadScopeData getInstance() {
		MyThreadScopeData instance = map.get();
		if (instance == null) {
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}