package com.bjsxt.HttpServer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;

public class WebApp {
    private static ServletContext servletContext;

    static { //read all the message from the web.xml, here just simulate it by adding it manually
        try {
            SAXParserFactory factor = SAXParserFactory.newInstance();
            SAXParser parser = factor.newSAXParser();
            WebAppHandler handler = new WebAppHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bjsxt/HttpServer/web.xml"), handler);
            // List<Mapping>  mapping = handler.getMappings(); // will get the configuration from web.xml needs to continue tomorrow.
            // List<Entity> servlets = handler.getEntities();
            servletContext = new ServletContext();
            for (Entity entity:handler.getEntities()){
                servletContext.getServlets().put(entity.getName(),entity.getClz());
            }
            for (Mapping mapping:handler.getMappings()){
                String name = mapping.getName();
                List<String> urlList = mapping.getUrlPatterns();
                for (int i=0;i<urlList.size();i++){
                    servletContext.getMapping().put(urlList.get(i),name);
                }
            }
/**
 * add the code to transfer the mapping and servlets into map  here??
 */
        }catch (Exception e){

        }
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
