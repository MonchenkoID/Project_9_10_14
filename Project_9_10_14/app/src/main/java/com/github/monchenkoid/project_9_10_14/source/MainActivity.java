package com.github.monchenkoid.project_9_10_14.source;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.fragment.BaseFragment;
import com.github.monchenkoid.project_9_10_14.source.fragment.FriendsFragment;
import com.github.monchenkoid.project_9_10_14.source.fragment.NavigationDrawerFragment;

/**
 * Created by shiza on 02.02.2015.
 */
public class MainActivity extends BaseActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			showProfileFragment("12345");
		}

		NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment)
				getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		navigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(Fragment fragment)
	{
		Bundle args = new Bundle();
		args.putString(BaseFragment.ARGS_USER_ID, getCurrentUserId());
		fragment.setArguments(args);
		//TODO tag
		replaceFragment(R.id.container, fragment, FriendsFragment.TAG);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment)
				getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		if (navigationDrawerFragment != null && ! navigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.menu_main, menu);
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

}
