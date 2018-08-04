package com.bjsxt.HttpServer;

public class LoginServlet extends Servlet {

    public void doGet(Request req,Response resp){
        resp.print("Hello "+req.getParameters("name") +"你好，世界！");
        resp.print("Login");
    }
    public void doPost(Request req,Response resp){
    }
}
