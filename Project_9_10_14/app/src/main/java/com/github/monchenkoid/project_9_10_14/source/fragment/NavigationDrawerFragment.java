package com.github.monchenkoid.project_9_10_14.source.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.DrawerItems;
import com.github.monchenkoid.project_9_10_14.source.adapter.DrawerMenuListAdapter;

/**
 * Created by shiza on 02.02.2015.
 */
public class NavigationDrawerFragment extends Fragment
{

	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
	private NavigationDrawerCallbacks mCallbacks;
	private ActionBarDrawerToggle mDrawerToggle;

	private DrawerLayout mDrawerLayout;
	private View mFragmentContainerView;

	private int mCurrentSelectedPosition = 0;
	private boolean mFromSavedInstanceState;
	private boolean mUserLearnedDrawer;
	private String mOldTitle;
	private ListView mUsersListView;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		FragmentActivity activity = getActivity();
		if (activity != null)
		{
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
			mUserLearnedDrawer = sharedPreferences.getBoolean(PREF_USER_LEARNED_DRAWER, false);
		}

		if (savedInstanceState != null)
		{
			mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of actions in the action bar.
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

		FragmentActivity activity = getActivity();
		ListView menu = (ListView) view.findViewById(R.id.menu_list);
		menu.setAdapter(new DrawerMenuListAdapter(activity));

		menu.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				DrawerItems item = (DrawerItems) parent.getItemAtPosition(position);
				if (mCallbacks != null)
				{
					mCallbacks.onNavigationDrawerItemSelected(item.getFragment());
				}
				closeDrawer();
			}
		});

		return view;
	}


	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);

		if (activity instanceof NavigationDrawerCallbacks)
		{
			mCallbacks = (NavigationDrawerCallbacks) activity;
		}
	}

	@Override
	public void onDetach()
	{
		super.onDetach();

		mCallbacks = null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		// If the drawer is open, show the global app actions in the action bar. See also
		// showGlobalContextActionBar, which controls the top-left area of the action bar.
		if (mDrawerLayout != null && isDrawerOpen())
		{
			inflater.inflate(R.menu.menu_main, menu);
			showGlobalContextActionBar();
		}
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
	}


	public boolean isDrawerOpen()
	{
		return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	public static interface NavigationDrawerCallbacks
	{
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(Fragment fragment);

		//void onNavigationDrawerUserSelected(UserAccount userAccount);
	}

	private void showGlobalContextActionBar()
	{
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null)
		{
			actionBar.setDisplayShowTitleEnabled(true);
			//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			mOldTitle = String.valueOf(actionBar.getTitle());
			actionBar.setTitle(R.string.app_name);
		}
	}

	private ActionBar getSupportActionBar()
	{
		FragmentActivity activity = getActivity();
		if (activity == null)
		{
			return null;
		}
		return ((ActionBarActivity) activity).getSupportActionBar();
	}

	private void closeDrawer()
	{
		if (mDrawerLayout != null)
		{
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
	}

	public void setUp(int fragmentId, DrawerLayout drawerLayout)
	{
		FragmentActivity activity = getActivity();
		mFragmentContainerView = activity.findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		// set a custom shadow that overlays the main content when the drawer opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		final ActionBar actionBar = getSupportActionBar();
		if (actionBar != null)
		{
			//show arrow in title
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setHomeButtonEnabled(true);
		}
		// ActionBarDrawerToggle ties together the the proper interactions
		// between the navigation drawer and the action bar app icon.
		mDrawerToggle = new ActionBarDrawerToggle(
				activity, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
		{
			@Override
			public void onDrawerClosed(View drawerView)
			{
				super.onDrawerClosed(drawerView);
				if (!isAdded())
				{
					return;
				}
				restoreTitle();
				supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView)
			{
				super.onDrawerOpened(drawerView);
				if (!isAdded())
				{
					return;
				}

				if (!mUserLearnedDrawer)
				{
					// The user manually opened the drawer; store this flag to prevent auto-showing
					// the navigation drawer automatically in the future.
					mUserLearnedDrawer = true;
					FragmentActivity activity = getActivity();
					if (activity != null)
					{
						SharedPreferences sharedPreferences = PreferenceManager
								.getDefaultSharedPreferences(activity);
						sharedPreferences.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
					}
				}

				supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}

			private void supportInvalidateOptionsMenu()
			{
				FragmentActivity activity = getActivity();
				if (activity != null)
				{
					activity.supportInvalidateOptionsMenu();
				}
			}
		};

		// If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
		// per the navigation drawer design guidelines.
		if (!mUserLearnedDrawer && !mFromSavedInstanceState)
		{
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}

		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable()
		{
			@Override
			public void run()
			{
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	private void restoreTitle()
	{
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null)
		{
			CharSequence title = actionBar.getTitle();
			if (title != null && title.equals(getString(R.string.app_name)))
			{
				actionBar.setDisplayShowTitleEnabled(true);
				actionBar.setTitle(mOldTitle);
			}
		}
	}

}