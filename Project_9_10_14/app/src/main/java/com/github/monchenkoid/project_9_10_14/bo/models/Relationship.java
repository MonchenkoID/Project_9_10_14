package com.github.monchenkoid.project_9_10_14.bo.models;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class Relationship {

    private String mTypeRelationship;
    private String mNameRelationship;
    private String mDescriptionRelationship;
    private Role mSecondUser;


    public Relationship(String mTypeRelationship, String mNameRelationship, String mDescriptionRelationship, Role mSecondUser) {
        this.mTypeRelationship = mTypeRelationship;
        this.mNameRelationship = mNameRelationship;
        this.mDescriptionRelationship = mDescriptionRelationship;
        this.mSecondUser = mSecondUser;
    }

    public String getmTypeRelationship() {
        return mTypeRelationship;
    }

    public void setmTypeRelationship(String mTypeRelationship) {
        this.mTypeRelationship = mTypeRelationship;
    }

    public String getmNameRelationship() {
        return mNameRelationship;
    }

    public void setmNameRelationship(String mNameRelationship) {
        this.mNameRelationship = mNameRelationship;
    }

    public String getmDescriptionRelationship() {
        return mDescriptionRelationship;
    }

    public void setmDescriptionRelationship(String mDescriptionRelationship) {
        this.mDescriptionRelationship = mDescriptionRelationship;
    }

    public Role getmSecondUser() {
        return mSecondUser;
    }

    public void setmSecondUser(Role mSecondUser) {
        this.mSecondUser = mSecondUser;
    }
}
