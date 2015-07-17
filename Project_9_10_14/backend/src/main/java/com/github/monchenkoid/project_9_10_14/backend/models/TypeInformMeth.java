package com.github.monchenkoid.project_9_10_14.backend.models;

import java.util.ArrayList;

/**
 @author Iryna Monchenko
 @version on 05.03.2015
 */

public class TypeInformMeth extends Entity {

    private Long mId;
    private ArrayList<String> mName;
    private ArrayList<String> mDiUng;
    private ArrayList<String> mReign;
    private ArrayList<String> mModelA;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public ArrayList<String> getName() {
        return mName;
    }

    public void setName(ArrayList<String> name) {
        this.mName = name;
    }

    public ArrayList<String> getDiUng() {
        return mDiUng;
    }

    public void setDiUng(ArrayList<String> diUng) {
        this.mDiUng = diUng;
    }

    public ArrayList<String> getReign() {
        return mReign;
    }

    public void setReign(ArrayList<String> reign) {
        this.mReign = reign;
    }

    public ArrayList<String> getModelA() {
        return mModelA;
    }

    public void setModelA(ArrayList<String> modelA) {
        this.mModelA = modelA;
    }
}
