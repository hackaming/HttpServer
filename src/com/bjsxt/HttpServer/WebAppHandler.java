package com.bjsxt.HttpServer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
public class WebAppHandler extends DefaultHandler{
    private List<Entity> entities ;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String beginTag;
    private boolean isMapping;

    public WebAppHandler(){
        entities = null ;
        mappings = null;
        beginTag = null;
        isMapping = false;
        entity = null;
        mapping = null;
    }

    @Override
    public void startDocument() throws SAXException {
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null){
            beginTag = qName;
            if (qName.equalsIgnoreCase("servlet")) {
                isMapping = false;
                this.entity = new Entity();
            } else if (qName.equalsIgnoreCase("servlet-mapping")){
                isMapping = true;
                this.mapping = new Mapping();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (null!=qName){
            if (qName.equalsIgnoreCase("servlet")){
                entities.add(entity);
            } else if (qName.equalsIgnoreCase("servlet-mapping")){
                mappings.add(mapping);
            }
        }
        beginTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (beginTag == null){
            return;
        }
        String str = new String(ch,start,length);
        if (isMapping){
            if (beginTag.equalsIgnoreCase("servlet-name")){
                mapping.setName(str);
            } else if (beginTag.equalsIgnoreCase("url-pattern")){
                mapping.getUrlPatterns().add(str);
            }
        } else {
            if (beginTag.equalsIgnoreCase("servlet-name")){
                entity.setName(str);
            } else if (beginTag.equalsIgnoreCase("servlet-class")){
                entity.setClz(str);
            }
        }
    }
    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<Mapping> mappings) {
        this.mappings = mappings;
    }
}
