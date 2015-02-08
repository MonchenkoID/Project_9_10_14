package com.github.monchenkoid.project_9_10_14.source.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.github.monchenkoid.project_9_10_14.R;

/**
 * Created by shiza on 02.02.2015.
 */
public class FriendsPagerAdapter extends FragmentStatePagerAdapter
{
	private static final int FRIEND_FRAGMENT_TAB_COUNT = 2;
	private String mUserId;
	private String mAll;
	private String mOnline;

	public FriendsPagerAdapter(FragmentManager fragmentManager, Context context, String userId)
	{
		super(fragmentManager);

		mUserId = userId;
		mAll = context.getString(R.string.fragment_wall);
		mOnline = context.getString(R.string.clear);
	}

	@Override
	public Fragment getItem(int position)
	{
		return null;
	}

	@Override
	public int getCount()
	{
		return 0;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if (position == 0) {
			return mAll;
		} else {
			return mOnline;
		}
	}

}
