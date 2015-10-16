package com.gobelinscrm14.noemiediaz.backstage.chat.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gobelinscrm14.noemiediaz.backstage.chat.ChatListFragment;
import com.gobelinscrm14.noemiediaz.backstage.chat.user.UserProfilFragment;

/**
 * Created by noemiediaz on 16/10/15.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private static final int CHATLIST = 0;
    private static final int PROFILE = 1;
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Chat", "Profil" };
    private Context context;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case CHATLIST:
                return new ChatListFragment();
            case PROFILE:
                return new UserProfilFragment();
            default:
                return new ChatListFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
