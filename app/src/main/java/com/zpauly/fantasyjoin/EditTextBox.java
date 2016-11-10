package com.zpauly.fantasyjoin;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by zpauly on 2016/11/9.
 */

public class EditTextBox extends CardView {
    private final String TAG = getClass().getName();

    private RelativeLayout mContainer;

    private AppCompatEditText mEditText;
    private AppCompatImageView mHintImageView;

    private int mComponentsMargin;

    private boolean isInputCompleted = true;

    private OnFocusChangeListener onFocusChangeListener;

    public EditTextBox(Context context) {
        super(context);
        init();
    }

    public EditTextBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mContainer = new RelativeLayout(getContext());
        ViewGroup.LayoutParams containerLP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(mContainer, containerLP);

        mComponentsMargin = getResources().getDimensionPixelOffset(R.dimen.components_margin);

        mEditText = new AppCompatEditText(getContext());
        mHintImageView = new AppCompatImageView(getContext());

        mEditText.setBackgroundDrawable(null);
        mEditText.setTextColor(Color.WHITE);
        hideCheckImage();

        RelativeLayout.LayoutParams etLP = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams ivLP = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        etLP.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        etLP.addRule(RelativeLayout.CENTER_VERTICAL);
        ivLP.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        ivLP.addRule(RelativeLayout.CENTER_VERTICAL);
        etLP.setMargins(mComponentsMargin, mComponentsMargin, mComponentsMargin, mComponentsMargin);
        ivLP.setMargins(mComponentsMargin, mComponentsMargin, mComponentsMargin, mComponentsMargin);

        mContainer.addView(mEditText, etLP);
        mContainer.addView(mHintImageView, ivLP);

        mContainer.setBackgroundColor(getResources().getColor(R.color.edit_box_bg_dark));

        setCardElevation(CardShadowTransformer.dpToPixels(getContext(), 2));

        mEditText.setHintTextColor(getResources().getColor(R.color.hint_text_color));
        mEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (mEditText.getText() == null || mEditText.getText().toString().equals("")) {
                    hideCheckImage();
                    return;
                } else {
                    if (b) {
                        hideCheckImage();
                        return;
                    } else {
                        showCheckImage();
                    }
                }
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(view, b);
                }
            }
        });
    }

    public void setHint(CharSequence hint) {
        mEditText.setHint(hint);
    }

    public void setHint(@StringRes int resId) {
        this.setHint(getContext().getString(resId));
    }

    public void checkInput(boolean check) {
        if (check) {
            mHintImageView.setImageResource(R.drawable.ic_check_circle_blue_18dp);
            isInputCompleted = true;
        } else {
            mHintImageView.setImageResource(R.drawable.ic_cancel_red_18dp);
            isInputCompleted = false;
        }
    }

    public void hideCheckImage() {
        mHintImageView.setImageDrawable(null);
    }

    public void showCheckImage() {
        if (isInputCompleted) {
            mHintImageView.setImageResource(R.drawable.ic_check_circle_blue_18dp);
        } else {
            mHintImageView.setImageResource(R.drawable.ic_cancel_red_18dp);
        }
    }

    public AppCompatEditText getEditText() {
        return mEditText;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener listener) {
        this.onFocusChangeListener = listener;
    }
}
