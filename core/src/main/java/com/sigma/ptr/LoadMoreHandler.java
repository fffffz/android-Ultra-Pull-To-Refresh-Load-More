package com.sigma.ptr;

import android.view.View;

/**
 * Created by sigma on 2018/4/20.
 */
public interface LoadMoreHandler {

    public boolean checkCanDoLoadMore(final PtrFrameLayout frame, final View content, final View footer);

    public void onLoadMoreBegin(final PtrFrameLayout frame);

    public void onLoadMoreCancel(final PtrFrameLayout frame);
}