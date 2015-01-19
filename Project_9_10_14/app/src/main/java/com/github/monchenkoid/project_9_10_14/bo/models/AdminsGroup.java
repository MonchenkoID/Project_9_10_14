package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Irina Monchenko on 18.01.2015.
 */
public class AdminsGroup {

    List<UniqueAdmin> mAdmins = new LinkedList<>();

    public List<UniqueAdmin> getAdmins() {
        return new LinkedList<>(mAdmins);
    }

    public void addAdmin(UniqueAdmin mAdmin) {
        this.mAdmins.add(mAdmin);
    }


}
