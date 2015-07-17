package com.github.monchenkoid.project_9_10_14.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.github.monchenkoid.project_9_10_14.nd.holder.BaseViewHolder;
import com.github.monchenkoid.project_9_10_14.nd.holder.HolderBuilder;

public abstract class AbstractBaseAdapter<T, VH extends BaseViewHolder> extends BaseAdapter {
    private final LayoutInflater mInflater;
    private final HolderBuilder mBuilder;

    protected abstract int getLayoutId();

    protected abstract void fillData(VH holder, T objectOfT);

    public AbstractBaseAdapter(Context context, HolderBuilder builder) {
        mInflater = LayoutInflater.from(context);
        mBuilder = builder;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(getLayoutId(), parent, false);
            holder = mBuilder.build(convertView);
            convertView.setTag(holder);
        } else {
            holder = (BaseViewHolder) convertView.getTag();
        }
        T item = (T) getItem(position);

        if (holder != null && item != null) {
            fillData((VH) holder, item);
        }

        return convertView;
    }

}
