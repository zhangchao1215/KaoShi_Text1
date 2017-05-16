package jiyun.com.kaoshi_text1.recycler;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mList;

    public ViewPagerAdapter(List<View> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView(mList.get(position%mList.size()));
     }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (container != null) {
            container.removeView(mList.get(position % mList.size()));
        }
        container.addView(mList.get(position % mList.size()));
        return mList.get(position % mList.size());
    }


}
