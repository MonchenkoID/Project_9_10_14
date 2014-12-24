package com.github.monchenkoid.project_9_10_14.bo;

import java.util.Date;

/**
 * Created by Irina Monchenko on 24.12.2014.
 */
public class UserData /* TODO implements Parcelable*/ {
    private static Long id;
    private static String name;
    private static String lastName;
    private static String state;
    private static String countryNatale;
    private static String cityNatale;
    private static String gender;
    private static Date userDateBirthday;
    private static String[] dichotomy = new String[3];
    private static String[] traitsReinin = new String[10];
    private static String[] modelA = new String[7];

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
    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        UserData.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserData.name = name;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        UserData.lastName = lastName;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        UserData.state = state;
    }

    public static String getCountryNatale() {
        return countryNatale;
    }

    public static void setCountryNatale(String countryNatale) {
        UserData.countryNatale = countryNatale;
    }

    public static String getCityNatale() {
        return cityNatale;
    }

    public static void setCityNatale(String cityNatale) {
        UserData.cityNatale = cityNatale;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        UserData.gender = gender;
    }

    public static Date getUserDateBirthday() {
        return userDateBirthday;
    }

    public static void setUserDateBirthday(Date userDateBirthday) {
        UserData.userDateBirthday = userDateBirthday;
    }

    public static String[] getDichotomy() {
        return dichotomy;
    }

    public static void setDichotomy(String[] dichotomy) {
        UserData.dichotomy = dichotomy;
    }

    public static String[] getTraitsReinin() {
        return traitsReinin;
    }

    public static void setTraitsReinin(String[] traitsReinin) {
        UserData.traitsReinin = traitsReinin;
    }

    public static String[] getModelA() {
        return modelA;
    }

    public static void setModelA(String[] modelA) {
        UserData.modelA = modelA;
    }
}
