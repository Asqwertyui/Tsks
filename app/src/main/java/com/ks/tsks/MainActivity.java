package com.ks.tsks;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ks.tsks.adapter.Vpfragment;
import com.ks.tsks.fragment.A;
import com.ks.tsks.fragment.B;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTb;
    private ArrayList<Fragment> mFragments;
    private Vpfragment mVpfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTb = (TabLayout) findViewById(R.id.tb);
        mTb.addTab(mTb.newTab().setText("首页"));
        mTb.addTab(mTb.newTab().setText("收藏"));
        mFragments = new ArrayList<>();
        mFragments.add(new A());
        mFragments.add(new B());
        mVpfragment = new Vpfragment(getSupportFragmentManager(), mFragments);
        mVp.setAdapter(mVpfragment);
        mTb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTb));
    }
}
