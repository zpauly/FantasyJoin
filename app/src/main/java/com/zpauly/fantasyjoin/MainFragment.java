package com.zpauly.fantasyjoin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zpauly on 2016/11/8.
 */

public class MainFragment extends CardFragment {
    private View mView;

    private CardView mCard;
    private AppCompatButton mSignInBTN;
    private AppCompatButton mSignUpBTN;

    private AppCompatImageView mLogoIV;
    private AppCompatButton mFacebookBTN;
    private AppCompatButton mTwitterBTN;
    private AppCompatButton mGooglePlusBTN;

    private OnPageChangeViewClickedListener onSignInClickedListener;
    private OnPageChangeViewClickedListener onSignUpClickedListener;

    public void setOnSignInClickedListener(OnPageChangeViewClickedListener listener) {
        this.onSignInClickedListener = listener;
    }

    public void setOnSignUpClickedListener(OnPageChangeViewClickedListener listener) {
        this.onSignUpClickedListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_card, container, false);
        initViews();
        return mView;
    }

    private void initViews() {
        mCard = (CardView) mView.findViewById(R.id.main_card);
        mSignInBTN = (AppCompatButton) mView.findViewById(R.id.sign_in);
        mSignUpBTN = (AppCompatButton) mView.findViewById(R.id.sign_up);
        mLogoIV = (AppCompatImageView) mView.findViewById(R.id.logo_IV);
        mFacebookBTN = (AppCompatButton) mView.findViewById(R.id.facebook_BTN);
        mTwitterBTN = (AppCompatButton) mView.findViewById(R.id.twitter_BTN);
        mGooglePlusBTN = (AppCompatButton) mView.findViewById(R.id.google_plus_BTN);

        mCard.setMaxCardElevation(mCard.getCardElevation() * 8);
        mSignInBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSignInClickedListener != null) {
                    onSignInClickedListener.onClicked(view);
                }
            }
        });
        mSignUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSignUpClickedListener != null) {
                    onSignUpClickedListener.onClicked(view);
                }
            }
        });
    }

    @Override
    CardView getCard() {
        return mCard;
    }
}
