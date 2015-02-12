package com.github.monchenkoid.project_9_10_14.nd;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TimFragment extends Fragment
{

	private OnFragmentInteractionListener mListener;

	public static TimFragment newInstance(String param1, String param2)
	{
		TimFragment fragment = new TimFragment();
		return fragment;
	}

	public TimFragment()
	{
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_tim, container, false);
	}

	public void onButtonPressed(Uri uri)
	{
		if (mListener != null)
		{
			mListener.onFragmentInteraction(uri);
		}
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		try
		{
			mListener = (OnFragmentInteractionListener) activity;
		}
		catch (ClassCastException e)
		{
			throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
		}
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onDetach()
	{
		super.onDetach();
		mListener = null;
	}

	public interface OnFragmentInteractionListener
	{
		public void onFragmentInteraction(Uri uri);
	}

}
