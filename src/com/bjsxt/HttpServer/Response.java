package com.bjsxt.HttpServer;
import java.io.*;
import java.net.*;
import java.util.*;
public class Response {
	BufferedWriter br;
	StringBuilder sb ;
	public Response(){
		br= null;
		sb = new StringBuilder();
		sb.append("<html><head><meta charset=\"UTF-8\"><title>ResponseTestWithChinesecharacter</title></head><body>Hello World!	ÄãºÃ£¬ÊÀ½ç£¡	</body>	</html>");
	}
	public Response(OutputStream os){
		this();
		br = new BufferedWriter(new OutputStreamWriter(os));
	}
/*	public static void main(String[] argv){
		Response r = new Response();
		System.out.println(r.sb);
	}*/
}
