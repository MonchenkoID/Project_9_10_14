package com.github.monchenkoid.project_9_10_14.utils;

/**
 * Created by Irina Monchenko on 18.01.2015.
 */

public final class Log
{

	private Log()
	{
	}

	public static void d(String mNameClass, String mMessage)
	{
		if (!Constants.IS_SHOW_LOGS)
		{
			android.util.Log.d(mNameClass, mMessage);
		}
	}

	public static void i(String mNameClass, String mMessage)
	{
		if (!Constants.IS_SHOW_LOGS)
		{
			android.util.Log.i(mNameClass, mMessage);
		}
	}


}
