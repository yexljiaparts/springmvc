package com.bean;

/**
 * ${DESCRIPTION}
 * Created by Administrator on 2017/7/9.
 */
public class Product {
    private  String id;
    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {

    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
