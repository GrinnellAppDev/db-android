package edu.grinnell.appdev.grinnelldirectory.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.grinnell.appdev.grinnelldirectory.fragments.AdvancedSearchFragment;
import edu.grinnell.appdev.grinnelldirectory.fragments.SimpleSearchFragment;

/**
 * Created by nicholasroberson on 4/16/17.
 */

public class SearchPagerAdapter extends FragmentPagerAdapter {

    public SearchPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SIMPLE";
            case 1:
                return "ADVANCED";
        }
        return "SIMPLE";
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new SimpleSearchFragment();
                break;
            case 1:
                fragment = new AdvancedSearchFragment();
                break;
            default:
                fragment = new SimpleSearchFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
