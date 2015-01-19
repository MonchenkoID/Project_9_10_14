package com.github.monchenkoid.project_9_10_14.garbage;


import org.json.JSONObject;

/**
 * Created by Irina Monchenko on 23.10.2014.
 */
public class TIMObject extends JSONObjectWrapper {


    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String MBTI = "mbti";
    private static final String IORE = "iore";
    private static final String NORS = "nors";
    private static final String TORF = "torf";
    private static final String PORJ = "porj";

    public TIMObject(String jsonObject) {
        super(jsonObject);
    }

    public TIMObject(JSONObject jsonObject) {
        super(jsonObject);
    }

    public Long getId() {
        return getLong(ID);
    }

    public String getName() {
        return NAME;
    }

    public String getMbti() {
        return MBTI;
    }

    public String getIore() {
        return IORE;
    }

    public String getNors() {
        return NORS;
    }

    public String getTorf() {
        return TORF;
    }

    public String getPorj() {
        return PORJ;
    }
}