package com.github.monchenkoid.project_9_10_14.source;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.adapter.ProfileAdapter;
import com.github.monchenkoid.project_9_10_14.source.fragment.BaseRecyclerViewFragment;

/**
 * Created by shiza on 01.02.2015.
 */
public class ProfileFragment extends BaseRecyclerViewFragment implements LoaderManager.LoaderCallbacks<Cursor>
{
	private OnProfileClick mOnProfileClick;
	public static final String TAG = ProfileFragment.class.getSimpleName();


	@Override
	protected RecyclerView.Adapter getNewAdapter()
	{
		FragmentActivity activity = getActivity();
		if (activity != null) {
			return new ProfileAdapter(activity, null, mOnProfileClick, getArgsUserId());
		}
		return null;
	}

	@Override
	protected int getLayoutId()
	{
		return R.layout.fragment_profile;
	}

	@Override
	protected Loader<Cursor> createLoader(Bundle args)
	{
		FragmentActivity activity = getActivity();
		if (activity == null) {
			return null;
		}
		//return new UserLoader(activity, args);
		return null;
	}

	@Override
	protected int getFragmentTitleResource()
	{
		return R.string.fragment_profile;
	}

	@Override
	protected void onLoadCursorFinished(Cursor cursor)
	{		ProfileAdapter adapter = (ProfileAdapter) getAdapter();
		if (adapter != null && cursor != null) {
			adapter.setCursor(cursor);
			adapter.notifyItemChanged(0);
		}
	}

	@Override
	protected int buildLoaderId()
	{
		return Integer.parseInt(getArgsUserId());
	}

	@Override
	protected Bundle prepareLoaderBundle()
	{
		Bundle bundle = new Bundle();
		bundle.putString(UserLoader.ARGS_USER_ID, getArgsUserId());

		return bundle;
	}
	public static interface OnProfileClick {
		void onProfileFriendClick(String userId);

		void onProfilePhotoClick(String userId);

		void onProfileWallClick(String userId);
	}

	public static Fragment newInstance(String userId) {
		Fragment fragment = new ProfileFragment();
		Bundle bundle = new Bundle();
		bundle.putString(ARGS_USER_ID, userId);
		fragment.setArguments(bundle);
		return fragment;
	}
}
