package cc.easyandroid.pullrefresh.refresh;

import android.view.View;

/**
 * 刷新的监听
 * @param <T>
 */
public interface RefreshListener<T extends PullRefreshFrameLayout> {

    /**
     * Check can do refresh or not. For example the content is empty or the first child is in view.
     * <p/>
     * {@link DefaultRefreshListener#checkContentCanBePulledDown}
     */
    boolean checkCanDoRefresh(final T frame, final View content, final View header);

    /**
     * When refresh begin
     *
     * @param frame
     */
    void onRefreshBegin(final T frame);

}