package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Irina Monchenko on 19.01.2015.
 */
public class TIMGroup {


    List<TIM> mTIMs = new LinkedList<>();

    public List<TIM> getAdmins() {
        return new LinkedList<>(mTIMs);
    }

    public void addTIM(TIM mTIM) {
        this.mTIMs.add(mTIM);
    }


}

