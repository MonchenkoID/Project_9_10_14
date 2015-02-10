package com.github.monchenkoid.project_9_10_14.ui.fragments;

import android.annotation.TargetApi;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.*;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.utils.Log;

//import android.view.MenuItem;

public class FragmentMain extends Fragment
{

	private boolean mSearchCheck;
	private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";

	public FragmentMain newInstance(String text)
	{
		FragmentMain mFragment = new FragmentMain();
		Bundle mBundle = new Bundle();
		mBundle.putString(TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		TextView mTxtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
		mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));

		rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@TargetApi(VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu, menu);

		//Select search item
		final MenuItem menuItem = menu.findItem(R.id.menu_search);
		menuItem.setVisible(true);

		SearchView searchView = (SearchView) menuItem.getActionView();
		searchView.setQueryHint(this.getString(R.string.search));

		((EditText) searchView.findViewById(R.id.search_src_text))
				.setHintTextColor(getResources().getColor(R.color.primary_text));
		searchView.setOnQueryTextListener(onQuerySearchView);

		menu.findItem(R.id.menu_add).setVisible(true);

		mSearchCheck = false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub

		switch (item.getItemId())
		{

			case R.id.menu_add:
				Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
				break;

			case R.id.menu_search:
				mSearchCheck = true;
				Toast.makeText(getActivity(), R.string.search, Toast.LENGTH_SHORT).show();
				break;
			default:
				Log.d(FragmentMain.class.getSimpleName(), "id item is wrong");
		}
		return true;
	}

	private SearchView.OnQueryTextListener onQuerySearchView = new SearchView.OnQueryTextListener()
	{
		@Override
		public boolean onQueryTextSubmit(String s)
		{
			return false;
		}

		@Override
		public boolean onQueryTextChange(String s)
		{
	   /*     if (mSearchCheck) {
                // implement your search here
            }*/
			return false;
		}
	};
}