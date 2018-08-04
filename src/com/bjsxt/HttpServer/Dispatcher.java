package com.bjsxt.HttpServer;
import java.net.*;
import java.io.*;
import java.util.*;

public class Dispatcher implements Runnable{
    private Response resp;
    private Request req;
    private Socket s;
    private int code = 200;
    public Dispatcher(Socket s){
        this.s = s;
        try {
            req = new Request(s.getInputStream());
            resp = new Response(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            resp.pushToClient(500);
            return;
        }
    }
    public void run(){
        String url = req.getsPage();
        if ( url == null || url.trim() == ""){
            code = 500;
        } else {
            Servlet servlet = WebApp.getServlet(url.trim());// will needs to add try catch!
            if (null == servlet){
                code = 404;
            } else {
                servlet.service(req,resp);
            }
        }
        resp.pushToClient(code);
        CloseUtil.closeIO(s);
    }
}
