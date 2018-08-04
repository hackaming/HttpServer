package com.bjsxt.HttpServer;
import java.io.*;
import java.net.*;
import java.util.*;
public class Response {
	BufferedWriter bw;
	StringBuilder sb ;
	StringBuilder header;
	StringBuilder content;
	int len;
	public Response(){
		bw= null;
		sb = new StringBuilder();
        header = new StringBuilder();
        content = new StringBuilder();
        len = 0;
	}
	public Response(OutputStream os){
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	public void createHeader(int code){
	    //协议，状态码，描述
        header.append("HTTP/1.1").append(HttpServer.BLANK).append(code).append(HttpServer.BLANK);
        switch(code){
            case 200:
            header.append("OK");
            break;
            case 500:
            header.append("Server Error");
            break;
            case 404:
            header.append("Not Found");
            break;
        }
        header.append(HttpServer.CRLN);
        //响 应头
        header.append("Server:test server/0.0.1").append(HttpServer.CRLN);
        header.append("Date:").append(new Date()).append(HttpServer.CRLN);
        header.append("Content-type:text/html;charset=UTF-8").append(HttpServer.CRLN);
        header.append("Content-Length:").append(len).append(HttpServer.CRLN);
        header.append(HttpServer.CRLN);
    }
    public Response print(String str){
        content.append(str);
        len += str.getBytes().length;
        return this;
    }
	public void pushToClient(int code){
        this.createHeader(code);

        try {
            bw.append(header.toString());
            bw.append(content.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*	public static void main(String[] argv){
		Response r = new Response();
		System.out.println(r.sb);
	}*/
}
