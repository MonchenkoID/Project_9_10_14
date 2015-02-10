package com.github.monchenkoid.project_9_10_14.source.adapter;

import android.content.Context;
import com.github.monchenkoid.project_9_10_14.source.holder.BaseViewHolder;
import com.github.monchenkoid.project_9_10_14.source.holder.HolderBuilder;

public abstract class BaseArrayAdapter<T, VH extends BaseViewHolder> extends AbstractBaseAdapter<T, VH>
{
	private final T[] mArrayOfT;

	public BaseArrayAdapter(Context context, T[] arrayOfT, HolderBuilder builder)
	{
		super(context, builder);

		mArrayOfT = arrayOfT;
	}

	@Override
	public int getCount()
	{
		return (mArrayOfT == null) ? 0 : mArrayOfT.length;
	}

	@Override
	public T getItem(int position)
	{
		return (mArrayOfT == null) ? null : mArrayOfT[position];
	}
}
