package com.ks.task2.bean;

public class DatasBean {

    private String title;
    private Boolean check=false;

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public DatasBean(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DatasBean{" +
                "title='" + title + '\'' +
                '}';
    }
}