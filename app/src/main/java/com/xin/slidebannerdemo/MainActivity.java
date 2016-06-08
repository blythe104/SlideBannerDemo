package com.xin.slidebannerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.viewpagerindicator.CirclePageIndicator;
import com.xin.slidebannerdemo.adapter.GuideAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLookDetail;
    private ViewPager mViewPagerBanner;
    private CirclePageIndicator mCircleIndicator;
    private int currentPageScrollStatus;
    private ArrayList<ImageView> mGuideImgList;

    private int[] mImageIds = new int[]{R.mipmap.pagerone, R.mipmap.pagertwo, R.mipmap.pagerone};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLookDetail = (LinearLayout) findViewById(R.id.ll_lookDetail);
        mViewPagerBanner = (ViewPager) findViewById(R.id.viewpager_banner);
        mCircleIndicator = (CirclePageIndicator) findViewById(R.id.circle_indicator);

        // 初始化mList
        mGuideImgList = new ArrayList<ImageView>();
        // 初始化引导图
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mGuideImgList.add(view);
        }

        mViewPagerBanner.setAdapter(new GuideAdapter(getApplication(), mGuideImgList));
        mCircleIndicator.setViewPager(mViewPagerBanner);
        mCircleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == mImageIds.length - 1) {
                    if (positionOffsetPixels == 0 && currentPageScrollStatus == 1) {
                        mLookDetail.setVisibility(View.VISIBLE);
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    }

                } else {
                    mLookDetail.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                currentPageScrollStatus = state;

            }
        });

    }
}
