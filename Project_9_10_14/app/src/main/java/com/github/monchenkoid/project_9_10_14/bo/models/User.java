package com.github.monchenkoid.project_9_10_14.bo.models;


/**
 * Created by Irina Monchenko on 24.12.2014.
 */
public abstract class User {

    private Long id;

    private String mName;

    private String mState;

    private String mAddress;

    private String mGender;

    private Role mRole;

    private TypeInfMet mTypeInfMetObject;

    public User() {

    }

    public User(Long id, String mName, String mState, String mAddress,
                String mGender, Role mRole, TypeInfMet mTypeInfMetObject) {
        this.id = id;
        this.mName = mName;
        this.mState = mState;
        this.mAddress = mAddress;
        this.mGender = mGender;
        this.mRole = mRole;
        this.mTypeInfMetObject = mTypeInfMetObject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getState() {
        return mState;
    }

    public void setState(String mState) {
        this.mState = mState;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String mGender) {
        this.mGender = mGender;
    }

    public Role getRole() {
        return mRole;
    }

    public void setRole(Role mRole) {
        this.mRole = mRole;
    }

    public TypeInfMet getTypeInfMetObject() {
        return mTypeInfMetObject;
    }

    public void setTypeInfMetObject(TypeInfMet mTypeInfMetObject) {
        this.mTypeInfMetObject = mTypeInfMetObject;
    }
}
