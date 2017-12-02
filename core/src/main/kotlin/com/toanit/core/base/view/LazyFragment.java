package com.toanit.core.base.view;

/**
 * Created by Toan.IT on 6/22/17.
 * Email: huynhvantoan.itc@gmail.com
 */

public abstract class LazyFragment extends BaseFragment {
    protected boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInvisible() {
        inVisible();
    }

    protected abstract void inVisible();
}