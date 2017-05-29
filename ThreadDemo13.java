public class ThreadDemo13 extends Object {
	public static void main(String[] args) {
			Thread t = Thread.currentThread();
			System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());//false
			t.interrupt();
			System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());//true
			System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());//true

			try {
					Thread.sleep(2000);//�жϺ���߳��ǲ��ܹ��������ߵģ��������������쳣
					System.out.println("was NOT interrupted");
			} catch ( InterruptedException x ) {
					System.out.println("was interrupted");
			}
			// ��������Ϊsleep�׳����쳣��������������жϱ�־
			System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());//false
	}
}
