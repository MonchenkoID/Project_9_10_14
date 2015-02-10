package com.github.monchenkoid.project_9_10_14.nd;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.R;

/**
 * Created by shiza on 06.02.2015.
 */
public class NavigationMenuFragment extends Fragment
{
	public static final String ARG_PLANET_NUMBER = "planet_number";

	public NavigationMenuFragment()
	{
	}

	public static Fragment newInstance(int position)
	{
		Fragment fragment = new NavigationMenuFragment();
		Bundle args = new Bundle();
		args.putInt(NavigationMenuFragment.ARG_PLANET_NUMBER, position);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		int i = getArguments().getInt(ARG_PLANET_NUMBER);

		String item = getResources().getStringArray(R.array.navigation_array)[i];
		int fragment;

		switch (i)
		{
			case 0:
				fragment = R.layout.fragment_tims_item_list;
				break;
			default:
				fragment = R.layout.fragment_tim;

		}
		View rootView = inflater.inflate(fragment, container, false);
		//int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()), "drawable", getActivity().getPackageName());

		//ImageView iv = ((ImageView) rootView.findViewById(R.id.image));

		//iv.setImageResource(imageId);

		getActivity().setTitle(item);

		return rootView;
	}

	public static class Builder implements BaseFragment.Builder
	{

		@Override
		public Fragment build()
		{
			return new NavigationMenuFragment();
		}
	}
}
