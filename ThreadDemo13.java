public class ThreadDemo13 extends Object {
	public static void main(String[] args) {
			Thread t = Thread.currentThread();
			System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());//false
			t.interrupt();
			System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());//true
			System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());//true

			try {
					Thread.sleep(2000);//中断后的线程是不能够进行休眠的，所以这里会出现异常
					System.out.println("was NOT interrupted");
			} catch ( InterruptedException x ) {
					System.out.println("was interrupted");
			}
			// 在这里因为sleep抛出了异常，所以它清除了中断标志
			System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());//false
	}
}
