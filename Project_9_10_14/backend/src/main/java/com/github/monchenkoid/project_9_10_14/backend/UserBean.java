package com.github.monchenkoid.project_9_10_14.backend;


import java.util.Date;

/**
 * Created by Irina Monchenko on 23.12.2014.
 */
public class UserBean/*TODO implements Serializable*/ {

    //  static final long serialVersionUID = 10275539472837495L;
    private static Long id;
    private static String name;
    private static String lastName;
    private static String state;
    private static String countryNatale;
    private static String cityNatale;
    private static String gender;
    private static Date userDateBirthday;
    private static TIMBean userTIM;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        UserBean.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        UserBean.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        UserBean.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        UserBean.state = state;
    }

    public String getCountryNatale() {
        return countryNatale;
    }

    public void setCountryNatale(String countryNatale) {
        UserBean.countryNatale = countryNatale;
    }

    public String getCityNatale() {
        return cityNatale;
    }

    public void setCityNatale(String cityNatale) {
        UserBean.cityNatale = cityNatale;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        UserBean.gender = gender;
    }

    public Date getUserDateBirthday() {
        return userDateBirthday;
    }

    public void setUserDateBirthday(Date userDateBirthday) {
        UserBean.userDateBirthday = userDateBirthday;
    }

    public TIMBean getUserTIM() {
        return userTIM;
    }

    public void setUserTIM(TIMBean userTIM) {
        UserBean.userTIM = userTIM;
    }
}
