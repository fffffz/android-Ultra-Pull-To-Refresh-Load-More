````
mPtrFrameLayout.setLoadMoreHandler(new LoadMoreHandler() {
    @Override
    public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
        return true;
    }

    @Override
    public void onLoadMoreBegin(PtrFrameLayout frame) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.loadMoreComplete();
                Toast.makeText(MainActivity.this, "load more completed", Toast.LENGTH_SHORT).show();
            }
        }, 5000);
    }

    @Override
    public void onLoadMoreCancel(PtrFrameLayout frame) {
        Toast.makeText(frame.getContext(), "load more canceled", Toast.LENGTH_SHORT).show();
    }
});
````