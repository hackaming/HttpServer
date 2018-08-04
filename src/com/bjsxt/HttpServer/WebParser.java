package com.bjsxt.HttpServer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebParser {
    public static void main(String[] argv) throws Exception{
        SAXParserFactory factor = SAXParserFactory.newInstance();
        SAXParser parser = factor.newSAXParser();
        WebAppHandler handler = new WebAppHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bjsxt/HttpServer/web.xml"),handler);
        for (Entity entity:handler.getEntities()){
            if (entity != null){
                System.out.println(entity.getName()+"-------"+entity.getClz());
            }
        }
    }
}
