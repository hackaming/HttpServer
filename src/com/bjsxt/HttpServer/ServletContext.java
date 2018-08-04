package com.bjsxt.HttpServer;
import java.util.*;
public class ServletContext { //a container includes all the servlet information
    Map<String,Servlet> servlets; //url to servlet
    Map<String,String> mapping; //string to url?
    public ServletContext(){
        context = new HashMap<String,Servlet>();
        mapping = new HashMap<String,String>();
    }

    public Map<String, Servlet> getServlets() {
        return servlets;
    }

    public void setServlets(Map<String, Servlet> servlets) {
        this.servlets = servlets;
    }
    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
