package com.github.monchenkoid.project_9_10_14.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import com.github.monchenkoid.project_9_10_14.R;
import com.github.monchenkoid.project_9_10_14.ui.adapters.interfaces.NavigationDrawerListener;
import com.github.monchenkoid.project_9_10_14.ui.fragments.FragmentMain;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends NavigationDrawerActivity implements NavigationDrawerListener {

    private List<String> mListNameItem;

    @Override
    public void onUserInformation() {
        //User information here
        this.mUserName.setText("Аблов Олег");
        this.mUserEmail.setText("Есенин");
        this.mUserPhoto.setImageResource(R.drawable.ic_launcher);
        this.mUserBackground.setImageResource(R.drawable.ic_user_background);
    }

    @Override
    public void onInt(Bundle savedInstanceState) {
        //Creation of the list items is here

        // set listener {required}
        this.setNavigationListener(this);

        //First item of the position selected from the list
        this.setDefaultStartPositionNavigation(1);

        // name of the list items
        mListNameItem = new ArrayList<>();
        mListNameItem.add(getString(R.string.tims));
        mListNameItem.add(getString(R.string.reignins));
        mListNameItem.add(getString(R.string.model_a));
        mListNameItem.add(getString(R.string.sub_tims));
        mListNameItem.add(getString(R.string.table_relationships)); //This item will be a subHeader
        mListNameItem.add(getString(R.string.administrating));
        mListNameItem.add(getString(R.string.new_person));

        // icons list items
        List<Integer> mListIconItem = new ArrayList<>();
        mListIconItem.add(R.drawable.ic_inbox_black_24dp);
        mListIconItem.add(R.drawable.ic_star_black_24dp); //Item no icon set 0
        mListIconItem.add(R.drawable.ic_send_black_24dp); //Item no icon set 0
        mListIconItem.add(R.drawable.ic_drafts_black_24dp);
        mListIconItem.add(0); //When the item is a subHeader the value of the icon 0
        mListIconItem.add(R.drawable.ic_delete_black_24dp);
        mListIconItem.add(R.drawable.ic_report_black_24dp);

        //{optional} - Among the names there is some subheader, you must indicate it here
        List<Integer> mListHeaderItem = new ArrayList<>();
        mListHeaderItem.add(4);

        //{optional} - Among the names there is any item counter, you must indicate it (position) and the value here
        SparseIntArray mSparseCounterItem = new SparseIntArray(); //indicate all items that have a counter
        // mSparseCounterItem.put(0, 16);
        // mSparseCounterItem.put(1, 11);
        // mSparseCounterItem.put(6, 250);

        //If not please use the FooterDrawer use the setFooterVisible(boolean visible) method with value false
        //   this.setFooterInformationDrawer(R.string.settings, R.drawable.ic_settings_black_24dp);

        this.setNavigationAdapter(mListNameItem, mListIconItem, mListHeaderItem, mSparseCounterItem);
    }

    @Override
    public void onItemClickNavigation(int position, int layoutContainerId) {

        FragmentManager mFragmentManager = getSupportFragmentManager();

        Fragment mFragment = new FragmentMain().newInstance(mListNameItem.get(position));

        if (mFragment != null) {
            mFragmentManager.beginTransaction().replace(layoutContainerId, mFragment).commit();
        }
    }

    @Override
    public void onPrepareOptionsMenuNavigation(Menu menu, int position, boolean visible) {

        //hide the menu when the navigation is opens
        switch (position) {
            case 0:
                menu.findItem(R.id.menu_add).setVisible(!visible);
                menu.findItem(R.id.menu_search).setVisible(!visible);
                break;

            case 1:
                menu.findItem(R.id.menu_add).setVisible(!visible);
                menu.findItem(R.id.menu_search).setVisible(!visible);
                break;
        }
    }

    @Override
    public void onClickUserPhotoNavigation(View v) {
        //user photo onClick
        Toast.makeText(this, R.string.open_user_profile, Toast.LENGTH_SHORT).show();
    }

}
