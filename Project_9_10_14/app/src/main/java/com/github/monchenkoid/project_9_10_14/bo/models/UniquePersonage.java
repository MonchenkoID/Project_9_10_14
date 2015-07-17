package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * @author Iryna Monchenko
 * @version on 17.01.2015
 */

public class UniquePersonage {

    private Long mId;
    private String mMedia;
    private String mPersonaName;
    private List<Relationship> mRelationships;

    public UniquePersonage(String media, String personaName, List<Relationship> relationships) {
        this.mMedia = media;
        this.mPersonaName = personaName;
        this.mRelationships = relationships;
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

    public List<Relationship> getRelationships() {
        return mRelationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.mRelationships = relationships;
    }
}
