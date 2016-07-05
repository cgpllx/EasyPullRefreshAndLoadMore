package cc.easyandroid.pullrefresh.refresh;

import cc.easyandroid.pullrefresh.indicator.PtrIndicator;

/**
 *
 */
public interface PtrUIHandler {

    /**
     * When the content view has reached top and refresh has been completed, view will be reset.
     *
     * @param frame
     */
    void onUIReset(PullRefreshFrameLayout frame);

    /**
     * prepare for loading
     *
     * @param frame
     */
    void onUIRefreshPrepare(PullRefreshFrameLayout frame);

    /**
     * perform refreshing UI
     */
    void onUIRefreshBegin(PullRefreshFrameLayout frame);

    /**
     * perform UI after refresh
     */
    void onUIRefreshComplete(PullRefreshFrameLayout frame);

    void onUIPositionChange(PullRefreshFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator);
}
