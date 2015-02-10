package com.github.monchenkoid.project_9_10_14.nd;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.nd.holder.BaseViewHolder;
import com.github.monchenkoid.project_9_10_14.nd.holder.HolderBuilder;

import java.util.List;

/**
 * Created by shiza on 08.02.2015.
 */
public class TimListAdapter extends BaseListAdapter<TimListAdapter.Counter, TimListAdapter.ViewHolder>
{
	public TimListAdapter(Context context, List<Counter> list)
	{
		super(context, list, new Builder());
	}

	@Override
	protected int getLayoutId()
	{
		return R.layout.fragment_tims_item;
	}

	@Override
	protected void fillData(ViewHolder holder, Counter counter)
	{
		holder.avatar.setImageResource(counter.mAvatar);
		holder.name.setText(counter.mName);
		holder.latestMessage.setText(counter.mMessage);
	}

	public static class ViewHolder extends BaseViewHolder
	{
		private final ImageView avatar;
		private final TextView name;
		private final TextView latestMessage;

		private ViewHolder(View view)
		{
			avatar = (ImageView) view.findViewById(R.id.avatar);
			name = (TextView) view.findViewById(R.id.name_tv);
			latestMessage = (TextView) view.findViewById(R.id.latest_message);
		}
	}

	public static class Counter
	{
		private String mName;
		private String mMessage;
		private int mAvatar;

		public Counter(String name, String message, int avatar)
		{
			mName = name;
			mMessage = message;
			mAvatar = avatar;

		}

		public String getName()
		{
			return mName;
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
