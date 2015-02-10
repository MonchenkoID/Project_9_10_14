package com.github.monchenkoid.project_9_10_14.nd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.github.monchenkoid.project_9_10_14.R;

/**
 * Created by shiza on 06.02.2015.
 */
public class NavigationDrawerAdapter extends BaseAdapter
{
	private MainActivity.NavigationDrawer[] mSamples;

	public NavigationDrawerAdapter(MainActivity.NavigationDrawer[] samples)
	{
		this.mSamples = samples;
	}

	@Override
	public int getCount()
	{
		return mSamples.length;
	}

	@Override
	public Object getItem(int position)
	{
		return mSamples[position];
	}

	@Override
	public long getItemId(int position)
	{
		return mSamples[position].hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup container)
	{
		if (convertView == null)
		{
			convertView = LayoutInflater.from(container.getContext()).inflate(R.layout.sample_dashboard_item,
					container, false);
		}

		((TextView) convertView.findViewById(android.R.id.text1)).setText(
				mSamples[position].titleResId);
		((TextView) convertView.findViewById(android.R.id.text2)).setText(
				mSamples[position].descriptionResId);
		return convertView;
	}
}
