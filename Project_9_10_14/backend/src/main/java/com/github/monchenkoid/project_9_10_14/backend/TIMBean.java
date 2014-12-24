package com.github.monchenkoid.project_9_10_14.backend;


/**
 * The object model for the data we are sending through endpoints
 */
public class TIMBean /*TODO implements Serializable*/ {

    //   static final long serialVersionUID = 10275539472837496L;

    private static Long id;
    private static String name;
    private static String[] dichotomy = new String[3];
    private static String[] traitsReinin = new String[10];
    private static String[] modelA = new String[7];


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        TIMBean.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        TIMBean.name = name;
    }

    public String[] getDichotomy() {
        return dichotomy;
    }

    public void setDichotomy(String[] dichotomy) {
        TIMBean.dichotomy = dichotomy;
    }

    public String[] getTraitsReinin() {
        return traitsReinin;
    }

    public void setTraitsReinin(String[] traitsReinin) {
        TIMBean.traitsReinin = traitsReinin;
    }

    public String[] getModelA() {
        return modelA;
    }

    public void setModelA(String[] modelA) {
        TIMBean.modelA = modelA;
    }

}