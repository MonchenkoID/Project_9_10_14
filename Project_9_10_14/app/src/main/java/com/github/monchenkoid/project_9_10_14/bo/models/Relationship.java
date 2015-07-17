package com.github.monchenkoid.project_9_10_14.bo.models;

/**
 * @author Iryna Monchenko
 * @version on 17.01.2015
 */

public class Relationship {

    private Long mId;
    private String mTypeRelationship;
    private String mNameRelationship;
    private String mDescriptionRelationship;
    private Role mSecondUser;

  /*  public Relationship(Long id, String typeRelationship, String nameRelationship,
                        String descriptionRelationship, Role secondUser) {
		this.mId = id;
        this.mTypeRelationship = typeRelationship;
        this.mNameRelationship = nameRelationship;
        this.mDescriptionRelationship = descriptionRelationship;
        this.mSecondUser = secondUser;
    }*/

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
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

    public String getDescriptionRelationship() {
        return mDescriptionRelationship;
    }

    public void setDescriptionRelationship(String descriptionRelationship) {
        this.mDescriptionRelationship = descriptionRelationship;
    }

    public Role getSecondUser() {
        return mSecondUser;
    }

    public void setSecondUser(Role secondUser) {
        this.mSecondUser = secondUser;
    }
}
