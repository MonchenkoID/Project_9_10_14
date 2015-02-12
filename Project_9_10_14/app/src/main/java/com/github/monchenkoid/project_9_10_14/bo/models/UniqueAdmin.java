package com.github.monchenkoid.project_9_10_14.bo.models;

import java.util.List;

/**
 * Created by Irina Monchenko on 17.01.2015.
 */
public class UniqueAdmin extends User
{

	private Long id;

	private String mEmail;

	private List<Relationship> mRelationships;

	public UniqueAdmin(String mEmail, List<Relationship> mRelationships)
	{
		this.mEmail = mEmail;

		this.mRelationships = mRelationships;
	}

	public UniqueAdmin()
	{
		mEmail = "";
		mRelationships = null;
	}

	public String getmEmail()
	{
		return mEmail;
	}

	public void setmEmail(String mEmail)
	{
		this.mEmail = mEmail;
	}

	public List<Relationship> getmRelationships()
	{
		return mRelationships;
	}

	public void setmRelationships(List<Relationship> mRelationships)
	{
		this.mRelationships = mRelationships;
	}
}
