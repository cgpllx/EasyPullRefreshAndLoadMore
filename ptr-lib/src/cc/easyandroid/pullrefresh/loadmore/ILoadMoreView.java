package cc.easyandroid.pullrefresh.loadmore;

import android.view.View;

/**
 * Created by cgpllx on 2016/6/15.
 */
public interface ILoadMoreView {
    void addFooterView(View view);

    void setOnScrollBottomListener(OnScrollBottomListener onScrollBottomListener);

}
