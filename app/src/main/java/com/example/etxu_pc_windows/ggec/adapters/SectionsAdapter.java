package com.example.etxu_pc_windows.ggec.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etxu-pc-windows on 23/01/2018.
 */

public class SectionsAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> listFragments = new ArrayList<>();
    private final List<String>   listTitles    = new ArrayList<>();

    public SectionsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        listFragments.add(fragment);
        listTitles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
