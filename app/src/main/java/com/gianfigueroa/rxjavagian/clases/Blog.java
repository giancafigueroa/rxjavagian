package com.gianfigueroa.rxjavagian.clases;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class Blog  {
    public String TAG = this.getClass().getSimpleName();

    private String id;
    private String title;
    private String content;
    public Blog() {

    }

    public Blog(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
