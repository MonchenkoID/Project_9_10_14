package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 * Created by shiza on 05.03.2015.
 */
public class Relationship extends Entity {

    private Long mId;

    private Long mFromId;

    private Long mToId;

    private String mTypeRelationship;

    private String mNameRelationship;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public Long getFromId() {
        return mFromId;
    }

    public void setFromId(Long fromId) {
        this.mFromId = fromId;
    }

    public Long getToId() {
        return mToId;
    }

    public void setToId(Long toId) {
        this.mToId = toId;
    }

    public String getTypeRelationship() {
        return mTypeRelationship;
    }

    public void setTypeRelationship(String typeRelationship) {
        this.mTypeRelationship = typeRelationship;
    }

    public String getNameRelationship() {
        return mNameRelationship;
    }

    public void setNameRelationship(String nameRelationship) {
        this.mNameRelationship = nameRelationship;
    }
}
