package com.zpauly.fantasyjoin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpauly on 2016/11/8.
 */

public class CardFragmentAdapter extends FragmentStatePagerAdapter {
    private final String TAG = getClass().getName();

    private List<CardFragment> mFragments = new ArrayList<>();

    public CardFragmentAdapter(FragmentManager fm, List<CardFragment> fragments) {
        super(fm);
        this.mFragments.addAll(fragments);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        mFragments.set(position, (CardFragment) fragment);
        return fragment;
    }

    public CardView getCardAt(int position) {
        return mFragments.get(position).getCard();
    }
}
