package com.github.monchenkoid.project_9_10_14.deprecated.fragments;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.monchenkoid.project_9_10_14.R;

/**
 * Created by Irina Monchenko on 05.12.2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FriendsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.friend_view, container, false);
    }
}
