package com.gianfigueroa.rxjavagian.clases;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class BlogObservable extends Observable {
    private ArrayList<Observer> observers;
    private Blog blog;

    public BlogObservable(Blog blog) {
        this.blog = blog;
        this.observers=new ArrayList<>();
    }
    public void changeBlog(){
        for (Observer observer:observers) {
            observer.onNext(this);
        }
    }
    @Override
    protected void subscribeActual(Observer observer) {
        observers.add(observer);
    }
}
