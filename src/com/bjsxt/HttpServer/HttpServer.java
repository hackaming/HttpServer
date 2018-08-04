package com.bjsxt.HttpServer;
import java.util.*;
import java.io.*;
import java.net.*;

public class HttpServer {
	//public static final int Port = 8888;
	public static final String CRLN = "\r\n";
	public static final String BLANK = " ";
	private ServerSocket ss = null;
	private Boolean  isRunning = true;
	public static void main(String [] argv){
		new HttpServer().start();
	}
	public void receive(){
        try {
            while (isRunning){
                Socket client = ss.accept();
                new Thread(new Dispatcher(client)).start(); //dispatcher the request.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CloseUtil.closeIO(ss);
    }
	public void start(){
        start(8888);
	}
	public void start(int port){
        try {
            ss= new ServerSocket(port);
            receive();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
	public void shutdown(){
		this.isRunning = false;
	}
	
}
