package com.ccb.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPC {
	public static void main(String[] args) throws Exception {
		// 自己和对方的端口及ip
		int myPort = 9798;
		int otherPort = 9797;
		String ip = "127.0.0.1";
		// 建立一个socket
		DatagramSocket ds = new DatagramSocket(myPort);
		// 建一个包
		String msg = "你好呀";
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,
				InetAddress.getByName(ip), otherPort);
		ds.send(packet);
        System.out.println(msg);
        // 关闭资源
		ds.close();
	}
}
