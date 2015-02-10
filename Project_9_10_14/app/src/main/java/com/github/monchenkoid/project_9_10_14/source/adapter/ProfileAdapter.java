package com.github.monchenkoid.project_9_10_14.source.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.CursorUtils;
import com.github.monchenkoid.project_9_10_14.source.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiza on 01.02.2015.
 */
public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
	private LayoutInflater mInflater;
	private Cursor mCursor;
	private Context mContext;
	private final Resources mResources;
	private List<ViewTypes> mUsedTypes;
	private String mUserId;
	private ProfileFragment.OnProfileClick mOnProfileClick;


	private enum ViewTypes
	{
		STATUS, DELETED
	}


	private static class StatusViewHolder extends RecyclerView.ViewHolder
	{
		private TextView mUserStatus;

		private StatusViewHolder(View v)
		{
			super(v);
			mUserStatus = (TextView) v.findViewById(R.id.profile_user_status_full);
		}
	}

	private static class DeleteViewHolder extends RecyclerView.ViewHolder
	{
		private TextView mUserDelete;

		private DeleteViewHolder(View v)
		{
			super(v);
			mUserDelete = (TextView) v.findViewById(R.id.profile_deleted);
		}
	}

	public ProfileAdapter(Context context, Cursor cursor,
						  ProfileFragment.OnProfileClick onProfileClick, String userId)
	{
		mCursor = cursor;
		mResources = context.getResources();
		mContext = context;
		mUsedTypes = new ArrayList<>();
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mOnProfileClick = onProfileClick;
		mUserId = userId;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		ViewTypes[] types = ViewTypes.values();
		switch (types[viewType])
		{
			case STATUS:
				return new StatusViewHolder(mInflater.inflate(R.layout.profile_item_status, parent, false));
			default:
			case DELETED:
				return new DeleteViewHolder(mInflater.inflate(R.layout.profile_deleted, parent, false));
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
	{
		if (mCursor == null || mCursor.isClosed())
		{
			return;
		}

		ViewTypes[] types = ViewTypes.values();
		switch (types[getItemViewType(position)])
		{

			case STATUS:
				//StatusViewHolder statusHolder = (StatusViewHolder) holder;
				//statusHolder.mUserStatus.setText(CursorUtils.getString(mCursor, UsersContract.COLUMN_STATUS));
				break;
			case DELETED:
				DeleteViewHolder deleted = (DeleteViewHolder) holder;
				deleted.mUserDelete.setText(R.string.vk_user_delete_page);
				break;

			default:
				break;
		}
	}

	@Override
	public int getItemCount()
	{
		return mUsedTypes.size();
	}

	@Override
	public int getItemViewType(int position)
	{
		return mUsedTypes.get(position).ordinal();
	}

	public void setCursor(Cursor cursor)
	{
		CursorUtils.closeCursor(mCursor);
		mCursor = cursor;
		if (mCursor != null && !mCursor.isClosed() && mCursor.getCount() > 0)
		{
			mCursor.moveToFirst();
			buildLists();
		}

		notifyDataSetChanged();
	}

	private void buildLists()
	{
		mUsedTypes.clear();
		if (!TextUtils.isEmpty(CursorUtils.getString(mCursor, "status")))
		{
			mUsedTypes.add(ViewTypes.STATUS);
		}

		String deleted = CursorUtils.getString(mCursor, "deleted");
		if (!TextUtils.isEmpty(deleted))
		{
			mUsedTypes.add(ViewTypes.DELETED);
		}
/*
		mCounters.clear();
		//build list
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_FRIENDS, mCounters, CounterTypes.FRIEND);
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_ALBUMS, mCounters, CounterTypes.ALBUMS);
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_GROUPS, mCounters, CounterTypes.GROUPS);
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_VIDEOS, mCounters, CounterTypes.VIDEOS);
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_AUDIOS, mCounters, CounterTypes.AUDIOS);
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_PHOTOS, mCounters, CounterTypes.PHOTOS);
		addIfNotEmptyToList(UsersContract.COLUMN_COUNTERS_NOTES, mCounters, CounterTypes.NOTES);

		if (! mCounters.isEmpty()) {
			mUsedTypes.add(ViewTypes.COUNTERS);
		}*/


	}

}
