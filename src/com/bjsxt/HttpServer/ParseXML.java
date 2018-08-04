package com.bjsxt.HttpServer;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ParseXML {
    public static void main(String[] argv){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        PersonHandler personHandler = new PersonHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/bjsxt/HttpServer/person.xml"),personHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        for (Person p : personHandler.getPersons()){
            System.out.println(p.getName()+"----->"+p.getAge());
        }
    }
}
