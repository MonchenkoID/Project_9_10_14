package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.Date;

/**
 * Created by Irina Monchenko on 24.12.2014.
 */
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String state;
    private String countryNatale;
    private String cityNatale;
    private String gender;
    private Date userDateBirthday;
    private Role role;
    private TIM timObject;

    public User() {

    }

    public User(Long id, String name, String lastName, String state, String countryNatale, String cityNatale,
                String gender, Date userDateBirthday, Role role, TIM timObject) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.state = state;
        this.countryNatale = countryNatale;
        this.cityNatale = cityNatale;
        this.gender = gender;
        this.userDateBirthday = userDateBirthday;
        this.role = role;
        this.timObject = timObject;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TIM getTimObject() {
        return timObject;
    }

    public void setTimObject(TIM timObject) {
        this.timObject = timObject;
    }
}
