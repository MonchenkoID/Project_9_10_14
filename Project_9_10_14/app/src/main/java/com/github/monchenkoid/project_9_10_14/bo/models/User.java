package com.github.monchenkoid.project_9_10_14.bo.models;

/**
 * @author Iryna Monchenko
 * @version on 24.12.2014
 */

public abstract class User {

    private Long mId;
    private String mName;
    private String mState;
    private String mAddress;
    private String mGender;
    private Role mRole;
    private TypeInfMet mTypeInfMetObject;

    public User() {

    }

    public User(Long id, String name, String state, String address,
                String gender, Role role, TypeInfMet typeInfMetObject) {
        this.mId = id;
        this.mName = name;
        this.mState = state;
        this.mAddress = address;
        this.mGender = gender;
        this.mRole = role;
        this.mTypeInfMetObject = typeInfMetObject;
    }

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

    public Role getRole() {
        return mRole;
    }

    public void setRole(Role role) {
        this.mRole = role;
    }

    public TypeInfMet getTypeInfMetObject() {
        return mTypeInfMetObject;
    }

    public void setTypeInfMetObject(TypeInfMet typeInfMetObject) {
        this.mTypeInfMetObject = typeInfMetObject;
    }
}
