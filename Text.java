package com.flysander.www;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.omg.CORBA.Current;

public class Text {
  public static void main(String args[]) throws IOException{
	   String ip = "127.0.0.1";
	   int port = 6149;
	   SendRunnable se= new SendRunnable(ip,port);
	   ReciveRunnable re = new ReciveRunnable(port);
	   Thread  ths = new Thread(se);
	   Thread  thr = new Thread(re);
	   ths.start();
	   thr.start();
	   
	   
	   
	   
	  
  }
}
