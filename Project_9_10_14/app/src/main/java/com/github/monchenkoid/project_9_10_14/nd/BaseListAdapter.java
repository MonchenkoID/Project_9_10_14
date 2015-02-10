package com.github.monchenkoid.project_9_10_14.nd;

import android.content.Context;
import com.github.monchenkoid.project_9_10_14.nd.holder.BaseViewHolder;
import com.github.monchenkoid.project_9_10_14.nd.holder.HolderBuilder;

import java.util.List;

public abstract class BaseListAdapter<T, VH extends BaseViewHolder> extends AbstractBaseAdapter<T, VH>
{

	private List<T> mList;

	public BaseListAdapter(Context context, List<T> list, HolderBuilder builder)
	{
		super(context, builder);

		mList = list;
	}

	@Override
	public int getCount()
	{
		return mList.size();
	}

	@Override
	public T getItem(int position)
	{
		return mList.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}
}
