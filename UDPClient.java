package com.flysander.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.zip.DataFormatException;

public class UDPClient {


	public static void main(String[] args) throws IOException {
	 System.out.println("客户端开始运行"); 
	    DatagramSocket da = new DatagramSocket();
     InputStreamReader isr = new InputStreamReader(System.in);
     BufferedReader reader  = new BufferedReader(isr);
     String read = "";
     while((read= reader.readLine())!= null){
    	 byte[] b = read.getBytes();
    	 DatagramPacket p = new DatagramPacket(b, b.length,InetAddress.getLocalHost(),6148);
    	 da.send(p);
    	 if(read.equals(886)){
    		 break;  		 
    	 }
    	 
     }
     da.close();
	}
	
	public void DatagramSocketExample1() throws IOException {
		 System.out.println("客户端开始运行");
		  DatagramSocket  da=  new DatagramSocket();//可以理解为 创建一个管道
	      // 构建数据包
		  byte[] b = "hello,world".getBytes();                                     
		  DatagramPacket  p = new  DatagramPacket(b, b.length,InetAddress.getByName("127.0.0.1"),6148);
		  da.send(p);
		  da.close();
		  System.out.println("客户端运行结束");
	}

}
