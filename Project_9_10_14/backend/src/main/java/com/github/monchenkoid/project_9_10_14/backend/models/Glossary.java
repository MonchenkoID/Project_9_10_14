package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 @author Iryna Monchenko
 @version on 05.03.2015
 */

public class Glossary extends Entity {

    private Long mId;
    private String mName;
    private String mDescription;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
