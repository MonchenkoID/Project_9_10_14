package com.github.monchenkoid.project_9_10_14.bo;

import java.util.Date;

/**
 * Created by Irina Monchenko on 24.12.2014.
 */
public class UserData /* TODO implements Parcelable*/ {
    private Long id;
    private String name;
    private String lastName;
    private String state;
    private String countryNatale;
    private String cityNatale;
    private String gender;
    private Date userDateBirthday;
    private String[] dichotomy = new String[3];
    private String[] traitsReinin = new String[10];
    private String[] modelA = new String[7];

    /*  TODO  public static final Parcelable.Creator<UserData> CREATOR
                = new Parcelable.Creator<UserData>() {
            public UserData createFromParcel(Parcel in) {
                return new UserData(in);
            }

            public UserData[] newArray(int size) {
                return new UserData[size];
            }
        };


        protected UserData(Parcel in) {
            super(in);
        }*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountryNatale() {
        return countryNatale;
    }

    public void setCountryNatale(String countryNatale) {
        this.countryNatale = countryNatale;
    }

    public String getCityNatale() {
        return cityNatale;
    }

    public void setCityNatale(String cityNatale) {
        this.cityNatale = cityNatale;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getUserDateBirthday() {
        return userDateBirthday;
    }

    public void setUserDateBirthday(Date userDateBirthday) {
        this.userDateBirthday = userDateBirthday;
    }

    public String[] getDichotomy() {
        return dichotomy;
    }

    public void setDichotomy(String[] dichotomy) {
        this.dichotomy = dichotomy;
    }

    public String[] getTraitsReinin() {
        return traitsReinin;
    }

    public void setTraitsReinin(String[] traitsReinin) {
        this.traitsReinin = traitsReinin;
    }

    public String[] getModelA() {
        return modelA;
    }

    public void setModelA(String[] modelA) {
        this.modelA = modelA;
    }
}
