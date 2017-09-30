package com.pubnub.example.android.datastream.pubnubdatastreams;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.google.common.collect.ImmutableList;
import com.pubnub.example.android.datastream.pubnubdatastreams.pubsub.PubSubListAdapter;
import com.pubnub.example.android.datastream.pubnubdatastreams.pubsub.PubSubTabContentFragment;

import java.util.List;

public class MainActivityTabManager extends FragmentStatePagerAdapter {
    private final PubSubTabContentFragment pubsub = new PubSubTabContentFragment();

    private ImmutableList<PubSubTabContentFragment> items = ImmutableList.of(pubsub);

    public MainActivityTabManager(FragmentManager fm, int NumOfTabs) {
        super(fm);
    }

    public void setPubSubAdapter(PubSubListAdapter psAdapter) {
        this.pubsub.setAdapter(psAdapter);
    }


    @Override
    public Fragment getItem(int position) {

        return this.items.get(position);
    }

    @Override
    public int getCount() {
        return this.items.size();
    }
}
