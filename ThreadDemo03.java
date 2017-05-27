class Demo implements Runnable
{
	public void fun()
	{
		for(int i=0;i<10;i++)
		{
			try
			{
				Thread.sleep(1000) ;
			}
			catch (Exception e)
			{
			}
			System.out.println(Thread.currentThread().getName()+" --> 在运行。。。") ;
		}
	}
	public void run()
	{
		this.fun() ;
	}
}
public class ThreadDemo03 
{
	public static void main(String args[]){
		Demo d1 = new Demo();
		Thread t1 = new Thread(d1,"线程1");
		Thread t2 = new Thread(d1,"线程2");
		t1.start();
		t2.start();
	}
}