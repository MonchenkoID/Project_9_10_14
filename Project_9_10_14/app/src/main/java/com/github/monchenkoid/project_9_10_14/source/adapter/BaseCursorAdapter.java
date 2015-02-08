package com.github.monchenkoid.project_9_10_14.source.adapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.source.CursorUtils;
import com.github.monchenkoid.project_9_10_14.source.holder.BaseViewHolder;
import com.github.monchenkoid.project_9_10_14.source.holder.HolderBuilder;

abstract class BaseCursorAdapter<VH extends BaseViewHolder> extends CursorAdapter {

   // private ULoader mImageLoader;
    private HolderBuilder mBuilder;
    private final LayoutInflater mInflater;

    BaseCursorAdapter(Context context, Cursor c, boolean autoReQuery, HolderBuilder builder) {
        super(context, c, autoReQuery);
        mBuilder = builder;
       // mImageLoader = CoreApplication.get(context, ULoader.KEY);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    protected abstract int getLayoutID();

    protected abstract void fillData(VH holder, Context context, Cursor cursor);

    protected String getItemIdColumn() {
        return BaseColumns._ID;
    }

    @Override
    public long getItemId(int position) {
        Cursor cursor = getCursor();
        if (cursor != null && ! cursor.isClosed()) {
            if (cursor.moveToPosition(position)) {
                return CursorUtils.getInt(cursor, getItemIdColumn());
            }
        }
        return 0;
    }

    /**
     * Makes a new view to hold the data pointed to by cursor.
     *
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(getLayoutID(), parent, false);

        @SuppressWarnings("unchecked")
        VH holder = (VH) mBuilder.build(view);
        view.setTag(holder);

        return view;
    }

    /**
     * Bind an existing view to the data pointed to by cursor
     *
     * @param view    Existing view, returned earlier by newView
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        VH holder;
        //noinspection unchecked
        holder = (VH) view.getTag();
        if (cursor != null && ! cursor.isClosed()) {
            fillData(holder, context, cursor);
        }
    }

  /*  ULoader getImageLoader() {
        return mImageLoader;
    }*/
}
