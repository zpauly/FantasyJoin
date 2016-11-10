package com.zpauly.fantasyjoin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zpauly on 2016/11/8.
 */

public class SignInFragment extends CardFragment {
    private View mView;

    private CardView mCard;
    private AppCompatImageView mExitIV;
    private EditTextBox mUsernameET;
    private EditTextBox mPasswordET;

    private OnPageChangeViewClickedListener onExitClickeListener;

    public void setOnExitClickedListener(OnPageChangeViewClickedListener listener) {
        this.onExitClickeListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.sign_in_card, container, false);
        initViews();
        return mView;
    }

    private void initViews() {
        mCard = (CardView) mView.findViewById(R.id.sign_in_card);
        mCard.setMaxCardElevation(mCard.getCardElevation() * 8);
        mUsernameET = (EditTextBox) mView.findViewById(R.id.username_or_email_et);
        mPasswordET = (EditTextBox) mView.findViewById(R.id.password_et);

        mUsernameET.setHint(R.string.username_or_email);
        mPasswordET.setHint(R.string.password);
        mPasswordET.getEditText().setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);

        mExitIV = (AppCompatImageView) mView.findViewById(R.id.exit_sign_in);
        mExitIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onExitClickeListener != null) {
                    onExitClickeListener.onClicked(view);
                }
            }
        });

        mUsernameET = (EditTextBox) mView.findViewById(R.id.username_or_email_et);
        mPasswordET = (EditTextBox) mView.findViewById(R.id.password_et);
    }

    @Override
    CardView getCard() {
        return mCard;
    }
}
