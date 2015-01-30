package com.github.monchenkoid.project_9_10_14.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.bo.models.TypeInfMet;
import com.github.monchenkoid.project_9_10_14.helper.DataManager;
import com.github.monchenkoid.project_9_10_14.processing.TIMArrayProcessor;
import com.github.monchenkoid.project_9_10_14.source.HttpDataSource;

import java.util.List;

/**
 * Created by Irina Monchenko on 19.10.2014.
 */
public class TIMListActivity extends Activity implements DataManager.Callback<List<TypeInfMet>> {

    public static final String URL = "https://dl.dropboxusercontent.com/s//vozjrb2jbjtcrfy/tim_decription.json";
    // "https://dl.dropboxusercontent.com/s/fq0a9s4xjdec133/list_tim.json";

    private ArrayAdapter mAdapter;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private List<TypeInfMet> mData;

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_timlist);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        final HttpDataSource dataSource = HttpDataSource.get(TIMListActivity.this);
        final TIMArrayProcessor processor = new TIMArrayProcessor();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                DataManager.loadData(TIMListActivity.this,
                        URL,
                        dataSource,
                        processor);
            }
        });
        DataManager.loadData(TIMListActivity.this,
                URL,
                dataSource,
                processor);

    }

    @Override
    public void onDataLoadStart() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            findViewById(android.R.id.progress).setVisibility(View.VISIBLE);
        }
        findViewById(android.R.id.empty).setVisibility(View.GONE);
    }


    @Override
    public void onDone(List<TypeInfMet> data) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        findViewById(android.R.id.progress).setVisibility(View.GONE);
        if (data == null || data.isEmpty()) {
            findViewById(android.R.id.empty).setVisibility(View.VISIBLE);
        }
        AdapterView listView = (AbsListView) findViewById(android.R.id.list);
        if (mAdapter == null) {
            mData = data;
            mAdapter = new ArrayAdapter<TypeInfMet>(this, R.layout.adapter_item, android.R.id.text1,
                    data) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    if (convertView == null) {
                        convertView = View
                                .inflate(TIMListActivity.this, R.layout.adapter_item, null);
                    }
                    TypeInfMet item = getItem(position);
                    TextView mName = (TextView) convertView.findViewById(android.R.id.text1);
                    mName.setText(item.getName().get(0));
                    TextView mMbti = (TextView) convertView.findViewById(android.R.id.text2);
                    mMbti.setText(item.getName().get(1));
                    convertView.setTag(item.getName().get(0));
                    return convertView;
                }

            };
            listView.setAdapter(mAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(TIMListActivity.this, DetailsActivity.class);
                    TypeInfMet item = (TypeInfMet) mAdapter.getItem(position);
                    String res = "";
                    intent.putExtra("item", res);
                    startActivity(intent);
                }
            });
        } else {
            mData.clear();
            mData.addAll(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
        findViewById(android.R.id.progress).setVisibility(View.GONE);
        findViewById(android.R.id.empty).setVisibility(View.GONE);
        TextView errorView = (TextView) findViewById(R.id.error);
        errorView.setVisibility(View.VISIBLE);
        errorView.setText(errorView.getText() + "\n" + e.getMessage());
    }

}
