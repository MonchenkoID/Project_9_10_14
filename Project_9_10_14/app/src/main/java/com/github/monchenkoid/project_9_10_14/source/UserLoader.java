package com.github.monchenkoid.project_9_10_14.source;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;

/**
 * Created by shiza on 01.02.2015.
 */
public class UserLoader extends CursorLoader
{
	public static final String ARGS_USER_ID = "userId";

	public UserLoader(Context context)
	{
		super(context);
	}

	/*public UserLoader(Context context, Bundle args)
	{
		super(context,
				UsersContract.CONTENT_URI,//extends ... BaseContract implements BaseColumns
				UsersContract.COLUMNS,                      //projection
				UsersContract.COLUMN_USER_ID + " = ?",           //selection
				new String[]{args.getString(ARGS_USER_ID)}, //selectionArgs
				null);                                      //sortOrder

	}*/
}