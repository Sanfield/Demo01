class Demo implements Runnable
{
	public void run()
	{
		System.out.println("1��Demo --> �����������״̬��") ;
		try
		{
			Thread.sleep(2000) ;
		}
		catch (Exception e)
		{
			System.out.println("2��Demo --> �����ж�") ;
			return ;
		}
		System.out.println("3��Demo --> ���������˳���") ;
	}
};

public class ThreadDemo12
{
	public static void main(String args[])
	{
		Thread t = new Thread(new Demo(),"LXH") ;
		System.out.println(t.getName()+" --> �߳�������") ;
		t.start() ;
		System.out.println("4��MAIN --> ���߳�����") ;
		try
		{
			// �������ٿ�������2000����
			Thread.sleep(10000) ;
		}
		catch (Exception e)
		{
		}
		System.out.println("5��MAIN --> �ж��̡߳�") ;
		t.interrupt() ;
		System.out.println("6��MAIN --> �����˳���") ;
	}
};