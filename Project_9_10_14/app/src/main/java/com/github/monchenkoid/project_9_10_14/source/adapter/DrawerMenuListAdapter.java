package com.github.monchenkoid.project_9_10_14.source.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.DrawerItems;
import com.github.monchenkoid.project_9_10_14.source.holder.BaseViewHolder;
import com.github.monchenkoid.project_9_10_14.source.holder.HolderBuilder;

/**
 * Created by shiza on 02.02.2015.
 */
public class DrawerMenuListAdapter extends BaseArrayAdapter<DrawerItems, DrawerMenuListAdapter.ViewHolder>
{

	public DrawerMenuListAdapter(Context context)
	{
		super(context, DrawerItems.values(), new Builder());
	}


	@Override
	protected int getLayoutId()
	{
		return R.layout.drawer_menu_item;
	}

	@Override
	protected void fillData(DrawerMenuListAdapter.ViewHolder holder, DrawerItems objectOfT)
	{
		holder.mIcon.setImageResource(objectOfT.getIconId());
		holder.mTitle.setText(objectOfT.getTitleId());
		int count = objectOfT.getCount();
		holder.mCount.setText(count > 0 ? String.valueOf(count) : "");
	}

	@Override
	public long getItemId(int position)
	{
		DrawerItems item = getItem(position);
		if (item != null)
		{
			return item.ordinal();
		}
		else
		{
			return 0;
		}
	}

	public static class ViewHolder extends BaseViewHolder
	{
		private ImageView mIcon;
		private TextView mTitle;
		private TextView mCount;

		public ViewHolder(View v)
		{
			mIcon = (ImageView) v.findViewById(R.id.icon);
			mTitle = (TextView) v.findViewById(R.id.title);
			mCount = (TextView) v.findViewById(R.id.counter);
		}
	}

	private static class Builder implements HolderBuilder
	{
		@Override
		public BaseViewHolder build(View v)
		{
			return new ViewHolder(v);
		}
	}
}
