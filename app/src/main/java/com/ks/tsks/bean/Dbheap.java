package com.ks.tsks.bean;

import com.ks.tsks.dao.DaoMaster;
import com.ks.tsks.dao.DaoSession;
import com.ks.tsks.dao.DatasBeanDao;

import java.util.List;

/**
 * Created by F0519 on 2019/6/23.
 */

public class Dbheap {
    private static Dbheap dbheap;
    private final DatasBeanDao mDao;


    private Dbheap() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "rr.db");
        DaoMaster master = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession session = master.newSession();
        mDao = session.getDatasBeanDao();
    }

    public static Dbheap getDbheap() {
        if(dbheap==null){
            synchronized (Dbheap.class){
                if(dbheap==null){
                    dbheap=new Dbheap();
                }
            }
        }
        return dbheap;
    }
    public void insert(DatasBean bean){
        if(has(bean)){
            return;
        }
        mDao.insertOrReplaceInTx(bean);
    }
    public void delete(DatasBean bean){
        if(has(bean)){
        mDao.delete(bean);
        }
    }
    public boolean has(DatasBean bean){
        List<DatasBean> list = mDao.queryBuilder().where(DatasBeanDao.Properties.Title.eq(bean.getTitle())).list();
        if(list!=null&&list.size()>0){
            return true;
        }
        return false;

    }
    public List<DatasBean> queryall(){
        List<DatasBean> list = mDao.queryBuilder().list();
        return list;
    }
    public DatasBean queryone(DatasBean bean){
        DatasBean unique = mDao.queryBuilder().where(DatasBeanDao.Properties.Title.eq(bean.getTitle())).unique();
        return unique;
    }
}
