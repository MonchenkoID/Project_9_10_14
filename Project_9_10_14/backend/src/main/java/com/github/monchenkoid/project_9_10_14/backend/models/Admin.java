package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 @author Iryna Monchenko
 @version on 05.03.2015
 */

public class Admin extends Person {

    private Long mId;
    private String mEmail;
    private Long mPersonId;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public Long getPersonId() {
        return mPersonId;
    }

    public void setPersonId(Long personId) {
        this.mPersonId = personId;
    }
}
