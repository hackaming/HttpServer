package com.bjsxt.HttpServer;

import java.util.*;

public class WebApp {
    private static ServletContext servletContext;

    static { //read all the message from the web.xml, here just simulate it by adding it manually
        servletContext = new ServletContext();
        Map<String, String> mapping = servletContext.getMapping();
        Map<String, String> servlets = servletContext.getServlets();
        servlets.put("login", "com.bjsxt.HttpServer.LoginServlet");
        servlets.put("register", "com.bjsxt.HttpServer.RegisterServlet");
        mapping.put("/login", "login");
        mapping.put("/register", "register");
    }

    public static Servlet getServlet(String url) {
        String s = servletContext.getMapping().get(url);
        String ser = servletContext.getServlets().get(s);
        try {
            return (Servlet) Class.forName(ser).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
/*        public static void main(String argv[]){
            WebApp w = new WebApp();
            String s = w.servletContext.getMapping().get("/register");
            System.out.println(s);
        }*/
}
