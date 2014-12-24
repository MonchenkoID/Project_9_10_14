package com.github.monchenkoid.project_9_10_14.backend;


import java.util.Date;

/**
 * Created by Irina Monchenko on 23.12.2014.
 */
public class UserBean/*TODO implements Serializable*/ {

    //  static final long serialVersionUID = 10275539472837495L;
    private Long id;
    private String name;
    private String lastName;
    private String state;
    private String countryNatale;
    private String cityNatale;
    private String gender;
    private Date userDateBirthday;
    private TIMBean userTIM;

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

    public TIMBean getUserTIM() {
        return userTIM;
    }

    public void setUserTIM(TIMBean userTIM) {
        this.userTIM = userTIM;
    }
}
