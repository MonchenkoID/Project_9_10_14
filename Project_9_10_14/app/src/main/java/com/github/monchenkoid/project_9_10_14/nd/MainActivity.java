package com.github.monchenkoid.project_9_10_14.nd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.github.monchenkoid.project_9_10_14.R;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener
{
	private NavigationDrawer[] mSamples;
	private GridView mGridView;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ndactivity_main);

		// Prepare list of samples in this dashboard.
		mSamples = new NavigationDrawer[]{
				new NavigationDrawer(R.string.navigationdraweractivity_title, R.string.navigationdraweractivity_description,
						NavigationDrawerActivity.class),
		};

		// Prepare the GridView
		mGridView = (GridView) findViewById(android.R.id.list);
		mGridView.setAdapter(new NavigationDrawerAdapter(mSamples));
		mGridView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> container, View view, int position, long id)
	{
		startActivity(mSamples[position].intent);
	}

	public class NavigationDrawer
	{
		int titleResId;
		int descriptionResId;
		Intent intent;

		public NavigationDrawer(int titleResId, int descriptionResId, Intent intent)
		{
			this.intent = intent;
			this.titleResId = titleResId;
			this.descriptionResId = descriptionResId;
		}

		public NavigationDrawer(int titleResId, int descriptionResId,
								Class<? extends Activity> activityClass)
		{
			this(titleResId, descriptionResId,
					new Intent(MainActivity.this, activityClass));
		}
	}
}
