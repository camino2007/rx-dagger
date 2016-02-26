package com.camino.data.loader;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by robert on 25.02.16.
 */
public abstract class ApiLoader {

    private Subscription mSubscription = Subscriptions.empty();

    @SuppressWarnings("unchecked")
    public void execute(Observable observable, Subscriber subscriber) {
        Log.d(ApiLoader.class.getSimpleName(), "execute");
        mSubscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
