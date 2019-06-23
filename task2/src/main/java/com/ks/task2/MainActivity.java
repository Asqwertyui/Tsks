package com.ks.task2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ks.task2.adapter.Myadapter;
import com.ks.task2.bean.Aa;
import com.ks.task2.bean.DatasBean;
import com.ks.task2.model.Mymodelimpl;
import com.ks.task2.persent.Mypersentimpl;
import com.ks.task2.view.Myview;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Myview, View.OnClickListener {

    private RecyclerView mRv;
    private ArrayList<DatasBean> mList;
    private Myadapter mMyadapter;
    private Mypersentimpl mMypersentimpl;
    /**
     * 首页
     */
    private Button mBtsy;
    /**
     * 删除
     */
    private Button mBtdelete;
    /**
     * 完成
     */
    private Button mBtok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mMypersentimpl = new Mypersentimpl(new Mymodelimpl(), this);
        mMypersentimpl.getData();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mMyadapter = new Myadapter(mList, this);
        mRv.setAdapter(mMyadapter);
        mBtsy = (Button) findViewById(R.id.btsy);
        mBtsy.setOnClickListener(this);
        mBtdelete = (Button) findViewById(R.id.btdelete);
        mBtdelete.setOnClickListener(this);
        mBtok = (Button) findViewById(R.id.btok);
        mBtok.setOnClickListener(this);
    }

    @Override
    public void OnSuccess(Aa Aa) {
        if (Aa != null) {
            mList.addAll(Aa.getData().getDatas());
            mMyadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tag", msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btsy:
            if(mMyadapter.getIscheck()==false){
                mMyadapter.setIscheck(true);
            }else {
                mMyadapter.setIscheck(false);
            }
            mMyadapter.notifyDataSetChanged();
                break;
            case R.id.btdelete:
                ArrayList<DatasBean> list = new ArrayList<>();
                ArrayList<DatasBean> beans = new ArrayList<>();
                for (DatasBean aa:list) {
                    Boolean check = aa.getCheck();
                    if(check==true){
                     beans.add(aa);
                    }
                }
                list.removeAll(beans);
                mMyadapter.notifyDataSetChanged();
                break;
            case R.id.btok:
                if(mMyadapter.getIscheck()==false){
                    mMyadapter.setIscheck(true);
                }else {
                    mMyadapter.setIscheck(false);
                }
                mMyadapter.notifyDataSetChanged();
                break;
        }
    }
}
