package com.github.monchenkoid.project_9_10_14.ui.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.ui.adapters.NavigationAdapter;
import com.github.monchenkoid.project_9_10_14.ui.adapters.NavigationDrawerList;
import com.github.monchenkoid.project_9_10_14.ui.adapters.interfaces.NavigationDrawerListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shiza on 02.02.2015.
 */
public class NavigationDrawerFragment extends Fragment
{
	protected TextView mUserName;
	protected TextView mUserEmail;
	protected ImageView mUserPhoto;
	protected ImageView mUserBackground;

	private ListView mList;
	private Toolbar mToolbar;

	private View mHeader;

	private TextView mTitleFooter;
	private ImageView mIconFooter;

	private int mColorName = 0;
	private int mColorIcon = 0;
	private int mColorSeparator = 0;

	private int mColorDefault = 0;
	private int mColorSelected = 0;
	private int mCurrentPosition = 1;
	private int mNewSelector = 0;
	private boolean mRemoveAlpha = false;
	private boolean mRemoveSelector = false;
	private View mFragmentContainerView;
	private List<Integer> mListIcon;
	private List<Integer> mListHeader;
	private List<String> mListNameItem;
	private SparseIntArray mSparseCounter;

	private DrawerLayout mDrawerLayout;
	private FrameLayout mRelativeDrawer;
	private RelativeLayout mFooterDrawer;

	private com.github.monchenkoid.project_9_10_14.source.fragment.NavigationDrawerFragment.NavigationDrawerCallbacks mCallbacks;
	private NavigationAdapter mNavigationAdapter;
	private ActionBarDrawerToggleCompat mDrawerToggle;
	private NavigationDrawerListener mNavigationListener;

	public static final String CURRENT_POSITION = "CURRENT_POSITION";
	public ActionBarActivity activity = (ActionBarActivity) getActivity();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		/*FragmentActivity activity = getActivity();
		if (activity != null) {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
			mUserLearnedDrawer = sharedPreferences.getBoolean(PREF_USER_LEARNED_DRAWER, false);
		}*/

		if (savedInstanceState != null)
		{
			setCurrentPosition(savedInstanceState.getInt(CURRENT_POSITION));
		}
	}

	private void setCurrentPosition(int position)
	{
		this.mCurrentPosition = position;
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
		View view = inflater.inflate(R.layout.navigation_main, container, false);


		//ListView menu = (ListView) view.findViewById(R.id.menu_list);
		//menu.setAdapter(new DrawerMenuListAdapter(activity));


		mList = (ListView) view.findViewById(R.id.list);
		mList.setOnItemClickListener(new DrawerItemClickListener());

		mToolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);
		mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);

		mDrawerToggle = new ActionBarDrawerToggleCompat(activity, mDrawerLayout, mToolbar);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mRelativeDrawer = (FrameLayout) activity.findViewById(R.id.relativeDrawer);

		activity.setSupportActionBar(mToolbar);
		activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		activity.getSupportActionBar().setHomeButtonEnabled(true);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
		{
			try
			{
				Resources.Theme theme = activity.getTheme();
				TypedArray typedArray = theme.obtainStyledAttributes(new int[]{android.R.attr.colorPrimary});
				mDrawerLayout.setStatusBarBackground(typedArray.getResourceId(0, 0));
			}
			catch (Exception e)
			{
				e.getMessage();
			}

			setElevationToolBar(15);
		}

		if (mList != null)
		{
			mountListNavigation(savedInstanceState, inflater);
		}

		if (savedInstanceState == null)
		{
			mNavigationListener.onItemClickNavigation(mCurrentPosition, R.id.container);
		}

		setCheckedItemNavigation(mCurrentPosition, true);

		return view;
	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{

			int mPosition = (position - 1);

			if (position != 0)
			{
				mNavigationListener.onItemClickNavigation(mPosition, R.id.container);
				setCurrentPosition(mPosition);
				setCheckedItemNavigation(mPosition, true);
			}

			mDrawerLayout.closeDrawer(mRelativeDrawer);
		}
	}

	public void setCheckedItemNavigation(int position, boolean checked)
	{
		this.mNavigationAdapter.resetarCheck();
		this.mNavigationAdapter.setChecked(position, checked);
	}

	public void onUserInformation()
	{

	}

	public void onInt(Bundle savedInstanceState)
	{

	}

	private void mountListNavigation(Bundle savedInstanceState, LayoutInflater inflater)
	{
		createUserDefaultHeader(inflater);
		onUserInformation();
		onInt(savedInstanceState);
		setAdapterNavigation();
	}

	private void setAdapterNavigation()
	{

		if (mNavigationListener == null)
		{
			throw new RuntimeException(getString(R.string.start_navigation_listener));
		}

		List<Integer> mListExtra = new ArrayList<>();
		mListExtra.add(mNewSelector);
		mListExtra.add(mColorDefault);
		mListExtra.add(mColorIcon);
		mListExtra.add(mColorName);
		mListExtra.add(mColorSeparator);

		mNavigationAdapter = new NavigationAdapter(activity, NavigationDrawerList.getNavigationAdapter(mListNameItem, mListIcon,
				mListHeader, mSparseCounter, mColorSelected, mRemoveSelector, activity), mRemoveAlpha, mListExtra);

		mList.setAdapter(mNavigationAdapter);
	}

	private void createUserDefaultHeader(LayoutInflater inflater)
	{

		mHeader = inflater.inflate(R.layout.navigation_list_header, mList, false);

		mUserName = (TextView) mHeader.findViewById(R.id.userName);
		mUserEmail = (TextView) mHeader.findViewById(R.id.userEmail);

		mUserPhoto = (ImageView) mHeader.findViewById(R.id.userPhoto);
		mUserPhoto.setOnClickListener(onClickUserPhoto);

		mUserBackground = (ImageView) mHeader.findViewById(R.id.userBackground);
		mList.addHeaderView(mHeader);
	}


	private class ActionBarDrawerToggleCompat extends ActionBarDrawerToggle
	{

		public ActionBarDrawerToggleCompat(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar)
		{
			super(
					activity,
					drawerLayout, toolbar,
					R.string.drawer_open,
					R.string.drawer_close);
		}

		@Override
		public void onDrawerClosed(View view)
		{
			activity.supportInvalidateOptionsMenu();
		}

		@Override
		public void onDrawerOpened(View drawerView)
		{
			activity.supportInvalidateOptionsMenu();
		}
	}

	public void setElevationToolBar(float elevation)
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
		{
			this.getToolbar().setElevation(elevation);
		}
	}

	public Toolbar getToolbar()
	{
		return this.mToolbar;
	}

	private View.OnClickListener onClickUserPhoto = new View.OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			mNavigationListener.onClickUserPhotoNavigation(v);
			mDrawerLayout.closeDrawer(mRelativeDrawer);
		}
	};


	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);

		if (activity instanceof com.github.monchenkoid.project_9_10_14.source.fragment.NavigationDrawerFragment.NavigationDrawerCallbacks)
		{
			mCallbacks = (com.github.monchenkoid.project_9_10_14.source.fragment.NavigationDrawerFragment.NavigationDrawerCallbacks) activity;
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
		outState.putInt(CURRENT_POSITION, mCurrentPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		if (mDrawerToggle != null)
		{
			mDrawerToggle.onConfigurationChanged(newConfig);
		}
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (mDrawerToggle != null)
		{
			if (mDrawerToggle.onOptionsItemSelected(item))
			{
				return true;
			}
		}
		return super.onOptionsItemSelected(item);
	}

	public static interface NavigationDrawerCallbacks
	{
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(Fragment fragment);

		//void onNavigationDrawerUserSelected(UserAccount userAccount);
	}
}
