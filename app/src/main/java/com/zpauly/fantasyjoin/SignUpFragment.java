package com.zpauly.fantasyjoin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zpauly on 2016/11/8.
 */

public class SignUpFragment extends CardFragment {
    private final String TAG = getClass().getName();

    private View mView;

    private CardView mCard;
    private AppCompatImageView mExitIV;

    private EditTextBox mFullNameET;
    private EditTextBox mEmailNameET;
    private EditTextBox mUsernameET;
    private EditTextBox mPasswordET;

    private OnPageChangeViewClickedListener onExitClickedListener;

    public void setOnExitClickedListener(OnPageChangeViewClickedListener listener) {
        this.onExitClickedListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.sign_up_card, container, false);
        initViews();
        return mView;
    }

    private void initViews() {
        mCard = (CardView) mView.findViewById(R.id.sign_up_card);
        mFullNameET = (EditTextBox) mView.findViewById(R.id.full_name_ET);
        mEmailNameET = (EditTextBox) mView.findViewById(R.id.email_et);
        mUsernameET = (EditTextBox) mView.findViewById(R.id.username_et);
        mPasswordET = (EditTextBox) mView.findViewById(R.id.password_et);

        mCard.setMaxCardElevation(mCard.getCardElevation() * 8);
        mExitIV = (AppCompatImageView) mView.findViewById(R.id.exit_sign_up);
        mExitIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onExitClickedListener != null) {
                    onExitClickedListener.onClicked(view);
                }
            }
        });
        mFullNameET.setHint(R.string.full_name);
        mEmailNameET.setHint(R.string.email_address);
        mUsernameET.setHint(R.string.username);
        mPasswordET.setHint(R.string.password);
        mPasswordET.getEditText().setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
        mEmailNameET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if ((mEmailNameET.getEditText().getText() != null && !mEmailNameET.getEditText().getText().toString().equals("")) && mEmailNameET.getEditText().getText().toString().endsWith(".com") && mEmailNameET.getEditText().getText().toString().contains("@")) {
                    Log.i(TAG, "checked true");
                    mEmailNameET.checkInput(true);
                } else {
                    Log.i(TAG, "checked false");
                    mEmailNameET.checkInput(false);
                }
            }
        });
    }

    @Override
    CardView getCard() {
        return mCard;
    }
}
