package com.zpauly.fantasyjoin;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FantasyJoinActivity extends AppCompatActivity {
    private final String TAG = getClass().getName();

    private CustomViewpager mJoinVP;

    private CardFragmentAdapter mCardAdapter;
    private CardShadowTransformer mCardTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_join);

        initViews();
    }

    private void initViews() {
        mJoinVP = (CustomViewpager) findViewById(R.id.join_viewpager);
        mJoinVP.setPagingEnabled(false);
        initViewPager();
    }

    private void initViewPager() {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setOnSignInClickedListener(new OnPageChangeViewClickedListener() {
            @Override
            public void onClicked(View v) {
                mJoinVP.setCurrentItem(2);
            }
        });
        mainFragment.setOnSignUpClickedListener(new OnPageChangeViewClickedListener() {
            @Override
            public void onClicked(View v) {
                mJoinVP.setCurrentItem(0);
            }
        });

        SignInFragment signInFragment = new SignInFragment();
        signInFragment.setOnExitClickedListener(new OnPageChangeViewClickedListener() {
            @Override
            public void onClicked(View v) {
                mJoinVP.setCurrentItem(1);
            }
        });

        SignUpFragment signUpFragment = new SignUpFragment();
        signUpFragment.setOnExitClickedListener(new OnPageChangeViewClickedListener() {
            @Override
            public void onClicked(View v) {
                mJoinVP.setCurrentItem(1);
            }
        });
        List<CardFragment> fragments = new ArrayList<>();
        fragments.add(signUpFragment);
        fragments.add(mainFragment);
        fragments.add(signInFragment);
        mCardAdapter = new CardFragmentAdapter(getSupportFragmentManager(), fragments);
        mCardTransformer = new CardShadowTransformer(this, mCardAdapter);
        mJoinVP.addOnPageChangeListener(mCardTransformer);
        mJoinVP.setAdapter(mCardAdapter);
        mJoinVP.setPageTransformer(false, mCardTransformer);
        mJoinVP.setOffscreenPageLimit(3);
        mJoinVP.setCurrentItem(1);
    }
}
