package com.flysander.www;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReciveRunnable implements Runnable{
  private int port;
  public ReciveRunnable(int port){
	  this.port= port;
  }
	@Override
	public void run() {
		try {
			recived() ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void recived() throws IOException{
		System.out.println("���ܶ�����");
		DatagramSocket ds = new DatagramSocket(port);// ����һ���˿�
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf, 1024);// ����һ�����ݰ�
		String msg = "";
		while (true) {
			ds.receive(p);
			System.out.println(new String(p.getData()));// ��ȡ���ݰ��ĵ�����
			InetAddress address = p.getAddress();// ��ȡ���Ͷ�������Ϣ
			System.out.println(address.getHostName() + " " + p.getPort());
			String mag =  new String(p.getData());
			if (mag.equals(886)) {
				break;
			}
		}
		// System.out.println(ds.getLocalAddress());
		System.out.println(p.getLength());
		ds.close();

	}
	}
	


