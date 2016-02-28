package com.camino.data.loader;

import android.util.Log;

import com.camino.data.enums.ProcessingState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    private ProcessingState mProcessingState = ProcessingState.IDLE;
    private Map<String, OnProcessStateListener> mListenerMap = new ConcurrentHashMap<>();

    public ProcessingState getProcessingState() {
        return mProcessingState;
    }

    public void setProcessingState(ProcessingState processingState) {
        notifyListener(processingState);
        mProcessingState = processingState;
    }

    private void notifyListener(ProcessingState processingState) {
        OnProcessStateListener stateListener;
        for (String key : mListenerMap.keySet()) {
            stateListener = mListenerMap.get(key);
            stateListener.onProcessStateChanged(processingState);
        }
    }

    public void registerForCallback(String id, OnProcessStateListener listener) {
        if (!mListenerMap.containsKey(id)) {
            mListenerMap.put(id, listener);
        }
    }

    public void unregister(String id) {
        if (mListenerMap.containsKey(id)) {
            mListenerMap.remove(id);
        }
    }

    @SuppressWarnings("unchecked")
    public void execute(Observable observable, Subscriber subscriber) {
        Log.d(ApiLoader.class.getSimpleName(), "execute");
        setProcessingState(ProcessingState.IN_PROGRESS);
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

    public interface OnProcessStateListener {
        void onProcessStateChanged(ProcessingState processingState);
    }


}
