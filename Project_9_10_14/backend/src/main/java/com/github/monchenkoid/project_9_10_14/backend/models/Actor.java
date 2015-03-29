package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 * Created by shiza on 05.03.2015.
 */
public class Actor extends Person {

    private Long mId;

    private String mMedia;

    private String mPersonaName;

    private Long mPersonId;

    private Long mTimId;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public String getMedia() {
        return mMedia;
    }

    public void setMedia(String media) {
        this.mMedia = media;
    }

    public String getPersonaName() {
        return mPersonaName;
    }

    public void setPersonaName(String personaName) {
        this.mPersonaName = personaName;
    }

    public Long getPersonId() {
        return mPersonId;
    }

    public void setPersonId(Long personId) {
        this.mPersonId = personId;
    }

    public Long getTimId() {
        return mTimId;
    }

    public void setTimId(Long timId) {
        this.mTimId = timId;
    }
}
