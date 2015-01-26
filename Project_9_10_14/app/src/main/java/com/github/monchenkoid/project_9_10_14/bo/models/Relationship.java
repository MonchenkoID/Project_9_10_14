package com.github.monchenkoid.project_9_10_14.bo.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class Relationship implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeLong(mId);
        }
        dest.writeString(mTypeRelationship);
        dest.writeString(mNameRelationship);
        dest.writeString(mDescriptionRelationship);
        dest.writeValue(mSecondUser);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Relationship> CREATOR = new Parcelable.Creator<Relationship>() {
        @Override
        public Relationship createFromParcel(Parcel in) {
            return new Relationship(in);
        }

        @Override
        public Relationship[] newArray(int size) {
            return new Relationship[size];
        }
    };
}