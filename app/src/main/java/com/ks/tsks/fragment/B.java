package com.ks.tsks.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ks.tsks.R;
import com.ks.tsks.adapter.Myadapter;
import com.ks.tsks.bean.DatasBean;
import com.ks.tsks.bean.Dbheap;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class B extends Fragment {


    private View view;
    private RecyclerView mRv;
    private ArrayList<DatasBean> mDatasBeans = new ArrayList<>();
    private Myadapter mMyadapter;

    public B() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
            initData();
        }else {
            mDatasBeans.clear();
        }
        super.setUserVisibleHint(isVisibleToUser);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        initView(view);

        return view;
    }
    private void initData() {
        List<DatasBean> list = Dbheap.getDbheap().queryall();
        mDatasBeans.addAll(list);
        mMyadapter.setList(mDatasBeans);
        mMyadapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMyadapter = new Myadapter(mDatasBeans, getActivity());
        mRv.setAdapter(mMyadapter);
        mMyadapter.setOnClickListenerP(new Myadapter.OnClickListenerP() {
            @Override
            public void Onclick(int position, DatasBean bean, View view) {
                Dbheap.getDbheap().delete(bean);
                mDatasBeans.remove(bean);
                mMyadapter.notifyDataSetChanged();
            }
        });
    }
}
