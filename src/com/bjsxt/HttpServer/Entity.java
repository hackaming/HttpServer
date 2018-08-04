package com.bjsxt.HttpServer;

/**
 *
 * <servlet-name>login</servlet-name>
 * <servlet-class>com.bjsxt.HttpServer.LoginServlet</servlet-class>
 *
 */

public class Entity {
    private String name;
    private String clz;
    public Entity(){
        name = null;
        clz = null;
    }
    public Entity(String name,String clz){
        this();
        this.clz = clz;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
