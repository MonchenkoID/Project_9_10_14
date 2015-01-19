package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class UniqueAnalized extends User {

    private int mAgeDefinition;
    private String mCityDefinition;
    private String mSocialAddress;
    private List<Relationship> mRelationships;

    public UniqueAnalized(int mAgeDefinition, String mCityDefinition, String mSocialAddress, List<Relationship> mRelationships) {

        this.mAgeDefinition = mAgeDefinition;
        this.mCityDefinition = mCityDefinition;
        this.mSocialAddress = mSocialAddress;
        this.mRelationships = mRelationships;
    }

    public UniqueAnalized() {
        mAgeDefinition = 1;
        mCityDefinition = "Гродно";
        mSocialAddress = "vk.com";
        mRelationships = null;
    }

    public int getmAgeDefinition() {
        return mAgeDefinition;
    }

    public void setmAgeDefinition(int mAgeDefinition) {
        this.mAgeDefinition = mAgeDefinition;
    }

    public String getmCityDefinition() {
        return mCityDefinition;
    }

    public void setmCityDefinition(String mCityDefinition) {
        this.mCityDefinition = mCityDefinition;
    }

    public String getmSocialAddress() {
        return mSocialAddress;
    }

    public void setmSocialAddress(String mSocialAddress) {
        this.mSocialAddress = mSocialAddress;
    }

    public List<Relationship> getmRelationships() {
        return mRelationships;
    }

    public void setmRelationships(List<Relationship> mRelationships) {
        this.mRelationships = mRelationships;
    }
}
