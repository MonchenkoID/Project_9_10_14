package com.github.monchenkoid.project_9_10_14.backend;


import java.io.Serializable;

/**
 * The object model for the data we are sending through endpoints
 */
public class TIMBean implements Serializable{

//TIMBean timBean = (TIMBean) getIntent().getSerializableExtra();
    static final long serialVersionUID = 10275539472837496L;

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

    public static String[] getDichotomy() {
        return dichotomy;
    }

    public static void setDichotomy(String[] dichotomy) {
        TIMBean.dichotomy = dichotomy;
    }

    public static String[] getTraitsReinin() {
        return traitsReinin;
    }

    public static void setTraitsReinin(String[] traitsReinin) {
        TIMBean.traitsReinin = traitsReinin;
    }

    public static String[] getModelA() {
        return modelA;
    }

    public static void setModelA(String[] modelA) {
        TIMBean.modelA = modelA;
    }

}