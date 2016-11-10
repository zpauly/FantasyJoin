package com.zpauly.fantasyjoin;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by zpauly on 2016/11/8.
 */

public class CardShadowTransformer implements ViewPager.PageTransformer, ViewPager.OnPageChangeListener {
    private final String TAG = getClass().getName();

    private Context mContext;
    private CardFragmentAdapter mAdapter;

    private float baseElevation;

    private float lastPositionOffest;

    public CardShadowTransformer(Context context, CardFragmentAdapter adapter) {
        mContext = context;
        this.mAdapter = adapter;
        baseElevation = dpToPixels(mContext, 2);
    }

    @Override
    public void transformPage(View page, float position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lastPositionOffest = positionOffset;

        CardView currentCard = null;
        CardView nextCard = null;
        float offset;
        boolean goingBack = lastPositionOffest > positionOffset;

        int currentPosition;
        int nextPosition;

        if (goingBack) {
            currentPosition = position + 1;
            nextPosition = position;
            offset = 1 - positionOffset;
        } else {
            currentPosition = position;
            nextPosition = position + 1;
            offset = positionOffset;
        }

        if (currentPosition <= (mAdapter.getCount() - 1) && nextPosition <= (mAdapter.getCount() - 1)) {
            currentCard = mAdapter.getCardAt(currentPosition);
            nextCard = mAdapter.getCardAt(nextPosition);
        }

        if (currentCard != null) {
            currentCard.setScaleX((float) (1 + 0.1 * (1 - offset)));
            currentCard.setScaleY((float) (1 + 0.1 * (1 - offset)));
            currentCard.setCardElevation(baseElevation + (1 - offset) * 8);
        }

        if (nextCard != null) {
            nextCard.setScaleX((float) (1 + 0.1 * offset));
            nextCard.setScaleY((float) (1 + 0.1 * offset));
            nextCard.setCardElevation(baseElevation + offset * 8);
        }

        lastPositionOffest = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public static float dpToPixels(Context context, int dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
