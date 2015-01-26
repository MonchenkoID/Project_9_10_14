package com.github.monchenkoid.project_9_10_14.bo.models;

import android.os.*;

import com.github.monchenkoid.project_9_10_14.processing.GsonSerializerProcessor;
import com.github.monchenkoid.project_9_10_14.utils.Log;
import com.google.gson.annotations.SerializedName;

import java.util.*;

import static com.github.monchenkoid.project_9_10_14.utils.Constants.*;

/**
 * Created by Irina Monchenko on 18.01.2015.
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

    public TypeInfMet(){

    }

        public TypeInfMet(Long mId, ArrayList<String> mName, ArrayList<String> mDiUng, ArrayList<String> mReign,
                          ArrayList<String> mModelA, List<Relationship> mRelationships) {

            this.mId = mId;
            this.mName = mName;
            this.mDiUng = mDiUng;
            this.mReign = mReign;
            this.mModelA = mModelA;
            this.mRelationships = mRelationships;

        }

        public Long getId() {
            return mId;
        }

        public void setId(Long mId) {
            this.mId = mId;
        }

        public ArrayList<String> getName() {
            return mName;
        }

        public void setName(ArrayList<String> mName) {
            this.mName = mName;
        }

        public ArrayList<String> getDiUng() {
            return mDiUng;
        }

        public void setDiUng(ArrayList<String> mDiUng) {
            this.mDiUng = mDiUng;
        }

        public ArrayList<String> getReign() {
            return mReign;
        }

        public void setReign(ArrayList<String> mReign) {
            this.mReign = mReign;
        }

        public ArrayList<String> getModelA() {
            return mModelA;
        }

        public void setModelA(ArrayList<String> mModelA) {
            this.mModelA = mModelA;
        }

        public List<Relationship> getRelationships() {
            return mRelationships;
        }

        public void setRelationships(List<Relationship> mRelationships) {
            this.mRelationships = mRelationships;
        }

    }