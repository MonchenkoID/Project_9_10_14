package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * @author Iryna Monchenko
 * @version on 17.01.2015
 */

public class UniqueAnalized extends User {

    private Long mId;
    private int mAgeDefinition;
    private String mCityDefinition;
    private String mSocialAddress;
    private List<Relationship> mRelationships;

    public UniqueAnalized(int ageDefinition, String cityDefinition, String socialAddress,
                          List<Relationship> relationships) {

        this.mAgeDefinition = ageDefinition;
        this.mCityDefinition = cityDefinition;
        this.mSocialAddress = socialAddress;
        this.mRelationships = relationships;
    }

    public UniqueAnalized() {
        mAgeDefinition = 1;
        mCityDefinition = "Гродно";
        mSocialAddress = "vk.com";
        mRelationships = null;
    }

    public int getAgeDefinition() {
        return mAgeDefinition;
    }

    public void setAgeDefinition(int ageDefinition) {
        this.mAgeDefinition = ageDefinition;
    }

    public String getCityDefinition() {
        return mCityDefinition;
    }

    public void setCityDefinition(String cityDefinition) {
        this.mCityDefinition = cityDefinition;
    }

    public String getSocialAddress() {
        return mSocialAddress;
    }

    public void setSocialAddress(String socialAddress) {
        this.mSocialAddress = socialAddress;
    }

    public List<Relationship> getRelationships() {
        return mRelationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.mRelationships = relationships;
    }
}
