package com.ccb.internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		// 自己和对方的端口及ip
		int myPort = 9090;
		int otherPort = 9797;
		String ip = "192.168.1.107";
		
		// 建立一个socket
		DatagramSocket ds = new DatagramSocket(myPort);

		Scanner sc = new Scanner(System.in);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		// 发送线程
		Thread sendThr = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					// 发送
					try {
						// 建一个包
						String msg = sc.next();
						DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,
								InetAddress.getByName(ip), otherPort);
						ds.send(packet);
						// 格式化输出日期
                        System.out.print(myPort + " ");
                        System.out.print(sdf.format(new Date()) + " : ");
                        System.out.println(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		// 接收线程
		Thread receiveThr = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					// 接收数据包
					byte[] data = new byte[1024];
					DatagramPacket packet0 = new DatagramPacket(data, 0, data.length);

					try {
						ds.receive(packet0);
						// 格式化输出日期
						System.out.print(otherPort + " ");
						System.out.print(sdf.format(new Date()) + " : ");
						System.out.println(new String(data));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}
			}
		});
		
		// 启动线程
		sendThr.start();
		receiveThr.start();
		// 关闭资源
		//ds.close();
	}
}
