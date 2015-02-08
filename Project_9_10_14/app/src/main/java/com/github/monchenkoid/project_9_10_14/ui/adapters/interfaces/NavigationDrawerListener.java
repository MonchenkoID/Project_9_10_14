package com.github.monchenkoid.project_9_10_14.ui.adapters.interfaces;

import android.view.Menu;
import android.view.View;

public interface NavigationDrawerListener {

    /**
     * Item click Navigation (ListView.OnItemClickListener)
     *
     * @param position          position of the item that was clicked.
     * @param layoutContainerId Default layout. Tell the replace - FragmentManager.beginTransaction().replace(layoutContainerId, yourFragment).commit()
     */
    public void onItemClickNavigation(int position, int layoutContainerId);

    /**
     * Prepare options menu navigation (onPrepareOptionsMenu(Menu menu))
     *
     * @param menu     menu.
     * @param position last position of the item that was clicked.
     * @param visible  use to hide the menu when the navigation is open.
     */
    public void onPrepareOptionsMenuNavigation(Menu menu, int position, boolean visible);
    /**
     * Click user photo navigation
     *
     * @param v view.
     */
    public void onClickUserPhotoNavigation(View v);
}
