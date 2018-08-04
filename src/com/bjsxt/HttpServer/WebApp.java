package com.bjsxt.HttpServer;
import java.util.*;
public class WebApp {
    private static ServletContext servletContext;
    static{ //read all the message from the web.xml, here just simulate it by adding it manually
        servletContext = new ServletContext();
        Map<String,Servlet> mapping = servletContext.getMapping();
        mapping.put("login", new LoginServlet());
        mapping.put("register", new RegisterServlet());
        Map<String,String> servlets = servletContext.getServlets();
        servlets.put("/login","login");
        servlets.put("/register","register");
        }
        public static Servlet getServlet(String url){
            return servletContext.getServlets().get(servletContext.getMapping().get(url));
        }
}
