package com.bjsxt.HttpServer;
import java.util.*;
/**
 * <servlet-name>login</servlet-name>
 * <url-pattern>/log</url-pattern>
 */
public class Mapping {
    private String name;
    private List<String> urlPatterns;

    public Mapping(){
        name = null;
        urlPatterns = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(List<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }
}
