package com.bjsxt.HttpServer;

public class Servlet {
    private Response resp;
    private Request req;
    public Servlet(){
        resp = null;
        req = null;
    }
    public Servlet(Request req,Response resp){
        this();
        this.req = req;
        this.resp = resp;
    }

    public void service(Request req,Response resp){
        resp.print("Hello World!你好，世界！");
        resp.print("dddddd");
        resp.pushToClient(200);
    }
    public void doGet(){

    }
    public void doPost(){

    }
}
