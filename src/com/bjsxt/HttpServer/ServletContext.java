package com.bjsxt.HttpServer;
import java.util.*;
public class ServletContext { //a container includes all the servlet information
    Map<String,String> servlets; //url to servlet
    Map<String,String> mapping; //string to url?
    public ServletContext(){
        servlets = new HashMap<String,String>();
        mapping = new HashMap<String,String>();
    }

    public Map<String, String> getServlets() {
        return servlets;
    }

    public void setServlets(Map<String, String> servlets) {
        this.servlets = servlets;
    }
    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
