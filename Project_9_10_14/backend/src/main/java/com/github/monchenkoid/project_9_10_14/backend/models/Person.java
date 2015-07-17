package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 @author Iryna Monchenko
 @version on 05.03.2015
 */

public class Person extends Entity {

    private Long mId;

    private String mName;

    private String mState;

    private String mAddress;

    private String mGender;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        this.mState = state;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        this.mGender = gender;
    }
}
