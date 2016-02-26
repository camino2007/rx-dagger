package com.camino.rxdagger.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.camino.data.model.User;
import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.components.ApiComponent;
import com.camino.rxdagger.presentation.presenter.MainViewPresenter;
import com.camino.rxdagger.presentation.view.MainView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by robert on 25.02.16.
 */
public class MainFragment extends BaseFragment implements MainView {

    @Inject MainViewPresenter mMainViewPresenter;

    public MainFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ApiComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainViewPresenter.setMainView(this);
        Log.d(getTagText(), "onViewCreated");
        if (savedInstanceState == null) {
            mMainViewPresenter.initialize();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public String getTagText() {
        return MainFragment.class.getSimpleName();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getTagText(), "onResume");
        mMainViewPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMainViewPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMainViewPresenter.destroy();
    }

    @Override
    public void showResult(List<User> userList) {
        Log.d(getTagText(), "showResult - userList.size(): " + userList.size());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return getContext();
    }
}
