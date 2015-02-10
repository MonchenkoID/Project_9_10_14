package com.github.monchenkoid.project_9_10_14.source.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.adapter.FriendsPagerAdapter;

/**
 * Created by shiza on 02.02.2015.
 */
public class FriendsFragment extends Fragment
{
	public static final String TAG = FriendsFragment.class.getSimpleName();
	public static final String ARGS_USER_ID = BaseFragment.ARGS_USER_ID;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_friends, container, false);

		ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
		viewPager.setAdapter(new FriendsPagerAdapter(getChildFragmentManager(), getActivity(), getArgsUserId()));

		PagerTabStrip pagerTabStrip = (PagerTabStrip) view.findViewById(android.R.id.tabs);
		pagerTabStrip.setTabIndicatorColorResource(R.color.abc_search_url_text_selected);

		return view;
	}

	private String getArgsUserId()
	{
		Bundle arguments = getArguments();
		if (arguments != null)
		{
			return arguments.getString(ARGS_USER_ID);
		}
		return "";
	}

	public static class Builder implements BaseFragment.Builder
	{

		@Override
		public Fragment build()
		{
			return new FriendsFragment();
		}
	}
}
