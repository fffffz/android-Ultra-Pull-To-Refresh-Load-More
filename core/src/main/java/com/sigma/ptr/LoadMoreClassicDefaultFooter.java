package com.sigma.ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by sigma on 2018/4/20.
 */
public class LoadMoreClassicDefaultFooter extends FrameLayout implements LoadMoreUIHandler {

    public LoadMoreClassicDefaultFooter(Context context) {
        super(context);
        initViews();
    }

    public LoadMoreClassicDefaultFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public LoadMoreClassicDefaultFooter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    protected void initViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.lm_classic_default_footer, this);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUILoadMoreBegin(PtrFrameLayout frame) {

    }

    @Override
    public void onUILoadMoreComplete(PtrFrameLayout frame) {

    }

    @Override
    public void onUILoadMoreCancel(PtrFrameLayout frame) {

    }

}
