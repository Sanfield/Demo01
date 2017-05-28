import java.io.*;

public class IOdemo02
{
	public static void main(String args[]) throws Exception
	{
		RandomAccessFile raf1 = new RandomAccessFile("g:\\sangfei.txt","rw");
		String name = "zhangsan";
		int age = 20;
		raf1.write(name.getBytes());
		raf1.writeInt(age);

		name = "lisi    ";
		age = 30;
		raf1.write(name.getBytes());
		raf1.writeInt(age);

		name = "wangwu  ";
		age = 33;
		raf1.write(name.getBytes());
		raf1.write(age);

		raf1.close();

		RandomAccessFile raf2 = new RandomAccessFile("g:\\sangfei.txt","r");
		raf2.skipBytes(12);
		byte b[] = new byte[8];
		raf2.read(b);
		int age2 = raf2.readInt();
		System.out.println(new String(b)+"-->"+age2);
		

	}
}
