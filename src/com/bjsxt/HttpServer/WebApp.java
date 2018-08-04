package com.bjsxt.HttpServer;
import java.util.*;
public class WebApp {
    private static ServletContext servletContext;
    static{ //read all the message from the web.xml, here just simulate it by adding it manually
        servletContext = new ServletContext();
        Map<String,String> mapping = servletContext.getMapping();
        Map<String,Servlet> servlets = servletContext.getServlets();
        servlets.put("login", new LoginServlet());
        servlets.put("register", new RegisterServlet());
        mapping.put("/login","login");
        mapping.put("/register","register");
        }
        public static Servlet getServlet(String url){
            String s = servletContext.getMapping().get(url);
            Servlet ser = servletContext.getServlets().get(s);
            return ser;
        }
/*        public static void main(String argv[]){
            WebApp w = new WebApp();
            String s = w.servletContext.getMapping().get("/register");
            System.out.println(s);
        }*/
}
