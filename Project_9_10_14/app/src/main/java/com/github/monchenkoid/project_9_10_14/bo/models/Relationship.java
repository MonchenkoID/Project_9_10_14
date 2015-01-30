package com.github.monchenkoid.project_9_10_14.bo.models;

import android.os.Parcel;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class Relationship {

    private Long mId;

    private String mTypeRelationship;

    private String mNameRelationship;

    private String mDescriptionRelationship;

    private Role mSecondUser;

    public Relationship(Long id, String typeRelationship, String nameRelationship,
                        String descriptionRelationship, Role secondUser) {
        mId = id;
        mTypeRelationship = typeRelationship;
        mNameRelationship = nameRelationship;
        mDescriptionRelationship = descriptionRelationship;
        mSecondUser = secondUser;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTypeRelationship() {
        return mTypeRelationship;
    }

    public void setTypeRelationship(String typeRelationship) {
        mTypeRelationship = typeRelationship;
    }

    public String getNameRelationship() {
        return mNameRelationship;
    }

    public void setNameRelationship(String nameRelationship) {
        mNameRelationship = nameRelationship;
    }

    public String getDescriptionRelationship() {
        return mDescriptionRelationship;
    }

    public void setDescriptionRelationship(String descriptionRelationship) {
        mDescriptionRelationship = descriptionRelationship;
    }

    public Role getSecondUser() {
        return mSecondUser;
    }

    public void setSecondUser(Role secondUser) {
        mSecondUser = secondUser;
    }

    protected Relationship(Parcel in) {
        mId = in.readByte() == 0x00 ? null : in.readLong();
        mTypeRelationship = in.readString();
        mNameRelationship = in.readString();
        mDescriptionRelationship = in.readString();
        mSecondUser = (Role) in.readValue(Role.class.getClassLoader());
    }


}
