package com.bjsxt.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss = null;
	
	public static void main(String[] argv){
		Server server = new Server();
		server.start();
	}
	public void start(){
		try {
			ss = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void stop(){
		
	}
	public void receive(){
		try {
			Socket client = ss.accept();
			StringBuilder msg = new StringBuilder();
			String s = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((s=br.readLine()).length()>0){
				msg.append(s).append("\r\n");
				if (s == null){
					break;
				}
			}
			//请求信息---后面要对他进行处理。
			String requestInfo = msg.toString().trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
