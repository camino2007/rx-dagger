package com.camino.data;

import android.util.Log;

import retrofit2.Retrofit;
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

    protected abstract Observable buildObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        Log.d(ApiLoader.class.getSimpleName(), "execute");
        mSubscription = this.buildObservable()
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
