package com.camino.rxdagger.presentation.presenter;

import android.util.Log;

import com.camino.data.DefaultSubscriber;
import com.camino.data.loader.BeatClipLoader;
import com.camino.data.model.BeatClip;
import com.camino.rxdagger.presentation.internal.di.PerActivity;
import com.camino.rxdagger.presentation.view.HomeView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by robert on 26.02.16.
 */
@PerActivity
public class HomeViewPresenter implements Presenter {

    private static final String TAG = HomeViewPresenter.class.getSimpleName();

    private HomeView mHomeView;
    private final BeatClipLoader mBeatClipLoader;

    @Inject
    public HomeViewPresenter(BeatClipLoader beatClipLoader) {
        mBeatClipLoader = beatClipLoader;
    }

    public void setHomeView(HomeView homeView) {
        mHomeView = homeView;
    }

    @Override
    public void initialize() {
        Log.d(TAG, "initialize");
       /* this.hideViewRetry();
        this.showViewLoading();*/
/*        Observable observable = mBeatClipLoader.getLatestBeatClipsObservable();
        mBeatClipLoader.execute(observable, new ResultSubscriber());*/
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    private class ResultSubscriber extends DefaultSubscriber<List<BeatClip>> {
        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted");
            // MainViewPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError", e);
      /*      MainViewPresenter.this.hideViewLoading();
            // MainViewPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            MainViewPresenter.this.showViewRetry();*/
        }

        @Override
        public void onNext(List<BeatClip> beatClipList) {
            Log.d(TAG, "onNext - beatClipList.size(): " + beatClipList.size());
            //MainViewPresenter.this.showResult(userList);
        }
    }
}
