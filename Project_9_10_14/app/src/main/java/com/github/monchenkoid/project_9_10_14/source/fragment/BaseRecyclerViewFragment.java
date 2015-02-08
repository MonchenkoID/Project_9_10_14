package com.github.monchenkoid.project_9_10_14.source.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.source.fragment.BaseFragment;

/**
 * Created by shiza on 01.02.2015.
 */
public abstract class BaseRecyclerViewFragment extends BaseFragment
{

	private RecyclerViewScrollListener mRecyclerViewScrollListener;
	private RecyclerView mRecyclerView;

	protected abstract RecyclerView.Adapter getNewAdapter();

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = super.onCreateView(inflater, container, savedInstanceState);

		mRecyclerView = (RecyclerView) view.findViewById(getRecyclerViewId());
		if (mRecyclerView == null) {
			throw new IllegalStateException("Did not override getRecyclerViewId, or getRecyclerViewId return invalid RecyclerView id");
		}

		if (savedInstanceState != null) {
			prepareLoader(false);
		} else {
			prepareLoader(true);
			reloadData();
		}
		FragmentActivity activity = getActivity();

		RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
		mRecyclerView.setLayoutManager(mLayoutManager);

		RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
		mRecyclerView.setItemAnimator(itemAnimator);

		mRecyclerView.setAdapter(getNewAdapter());
		mRecyclerView.setHasFixedSize(false);
		mRecyclerView.setOnScrollListener(getRecyclerViewScrollListener());

		return view;
	}

	protected RecyclerView.Adapter getAdapter() {
		return mRecyclerView.getAdapter();
	}

	protected int getRecyclerViewId() {
		return R.id.recycler_view;
	}

	protected RecyclerViewScrollListener getRecyclerViewScrollListener() {
		if (mRecyclerViewScrollListener == null) {
			mRecyclerViewScrollListener = new RecyclerViewScrollListener();
		}
		return mRecyclerViewScrollListener;
	}

	//Scroll in RecyclerView inner SwipeToRefreshLayout hot fix
	private class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			int topRowVerticalPosition =
					(recyclerView == null || recyclerView.getChildCount() == 0)
							? 0
							: recyclerView.getChildAt(0).getTop();
			SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
			if (swipeRefreshLayout != null) {
				swipeRefreshLayout.setEnabled(topRowVerticalPosition >= 0);
			}
		}

		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

			super.onScrollStateChanged(recyclerView, newState);
		}
	}
}
