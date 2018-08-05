package com.bjsxt.HttpServer;

public abstract class Servlet {
    protected void service (Request req,Response resp){
        this.doGet( req, resp);
        this.doPost( req, resp);
    }
    protected abstract void doGet(Request req,Response resp);
    protected abstract void doPost(Request req,Response resp);
}
