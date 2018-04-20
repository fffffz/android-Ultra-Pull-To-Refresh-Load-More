package com.sigma.ptr;

/**
 * Created by sigma on 2018/4/20.
 */
class LoadMoreUIHandlerHolder implements LoadMoreUIHandler {

    private LoadMoreUIHandler mHandler;
    private LoadMoreUIHandlerHolder mNext;

    private boolean contains(LoadMoreUIHandler handler) {
        return mHandler != null && mHandler == handler;
    }

    private LoadMoreUIHandlerHolder() {

    }

    public boolean hasHandler() {
        return mHandler != null;
    }

    private LoadMoreUIHandler getHandler() {
        return mHandler;
    }

    public static void addHandler(LoadMoreUIHandlerHolder head, LoadMoreUIHandler handler) {

        if (null == handler) {
            return;
        }
        if (head == null) {
            return;
        }
        if (null == head.mHandler) {
            head.mHandler = handler;
            return;
        }

        LoadMoreUIHandlerHolder current = head;
        for (; ; current = current.mNext) {

            // duplicated
            if (current.contains(handler)) {
                return;
            }
            if (current.mNext == null) {
                break;
            }
        }

        LoadMoreUIHandlerHolder newHolder = new LoadMoreUIHandlerHolder();
        newHolder.mHandler = handler;
        current.mNext = newHolder;
    }

    public static LoadMoreUIHandlerHolder create() {
        return new LoadMoreUIHandlerHolder();
    }

    public static LoadMoreUIHandlerHolder removeHandler(LoadMoreUIHandlerHolder head, LoadMoreUIHandler handler) {
        if (head == null || handler == null || null == head.mHandler) {
            return head;
        }

        LoadMoreUIHandlerHolder current = head;
        LoadMoreUIHandlerHolder pre = null;
        do {

            // delete current: link pre to next, unlink next from current;
            // pre will no change, current move to next element;
            if (current.contains(handler)) {

                // current is head
                if (pre == null) {

                    head = current.mNext;
                    current.mNext = null;

                    current = head;
                } else {

                    pre.mNext = current.mNext;
                    current.mNext = null;
                    current = pre.mNext;
                }
            } else {
                pre = current;
                current = current.mNext;
            }

        } while (current != null);

        if (head == null) {
            head = new LoadMoreUIHandlerHolder();
        }
        return head;
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        LoadMoreUIHandlerHolder current = this;
        do {
            final LoadMoreUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUIReset(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUILoadMoreBegin(PtrFrameLayout frame) {
        LoadMoreUIHandlerHolder current = this;
        do {
            final LoadMoreUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUILoadMoreBegin(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUILoadMoreComplete(PtrFrameLayout frame) {
        LoadMoreUIHandlerHolder current = this;
        do {
            final LoadMoreUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUILoadMoreComplete(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUILoadMoreCancel(PtrFrameLayout frame) {
        LoadMoreUIHandlerHolder current = this;
        do {
            final LoadMoreUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUILoadMoreCancel(frame);
            }
        } while ((current = current.mNext) != null);
    }

}
