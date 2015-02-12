package com.github.monchenkoid.project_9_10_14.bo.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.monchenkoid.project_9_10_14.bo.JSONObjectWrapper;
import org.json.JSONObject;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class Relationship extends JSONObjectWrapper
{

	private Long mId;

	private String mTypeRelationship;

	private String mNameRelationship;

	private String mDescriptionRelationship;

	private Role mSecondUser;

	public static final Parcelable.Creator<Relationship> CREATOR
			= new Parcelable.Creator<Relationship>()
	{
		public Relationship createFromParcel(Parcel in)
		{
			return new Relationship(in);
		}

		public Relationship[] newArray(int size)
		{
			return new Relationship[size];
		}
	};

	public Relationship(String jsonObject)
	{
		super(jsonObject);
	}

	public Relationship(JSONObject jsonObject)
	{
		super(jsonObject);
	}

	protected Relationship(Parcel in)
	{
		super(in);
	}

  /*  public Relationship(Long id, String typeRelationship, String nameRelationship,
						String descriptionRelationship, Role secondUser) {
		this.mId = id;
        this.mTypeRelationship = typeRelationship;
        this.mNameRelationship = nameRelationship;
        this.mDescriptionRelationship = descriptionRelationship;
        this.mSecondUser = secondUser;
    }*/

	public Long getId()
	{
		return mId;
	}

	public void setId(Long id)
	{
		this.mId = id;
	}

	public String getTypeRelationship()
	{
		return mTypeRelationship;
	}

	public void setTypeRelationship(String typeRelationship)
	{
		this.mTypeRelationship = typeRelationship;
	}

	public String getNameRelationship()
	{
		return mNameRelationship;
	}

	public void setNameRelationship(String nameRelationship)
	{
		this.mNameRelationship = nameRelationship;
	}

	public String getDescriptionRelationship()
	{
		return mDescriptionRelationship;
	}

	public void setDescriptionRelationship(String descriptionRelationship)
	{
		this.mDescriptionRelationship = descriptionRelationship;
	}

	public Role getSecondUser()
	{
		return mSecondUser;
	}

	public void setSecondUser(Role secondUser)
	{
		this.mSecondUser = secondUser;
	}
/*
	protected Relationship(Parcel in) {
        mId = in.readByte() == 0x00 ? null : in.readLong();
        mTypeRelationship = in.readString();
        mNameRelationship = in.readString();
        mDescriptionRelationship = in.readString();
        mSecondUser = (Role) in.readValue(Role.class.getClassLoader());
    }
*/

}
