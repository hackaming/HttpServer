package com.bjsxt.HttpServer;
import java.util.*;
import java.io.*;
import java.net.*;

public class HttpServer {
	public static final int Port = 8888;
	public static final String CRLN = "\r\n";
	public static final String BLANK = " ";
	private ServerSocket ss = null;
	private Boolean  isRunning = true;
	public static void main(String [] argv){
		new HttpServer().start1();
	}
	public void start1(){
		try {
			ss= new ServerSocket(Port);
			Socket client = ss.accept();
			Request r = new Request(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void start(){
		try {
			ss= new ServerSocket(Port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			while (isRunning){
				Socket client = ss.accept();
				Request r = new Request(client.getInputStream());
				// get request
				// send response
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void shutdown(){
		this.isRunning = false;
	}
	
}