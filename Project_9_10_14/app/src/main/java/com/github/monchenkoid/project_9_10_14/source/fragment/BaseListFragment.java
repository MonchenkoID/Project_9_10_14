package com.github.monchenkoid.project_9_10_14.source.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * Created by shiza on 01.02.2015.
 */
public abstract class BaseListFragment extends BaseFragment implements ListView.OnScrollListener,
		AdapterView.OnItemClickListener
{

	private ListView mListView;
	private int mLastVisibleIndex;
	private int mOffsetTop;
	private boolean mIsRequestNewData = false;
	private static final String SCROLL_POSITION = "SCROLL_POSITION";
	private static final String SCROLL_POSITION_SHIFT = "SCROLL_POSITION_SHIFT";


	protected abstract CursorAdapter getNewListAdapter(Cursor cursor);

	protected ListView getListView()
	{
		return mListView;
	}

	protected int getListViewId()
	{
		return android.R.id.list;
	}

	@Override//BaseFragment
	protected void onLoadCursorFinished(Cursor cursor)
	{
		//Log.d("BaseListFragment", "onLoadCursorFinished set sel:" + mIsReversedList + " " + mIsRequestNewData);
		FragmentActivity activity = getActivity();
		if (activity != null && cursor != null)
		{
			CursorAdapter adapter = (CursorAdapter) mListView.getAdapter();
			if (adapter == null)
			{
				adapter = getNewListAdapter(cursor);
				mListView.setAdapter(adapter);
			}
			else
			{
				adapter.changeCursor(cursor);
				adapter.notifyDataSetChanged();
			}

			if (mLastVisibleIndex != 0)
			{
				mListView.setSelectionFromTop(mLastVisibleIndex, mOffsetTop);
				mLastVisibleIndex = 0;
			}
		}
		mIsRequestNewData = false;
	}

	@Override//AbsListView
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
	{
		ListAdapter adapter = view.getAdapter();
		if (adapter == null)
		{
			return;
		}
		int count = adapter.getCount();
		if (count == 0)
		{
			return;
		}
		SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
		if (swipeRefreshLayout != null)
		{
			//get shift from top for first visible item - if >=0 scroll position in top
			ListView listView = getListView();
			int topRowVerticalPosition =
					(listView == null || listView.getChildCount() == 0)
							? 0
							: listView.getChildAt(0).getTop();
			//firstVisibleItem == 0 if first item from list visible in screen
			//topRowVerticalPosition - shift for first visible item from top of ListView
			swipeRefreshLayout.setEnabled(firstVisibleItem == 0 && topRowVerticalPosition >= 0);
		}
	}

	@Override//method to fragment
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		mListView = (ListView) view.findViewById(getListViewId());
		if (mListView == null)
		{
			throw new IllegalStateException("Did not override getListViewId, or getListViewId return invalid ListView id");
		}
		mListView.setOnScrollListener(this);
		mListView.setOnItemClickListener(this);

		if (savedInstanceState != null)
		{
			prepareLoader(false);
			mLastVisibleIndex = savedInstanceState.getInt(SCROLL_POSITION, 0);
			mOffsetTop = savedInstanceState.getInt(SCROLL_POSITION_SHIFT, 0);
		}
		else
		{
			prepareLoader(true);
			reloadData();
		}

		return view;
	}

	@Override//method to fragment
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);

		//here we get first visible item in ListView
		int firstVisiblePosition = mListView.getFirstVisiblePosition();
		outState.putInt(SCROLL_POSITION, firstVisiblePosition);

		//here we get View of Top view. this view can be visible not full
		View view = mListView.getChildAt(0);
		outState.putInt(SCROLL_POSITION_SHIFT, (view == null) ? 0 : view.getTop());
	}


}
