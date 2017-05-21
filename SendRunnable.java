package com.flysander.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendRunnable implements Runnable{
	private String ip="";
	private int port ;
	public SendRunnable(String ip,int port){
	  this.ip=ip;
	  this.port= port;
	}
	
	public void run() {
		try {
			send();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send() throws IOException {
		 System.out.println("发送端开始运行"); 
		    DatagramSocket da = new DatagramSocket();
	     InputStreamReader isr = new InputStreamReader(System.in);
	     BufferedReader reader  = new BufferedReader(isr);
	     String read = "";
	     while((read= reader.readLine())!= null){
	    	 byte[] b = read.getBytes();
	    	 DatagramPacket p = new DatagramPacket(b, b.length,InetAddress.getByName(ip),port);
	    	 da.send(p);
	    	 if(read.equals(886)){
	    		 break;  		 
	    	 }
	    	 
	     }
	     da.close();
	}
}


