package com.example.devashish.tt20.Utility;

/**
 * Created by Devashish on 12/29/2017.
 */

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.devashish.tt20.Contact.Contacts;
import com.example.devashish.tt20.Events.EventFragment;
import com.example.devashish.tt20.FrontUI.featuredFragment;
import com.example.devashish.tt20.Guidelines.Guideline;
import com.example.devashish.tt20.Tickets.Ticket;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
        fragments.add(new EventFragment());
        fragments.add(new Guideline());
        fragments.add(new featuredFragment());
        fragments.add(new Ticket());
        fragments.add(new Contacts());

        //  adapter.addFragment(new Contacts(), "");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}