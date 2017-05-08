package com.flysander.www;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;


/*
 * TCP网页输出
 * */
public class WindowDemo extends JFrame{
 public static void main(String args[]) throws IOException{
	 ServerSocket seversocket = new ServerSocket(6147);//监听一个端口
	 Socket socket = seversocket.accept();
	 OutputStream out=socket.getOutputStream();
	 out.write("nihao ".getBytes());
	 out.close();
	 seversocket.close();
	 
 }
}
