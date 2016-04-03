package test;

public class TestThread2 {
	public static void main(String[] args) throws InterruptedException {
		new TestThread().start();
		Thread.sleep(2000);
		synchronized(TestThread.waitor){
			TestThread.waitor.notify();
		}
		
	}
}
