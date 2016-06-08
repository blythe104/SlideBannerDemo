package com.xin.slidebannerdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by xin on 2016/6/8.
 */
public class GuideAdapter extends PagerAdapter {

    private Context context;

    private ArrayList<ImageView> mGuideImgList;

    public GuideAdapter(Context context, ArrayList<ImageView> mGuideImgList) {
        this.context = context;
        this.mGuideImgList = mGuideImgList;
    }

    @Override
    public int getCount() {
        return mGuideImgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mGuideImgList.get(position);
        container.addView(imageView);

        return imageView;
    }
}
