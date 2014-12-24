package com.github.monchenkoid.project_9_10_14.backend;


/**
 * The object model for the data we are sending through endpoints
 */
public class TIMBean /*TODO implements Serializable*/ {

    //   static final long serialVersionUID = 10275539472837496L;

    private Long id;
    private String name;
    private String[] dichotomy = new String[3];
    private String[] traitsReinin = new String[10];
    private String[] modelA = new String[7];


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDichotomy() {
        return dichotomy;
    }

    public void setDichotomy(String[] dichotomy) {
        this.dichotomy = dichotomy;
    }

    public String[] getTraitsReinin() {
        return traitsReinin;
    }

    public void setTraitsReinin(String[] traitsReinin) {
        this.traitsReinin = traitsReinin;
    }

    public String[] getModelA() {
        return modelA;
    }

    public void setModelA(String[] modelA) {
        this.modelA = modelA;
    }

}