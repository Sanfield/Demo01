class Demo implements Runnable{
	private int tacket=10;
//	private String  info;
//	public Demo(String info){
//	this.info=info;
//	}
	public void run(){
		while(tacket>0){
		System.out.println(Thread.currentThread().getName()+"卖票了:"+this.tacket--);
		}
	}
}
public class ThradDemo02

{
	public static void main(String args[]){
		Demo d1 = new Demo();
		Thread t1 = new Thread(d1,"线程1");
		Thread t2 = new Thread(d1,"线程2");
		Thread t3 = new Thread(d1,"线程3");
		t1.start();
		t2.start();
		t3.start();
	}
}
