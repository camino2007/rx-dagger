package com.camino.rxdagger.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.components.ApiComponent;
import com.camino.rxdagger.presentation.presenter.HomeViewPresenter;
import com.camino.rxdagger.presentation.view.HomeView;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by robert on 26.02.16.
 */
public class HomeFragment extends BaseFragment implements HomeView {

    private static final String KEY_TEMP = "keyTemp";

    @Bind(R.id.temp_txt) TextView mTextView;

    @Inject HomeViewPresenter mHomeViewPresenter;

    public static Fragment initHomeFragment(int i) {
        Bundle b = new Bundle();
        b.putInt(KEY_TEMP, i);
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(b);
        return homeFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public String getTagText() {
        return HomeFragment.class.getSimpleName();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ApiComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        int tempValue = getArguments().getInt(KEY_TEMP);
        mTextView.setText(String.valueOf(tempValue));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHomeViewPresenter.setHomeView(this);
        Log.d(getTagText(), "onViewCreated");
        if (savedInstanceState == null) {
            mHomeViewPresenter.initialize();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getTagText(), "onResume");
        mHomeViewPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mHomeViewPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHomeViewPresenter.destroy();
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
