package cc.easyandroid.pullrefresh;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import cc.easyandroid.pullrefresh.loadmore.ILoadMoreView;
import cc.easyandroid.pullrefresh.loadmore.OnScrollBottomListener;

/**
 * Created by cgpllx on 2016/6/16.
 */
public class PullRecyclerView extends RecyclerView implements ILoadMoreView {
    public PullRecyclerView(Context context) {
        super(context);
    }

    public PullRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    View mLoadMoreFooterView;

    @Override
    public void addFooterView(View view) {
        mLoadMoreFooterView = view;
        Adapter adapter = getAdapter();
        if (adapter != null && adapter instanceof ILoadMoreView) {
            ILoadMoreView loadMoreView = (ILoadMoreView) adapter;
            loadMoreView.addFooterView(view);
        }

    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter != null && adapter instanceof ILoadMoreView) {
            ILoadMoreView loadMoreView = (ILoadMoreView) adapter;
            loadMoreView.addFooterView(mLoadMoreFooterView);
        }
    }

    @Override
    public void setOnScrollBottomListener(OnScrollBottomListener onScrollBottomListener) {
        addOnScrollListener(new RecyclerViewOnScrollListener(onScrollBottomListener));
    }

    /**
     * 滑动监听
     */
    private static class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
        private OnScrollBottomListener onScrollBottomListener;

        public RecyclerViewOnScrollListener(OnScrollBottomListener onScrollBottomListener) {
            super();
            this.onScrollBottomListener = onScrollBottomListener;
        }

        @Override
        public void onScrollStateChanged(android.support.v7.widget.RecyclerView recyclerView, int newState) {
            if (newState == RecyclerView.SCROLL_STATE_IDLE && isScollBottom(recyclerView)) {
                if (onScrollBottomListener != null) {

                    onScrollBottomListener.onScorllBootom();
                }
            }
        }

        private boolean isScollBottom(RecyclerView recyclerView) {
            return !isCanScollVertically(recyclerView);
        }

        private boolean isCanScollVertically(RecyclerView recyclerView) {
            if (android.os.Build.VERSION.SDK_INT < 14) {
                return ViewCompat.canScrollVertically(recyclerView, 1) || recyclerView.getScrollY() < recyclerView.getHeight();
            } else {
                return ViewCompat.canScrollVertically(recyclerView, 1);
            }
        }

        @Override
        public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {

        }

    }
}
