package com.github.monchenkoid.project_9_10_14.source;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.fragment.FriendsFragment;

/**
 * Created by shiza on 02.02.2015.
 */
public class BaseActivity extends ActionBarActivity implements
		ProfileFragment.OnProfileClick
{
	@Override
	public void onProfileFriendClick(String userId)
	{
		FriendsFragment friendsFragment = new FriendsFragment();
		Bundle args = new Bundle();
		args.putString(FriendsFragment.ARGS_USER_ID, userId);
		friendsFragment.setArguments(args);
		replaceFragment(R.id.container, friendsFragment, FriendsFragment.TAG, true);
	}

	@Override
	public void onProfilePhotoClick(String userId)
	{

	}

	@Override
	public void onProfileWallClick(String userId)
	{
		FriendsFragment friendsFragment = new FriendsFragment();
		Bundle args = new Bundle();
		args.putString(FriendsFragment.ARGS_USER_ID, userId);
		friendsFragment.setArguments(args);

		replaceFragment(R.id.container, friendsFragment, FriendsFragment.TAG, true);
	}


	protected void replaceFragment(int containerId, Fragment fragment, String tag) {
		replaceFragment(containerId, fragment, tag, false);
	}

	public static void clearViews(ViewGroup viewGroup, FragmentManager supportFragmentManager) {
		viewGroup.setVisibility(View.INVISIBLE);
		ViewPager viewPager = (ViewPager) viewGroup.findViewById(R.id.pager);
		if (viewPager != null) {
			PagerAdapter adapter = viewPager.getAdapter();
			if (adapter != null && adapter.getCount() > 0) {
				FragmentTransaction fragmentTransaction = null;
				for (int i = 0; i < adapter.getCount(); i++) {
					Fragment fragment = supportFragmentManager.findFragmentByTag("android:switcher:" + R.id.pager + ":" + i);
					if (fragment != null) {
						if (fragmentTransaction == null) {
							fragmentTransaction = supportFragmentManager.beginTransaction();
						}
						fragmentTransaction.remove(fragment);
					}
				}
				if (fragmentTransaction != null) {
					fragmentTransaction.commit();
				}
			}
			viewPager.removeAllViews();
			viewGroup.removeView(viewPager);
		}
		viewGroup.removeAllViews();
	}


	protected void replaceFragment(int containerId, Fragment fragment, String tag, boolean addToBackStack) {
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
		fragmentTransaction.replace(containerId, fragment, tag);
		if (addToBackStack) {
			fragmentTransaction.addToBackStack(tag);
		}
		fragmentTransaction.commit();
	}

	protected String getCurrentUserId() {
	/*	UserAccount userAccount = ((CoreApplication) getApplication()).getCurrentUser();
		return userAccount != null ? userAccount.getUserId() : "";*/
		return null;
	}


	protected void showProfileFragment(String userId) {
		showProfileFragment(userId, false);
	}

	protected void showProfileFragment(String userId, boolean addToBackStack) {
		replaceFragment(R.id.container, ProfileFragment.newInstance(userId), ProfileFragment.TAG, addToBackStack);
	}

}
