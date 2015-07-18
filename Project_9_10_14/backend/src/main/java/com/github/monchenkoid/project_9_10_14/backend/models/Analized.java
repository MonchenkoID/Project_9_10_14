package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 @author Iryna Monchenko
 @version on 05.03.2015
 */

public class Analized extends Person {

    private Long mId;
    private int mAgeDefinition;
    private String mCityDefinition;
    private String mSocialAddress;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
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
}
