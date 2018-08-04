package com.bjsxt.HttpServer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import java.util.ArrayList;

public class PersonHandler extends DefaultHandler {

    private List<Person> persons;
    private Person person;
    private String tag;
    public PersonHandler(){
        persons = new ArrayList<Person>();
        tag = null;
        person = null;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Now starts to analyze XML file.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End to analyze XML file.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Element started:" + qName);
        if (qName!=null && qName.equalsIgnoreCase("person")){
            person = new Person();
        }
        if (qName!=null){
            tag= qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Element ended:" + qName);
        if (qName.equalsIgnoreCase("person")){
            persons.add(person);
        }
        tag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Element is:" + new String(ch,start,length));
        if (null!=tag && tag.equalsIgnoreCase("name")){
            person.setName(new String(ch,start,length));
        } else if (null!=tag && tag.equalsIgnoreCase("age")){
            person.setAge(Integer.parseInt(new String(ch,start,length)));
        }
    }
    public List<Person> getPersons() {
        return persons;
    }

}
