package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class PersonagesGroup {

    private List<UniquePersonage> mPersonages;

    public PersonagesGroup() {

    }

    public PersonagesGroup(List<UniquePersonage> mPersonages) {
        this.mPersonages = mPersonages;
    }

    public List<UniquePersonage> getPersonages() {
        return mPersonages;
    }

    public void setPersonages(List<UniquePersonage> personages) {
        this.mPersonages = mPersonages;
    }
}
