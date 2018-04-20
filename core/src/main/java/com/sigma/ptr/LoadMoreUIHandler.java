package com.sigma.ptr;

/**
 * Created by sigma on 2018/4/20.
 */
public interface LoadMoreUIHandler {

    public void onUIReset(PtrFrameLayout frame);

    public void onUILoadMoreBegin(PtrFrameLayout frame);

    public void onUILoadMoreComplete(PtrFrameLayout frame);

    public void onUILoadMoreCancel(PtrFrameLayout frame);

}
