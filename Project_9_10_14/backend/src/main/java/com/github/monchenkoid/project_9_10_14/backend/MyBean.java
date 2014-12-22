package com.github.monchenkoid.project_9_10_14.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}