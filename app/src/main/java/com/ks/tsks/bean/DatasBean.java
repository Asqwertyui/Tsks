package com.ks.tsks.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by F0519 on 2019/6/23.
 */
@Entity
public class DatasBean {
    /**
     * title : Kotlin 新版来了，支持跨平台！
     */
    @Id
    private Long id;
    @Property
    private String title;
    @Generated(hash = 1125384094)
    public DatasBean(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}