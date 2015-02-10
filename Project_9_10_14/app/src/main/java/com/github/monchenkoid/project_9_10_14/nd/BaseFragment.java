package com.github.monchenkoid.project_9_10_14.nd;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.R;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by shiza on 01.02.2015.
 */
public abstract class BaseFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>
{

	private View mProgress;
	private View mRetryLoad;
	private View mMainContainer;
	private View mEmptyData;
	private SwipeRefreshLayout mSwipeRefreshLayout;
	public static final String ARGS_USER_ID = "BaseFragment.userId";


	protected abstract int getLayoutId();

	protected abstract Loader<Cursor> createLoader(Bundle args);

	protected abstract int getFragmentTitleResource();

	private AtomicBoolean mIsNetworkLoading = new AtomicBoolean(false);

	protected abstract void onLoadCursorFinished(Cursor cursor);

	protected abstract int buildLoaderId();

	protected abstract Bundle prepareLoaderBundle();

	public interface Builder
	{
		Fragment build();
	}

	@Override//method to fragment
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(getLayoutId(), container, false);
		//	FragmentActivity activity = getActivity();
		//mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
		mProgress = view.findViewById(android.R.id.progress);
		mRetryLoad = view.findViewById(R.id.layout_no_connection);
		mEmptyData = view.findViewById(R.id.layout_no_data);
		mMainContainer = view.findViewById(R.id.main_container);
		if (mSwipeRefreshLayout != null)
		{
			mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
			{
				@Override
				public void onRefresh()
				{
					onSwipeRefresh();
				}
			});
		}
		View buttonView = view.findViewById(R.id.button_retry);
		buttonView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				onRetryClick();
			}
		});
		return view;
	}

	@Override//method to fragment
	public void onStart()
	{
		super.onStart();

		ActionBar actionBar = getActionBar();
		if (actionBar != null)
		{
			actionBar.setTitle(getFragmentTitleResource());
		}
	}

	@Override//method to LoaderManager
	public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
	{
		return createLoader(bundle);
	}

	@Override//method to LoaderManager
	public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor)
	{
		showLoad(mIsNetworkLoading.get());

		if ((cursor == null || cursor.getCount() == 0) && !mIsNetworkLoading.get())
		{
			mEmptyData.setVisibility(View.VISIBLE);
		}
		else
		{
			mEmptyData.setVisibility(View.GONE);
			onLoadCursorFinished(cursor);
		}
	}

	@Override//method to LoaderManager
	public void onLoaderReset(Loader<Cursor> cursorLoader)
	{
		showLoad(true);
	}

	protected void showLoad(boolean state)
	{
		mProgress.setVisibility(state ? View.VISIBLE : View.GONE);
		if (mMainContainer != null)
		{
			mMainContainer.setVisibility(state ? View.GONE : View.VISIBLE);
		}
		mRetryLoad.setVisibility(View.GONE);
		mEmptyData.setVisibility(View.GONE);
	}

	protected ActionBar getActionBar()
	{
		Activity activity = getActivity();
		if (activity == null)
		{
			return null;
		}
		return ((ActionBarActivity) activity).getSupportActionBar();
	}

	protected void onSwipeRefresh()
	{
		reloadData();
	}

	protected void onRetryClick()
	{
		reloadData();
	}

	protected SwipeRefreshLayout getSwipeRefreshLayout()
	{
		return mSwipeRefreshLayout;
	}

	protected void prepareLoader(boolean needRestart)
	{
		prepareLoader(needRestart, this);
	}

	protected void prepareLoader(boolean needRestart, LoaderManager.LoaderCallbacks<Cursor> callback)
	{
		showLoad(true);
		if (needRestart)
		{
			getLoaderManager().restartLoader(buildLoaderId(), prepareLoaderBundle(), callback);
		}
		else
		{
			getLoaderManager().initLoader(buildLoaderId(), prepareLoaderBundle(), callback);
		}
	}

	protected void reloadData()
	{
	}

	protected String getArgsUserId()
	{
		return getArgsStringByName(ARGS_USER_ID);
	}

	protected String getArgsStringByName(String name)
	{
		return getArgsByName(name);
	}

	protected <T> T getArgsByName(String name)
	{
		Bundle arguments = getArguments();
		if (arguments != null)
		{
			Object argResult = arguments.get(name);
			//noinspection unchecked
			return (T) argResult;       //may be throw ClassCastException
		}
		return null;
	}
}
