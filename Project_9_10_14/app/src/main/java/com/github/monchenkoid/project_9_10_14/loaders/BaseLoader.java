package com.github.monchenkoid.project_9_10_14.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Monchenko Irina on 4/30/2014.
 */
public abstract class BaseLoader<T> extends AsyncTaskLoader<T>
{
	private static final String TAG = BaseLoader.class.getSimpleName();
	private T mData;

	public BaseLoader(Context ctx)
	{
		super(ctx);
	}

	@Override
	public T loadInBackground()
	{
		T data = null;

		try
		{
			data = retrieveResponse();
		}
		catch (Exception e)
		{
			Log.e(TAG, e.toString(), e);
		}

		return data;
	}

	protected abstract T retrieveResponse() throws SQLException, IOException;

	@Override
	public void deliverResult(T data)
	{
		if (isReset())
		{
			releaseResources(data);
			return;
		}

		T oldData = mData;
		mData = data;

		if (isStarted())
		{
			super.deliverResult(data);
		}

		if (oldData != null && oldData != data)
		{
			releaseResources(oldData);
		}
	}

	@Override
	protected void onStartLoading()
	{
		if (mData != null)
		{
			deliverResult(mData);
		}

		// TODO: register the observer

		if (takeContentChanged() || mData == null)
		{
			forceLoad();
		}
	}

	@Override
	protected void onStopLoading()
	{
		cancelLoad();
	}

	@Override
	protected void onReset()
	{
		onStopLoading();

		if (mData != null)
		{
			releaseResources(mData);
			mData = null;
		}
		// TODO: unregister the observer
	}

	@Override
	public void onCanceled(T data)
	{
		super.onCanceled(data);
		releaseResources(data);
	}

	private void releaseResources(T data)
	{
	}

}
