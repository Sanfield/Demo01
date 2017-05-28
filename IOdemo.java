import java.io.*;

public class IOdemo
{
	public static void main(String args[]) throws Exception
	{
		File f = new File("g:\\sangfei.txt");
        if (f.exists())
        {
			f.delete();
        }
		else
		{
			f.createNewFile();
		}
	}
}
