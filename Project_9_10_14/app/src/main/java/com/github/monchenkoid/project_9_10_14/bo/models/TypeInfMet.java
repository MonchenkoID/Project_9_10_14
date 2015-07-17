package com.github.monchenkoid.project_9_10_14.bo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import static com.github.monchenkoid.project_9_10_14.utils.Constants.KEY_TIM_ID;
import static com.github.monchenkoid.project_9_10_14.utils.Constants.KEY_TIM_MODEL_A;
import static com.github.monchenkoid.project_9_10_14.utils.Constants.KEY_TIM_NAME;
import static com.github.monchenkoid.project_9_10_14.utils.Constants.KEY_TIM_REIGN;
import static com.github.monchenkoid.project_9_10_14.utils.Constants.KEY_TIM_RELATIONSHIPS;
import static com.github.monchenkoid.project_9_10_14.utils.Constants.KEY_TIM_UNG;

/**
 * @author Iryna Monchenko
 * @version on 18.01.2015
 */

public class TypeInfMet {

    @SerializedName(KEY_TIM_ID)
    private Long mId;
    @SerializedName(KEY_TIM_NAME)
    private ArrayList<String> mName;
    @SerializedName(KEY_TIM_UNG)
    private ArrayList<String> mDiUng;
    @SerializedName(KEY_TIM_REIGN)
    private ArrayList<String> mReign;
    @SerializedName(KEY_TIM_MODEL_A)
    private ArrayList<String> mModelA;
    @SerializedName(KEY_TIM_RELATIONSHIPS)
    private List<Relationship> mRelationships;

    public TypeInfMet() {
    }

    public TypeInfMet(Long id, ArrayList<String> name, ArrayList<String> diUng, ArrayList<String> reign,
                      ArrayList<String> modelA, List<Relationship> relationships) {

        this.mId = id;
        this.mName = name;
        this.mDiUng = diUng;
        this.mReign = reign;
        this.mModelA = modelA;
        this.mRelationships = relationships;

    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public ArrayList<String> getName() {
        return mName;
    }

    public void setName(ArrayList<String> name) {
        this.mName = name;
    }

    public ArrayList<String> getDiUng() {
        return mDiUng;
    }

    public void setDiUng(ArrayList<String> diUng) {
        this.mDiUng = diUng;
    }

    public ArrayList<String> getReign() {
        return mReign;
    }

    public void setReign(ArrayList<String> reign) {
        this.mReign = reign;
    }

    public ArrayList<String> getModelA() {
        return mModelA;
    }

    public void setModelA(ArrayList<String> modelA) {
        this.mModelA = modelA;
    }

    public List<Relationship> getRelationships() {
        return mRelationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.mRelationships = relationships;
    }

}
