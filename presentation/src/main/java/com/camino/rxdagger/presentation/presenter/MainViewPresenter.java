package com.camino.rxdagger.presentation.presenter;

import android.util.Log;

import com.camino.data.DefaultSubscriber;
import com.camino.data.loader.AccountLoader;
import com.camino.data.model.User;
import com.camino.rxdagger.presentation.internal.PerActivity;
import com.camino.rxdagger.presentation.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by robert on 25.02.16.
 */
@PerActivity
public class MainViewPresenter implements Presenter {

    private static final String TAG = MainViewPresenter.class.getSimpleName();

    private MainView mMainView;
    private final AccountLoader mAccountLoader;

    @Inject
    public MainViewPresenter(AccountLoader accountLoader) {
        mAccountLoader = accountLoader;
    }

    public void setMainView(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void initialize() {
        Log.d(TAG, "initialize");
        this.hideViewRetry();
        this.showViewLoading();
        Observable observable = mAccountLoader.getLatestUsersObservable();
        mAccountLoader.execute(observable, new ResultSubscriber());
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mMainView = null;
        mAccountLoader.unsubscribe();
    }

    private void showViewLoading() {
        this.mMainView.showLoading();
    }

    private void hideViewLoading() {
        this.mMainView.hideLoading();
    }

    private void showViewRetry() {
        this.mMainView.showRetry();
    }

    private void hideViewRetry() {
        this.mMainView.hideRetry();
    }

    private void showResult(List<User> userList) {
        mMainView.showResult(userList);
    }

    private class ResultSubscriber extends DefaultSubscriber<List<User>> {
        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted");
            MainViewPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError", e);
            MainViewPresenter.this.hideViewLoading();
            // MainViewPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            MainViewPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<User> userList) {
            Log.d(TAG, "onNext - userList.size(): " + userList.size());
            MainViewPresenter.this.showResult(userList);
        }
    }


}
