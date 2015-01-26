package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class UniquePersonage {

    private Long id;

    private String media;

    private String personaName;

    private List<Relationship> relationships;

    public UniquePersonage(String media, String personaName, List<Relationship> relationships) {
        this.media = media;
        this.personaName = personaName;
        this.relationships = relationships;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }
}
