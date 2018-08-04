package com.bjsxt.HttpServer;

public class RegisterServlet extends Servlet {

    public void doGet(Request req,Response resp){
        resp.print("Hello World!"+req.getParameter("name")+"你好，世界！");
        resp.print("Register");
    }
    
    public void doPost(Request req,Response resp){
    }
}
