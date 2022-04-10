package com.ccb.internet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 9090);
		// 发送信息
		OutputStream os = socket.getOutputStream();
		os.write("你好呀".getBytes());
		// 接收信息
		InputStream is = socket.getInputStream();
		byte[] datas = new byte[1024];
		is.read(datas);
		System.out.println(new String(datas));
		// 关闭资源
		socket.close();
	}
}
