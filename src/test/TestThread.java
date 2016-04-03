package test;

import java.util.Date;

public class TestThread extends Thread{
	
	static Object waitor = new Object();
	public void run(){
		System.out.println(new Date()+"kkkkkk1");
		synchronized(waitor){
			try {
				waitor.wait(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(new Date()+"kkkkkk");
	}
}
