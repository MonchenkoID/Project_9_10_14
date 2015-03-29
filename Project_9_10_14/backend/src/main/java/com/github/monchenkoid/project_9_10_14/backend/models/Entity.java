package com.github.monchenkoid.project_9_10_14.backend.models;

/**
 * Created by shiza on 05.03.2015.
 */
public abstract class Entity {

    private Long mId;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }
}
