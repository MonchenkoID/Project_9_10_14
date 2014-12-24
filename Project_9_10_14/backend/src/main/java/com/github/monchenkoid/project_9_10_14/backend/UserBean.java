package com.github.monchenkoid.project_9_10_14.backend;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Irina Monchenko on 23.12.2014.
 */
public class UserBean implements Serializable{

    static final long serialVersionUID = 10275539472837495L;
    private static Long id;
    private static String name;
    private static String lastName;
    private static String state;
    private static String countryNatale;
    private static String cityNatale;
    private static String gender;
    private static Date userDateBirthday;
    private static TIMBean userTIM;

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        UserBean.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserBean.name = name;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        UserBean.lastName = lastName;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        UserBean.state = state;
    }

    public static String getCountryNatale() {
        return countryNatale;
    }

    public static void setCountryNatale(String countryNatale) {
        UserBean.countryNatale = countryNatale;
    }

    public static String getCityNatale() {
        return cityNatale;
    }

    public static void setCityNatale(String cityNatale) {
        UserBean.cityNatale = cityNatale;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        UserBean.gender = gender;
    }

    public static Date getUserDateBirthday() {
        return userDateBirthday;
    }

    public static void setUserDateBirthday(Date userDateBirthday) {
        UserBean.userDateBirthday = userDateBirthday;
    }

    public static TIMBean getUserTIM() {
        return userTIM;
    }

    public static void setUserTIM(TIMBean userTIM) {
        UserBean.userTIM = userTIM;
    }
}
