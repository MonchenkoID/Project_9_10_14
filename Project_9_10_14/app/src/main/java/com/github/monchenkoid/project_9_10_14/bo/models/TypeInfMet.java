package com.github.monchenkoid.project_9_10_14.bo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import static com.github.monchenkoid.project_9_10_14.utils.Constants.*;

/**
 * Created by Irina Monchenko on 18.01.2015.
 */

public class TypeInfMet //extends JSONObjectWrapper
{

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

	/*
		public static final Parcelable.Creator<TypeInfMet> CREATOR
				= new Parcelable.Creator<TypeInfMet>() {
			public TypeInfMet createFromParcel(Parcel in) {
				return new TypeInfMet(in);
			}

			public TypeInfMet[] newArray(int size) {
				return new TypeInfMet[size];
			}
		};

		public TypeInfMet(String jsonObject) {
			super(jsonObject);
		}

		public TypeInfMet(JSONObject jsonObject) {
			super(jsonObject);
		}

		protected TypeInfMet(Parcel in) {
			super(in);
		}*/
	public TypeInfMet()
	{
	}

	public TypeInfMet(Long mId, ArrayList<String> mName, ArrayList<String> mDiUng, ArrayList<String> mReign,
					  ArrayList<String> mModelA, List<Relationship> mRelationships)
	{

		this.mId = mId;
		this.mName = mName;
		this.mDiUng = mDiUng;
		this.mReign = mReign;
		this.mModelA = mModelA;
		this.mRelationships = mRelationships;

	}

	public Long getId()
	{
		return mId;
	}

	public void setId(Long mId)
	{
		this.mId = mId;
	}

	public ArrayList<String> getName()
	{
		return mName;
	}

	public void setName(ArrayList<String> mName)
	{
		this.mName = mName;
	}

	public ArrayList<String> getDiUng()
	{
		return mDiUng;
	}

	public void setDiUng(ArrayList<String> mDiUng)
	{
		this.mDiUng = mDiUng;
	}

	public ArrayList<String> getReign()
	{
		return mReign;
	}

	public void setReign(ArrayList<String> mReign)
	{
		this.mReign = mReign;
	}

	public ArrayList<String> getModelA()
	{
		return mModelA;
	}

	public void setModelA(ArrayList<String> mModelA)
	{
		this.mModelA = mModelA;
	}

	public List<Relationship> getRelationships()
	{
		return mRelationships;
	}

	public void setRelationships(List<Relationship> mRelationships)
	{
		this.mRelationships = mRelationships;
	}

}
