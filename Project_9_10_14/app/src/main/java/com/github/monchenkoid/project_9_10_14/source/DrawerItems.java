package com.github.monchenkoid.project_9_10_14.source;

import android.support.v4.app.Fragment;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.fragment.BaseFragment;
import com.github.monchenkoid.project_9_10_14.source.fragment.FriendsFragment;

/**
 * Created by shiza on 02.02.2015.
 */
public enum DrawerItems
{
	FRIEND(R.drawable.ic_send_black_24dp, R.string.friends, new FriendsFragment.Builder());
	//WALL(R.drawable.ic_plusone_tall_off_client, R.string.fragment_wall, new WallFragment.Builder()),
	//MESSAGE(R.drawable.ic_launcher, R.string.fragment_message, new DialogFragment.Builder()),
	//NEWS(R.drawable.ic_drawer, R.string.fragment_news, new NewsListFragment.Builder());

	private int mIconId;
	private int mTitleId;
	private int mCount;
	private BaseFragment.Builder mBuilder;

	DrawerItems(int iconId, int title, BaseFragment.Builder builder)
	{
		mIconId = iconId;
		mTitleId = title;
		mBuilder = builder;
		mCount = 0;
	}

	public int getIconId()
	{
		return mIconId;
	}

	public int getTitleId()
	{
		return mTitleId;
	}

	public int getCount()
	{
		return mCount;
	}

	public void setCount(int count)
	{
		mCount = count;
	}

	public Fragment getFragment()
	{
		return mBuilder.build();
	}
}
