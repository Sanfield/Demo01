class ThreadDemo implements Runnable
{
	private String info;
	public ThreadDemo(String info){
		this.info=info;
	}
	public void run(){
		for(int i=0;i<10;i++){
		System.out.println(this.info+"i="+i);
		}
	}	
}
public class Thred
{
	public static void main(String args[]){
	ThreadDemo t1= new ThreadDemo("线程1");
	ThreadDemo t2= new ThreadDemo("线程2");
	ThreadDemo t3= new ThreadDemo("线程3");
//	t1.start(); //通过start调用run方法
//	t2.start();
//	t3.start();
	Thread d1 = new Thread(t1);
	Thread d2 = new Thread(t2);
	Thread d3 = new Thread(t3);
	d1.start(); //通过start调用run方法
	d2.start();
	d3.start();
	}
}