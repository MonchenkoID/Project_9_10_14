package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * @author Iryna Monchenko
 * @version on 17.01.2015
 */

public class UniqueAdmin extends User {

    private Long mId;
    private String mEmail;
    private List<Relationship> mRelationships;

    public UniqueAdmin(String email, List<Relationship> relationships) {
        this.mEmail = email;
        this.mRelationships = relationships;
    }

    public UniqueAdmin() {
        mEmail = "";
        mRelationships = null;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public List<Relationship> getRelationships() {
        return mRelationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.mRelationships = relationships;
    }
}
