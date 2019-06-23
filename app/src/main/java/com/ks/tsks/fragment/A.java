package com.ks.tsks.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.ks.tsks.R;
import com.ks.tsks.adapter.Myadapter;
import com.ks.tsks.bean.Aa;
import com.ks.tsks.bean.DatasBean;
import com.ks.tsks.bean.Dbheap;
import com.ks.tsks.model.Mymodelimpl;
import com.ks.tsks.persent.Mypersentimpl;
import com.ks.tsks.view.Myview;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class A extends Fragment implements Myview {


    private View view;
    private RecyclerView mRv;
    private ArrayList<DatasBean> mList;
    private Mypersentimpl mMypersentimpl;
    private Myadapter mMyadapter;
    private CheckBox mcb;

    public A() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser&&mMyadapter!=null){
            mMyadapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        mMypersentimpl = new Mypersentimpl(new Mymodelimpl(), this);
        mMypersentimpl.getData();
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mList = new ArrayList<>();
        mMyadapter = new Myadapter(mList, getActivity());
        mRv.setAdapter(mMyadapter);
        mMyadapter.setOnClickListenerP(new Myadapter.OnClickListenerP() {
            @Override
            public void Onclick(int position, DatasBean bean, View view) {
                mcb = view.findViewById(R.id.cb);
                ArrayList<DatasBean> list = mMyadapter.getList();
                DatasBean bean1 = list.get(position);
                    if(mcb.isChecked()){
                        Dbheap.getDbheap().insert(bean1);
                    }else {
                        Dbheap.getDbheap().delete(bean1);
                    }
            }
        });
    }

    @Override
    public void OnSuccess(Aa Aa) {
        if(Aa!=null){
            mList.addAll(Aa.getData().getDatas());
            mMyadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tag",msg);
    }
}
