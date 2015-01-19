package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Irina Monchenko on 18.01.2015.
 */
public class AnalizedGroup {

    List<UniqueAnalized> mAnalizedGroup = new LinkedList<>();

    public List<UniqueAnalized> getAnalizedGroup() {
        return new LinkedList<>(mAnalizedGroup);
    }

    public void addAnalized(UniqueAnalized mAnalized) {
        this.mAnalizedGroup.add(mAnalized);
    }


}