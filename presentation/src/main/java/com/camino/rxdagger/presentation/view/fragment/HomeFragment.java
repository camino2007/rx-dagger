package com.camino.rxdagger.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.camino.data.model.BeatClip;
import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.adapter.BeatClipAdapter;
import com.camino.rxdagger.presentation.adapter.BeatClipWrapper;
import com.camino.rxdagger.presentation.internal.di.components.ApiComponent;
import com.camino.rxdagger.presentation.presenter.HomeViewPresenter;
import com.camino.rxdagger.presentation.view.HomeView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by robert on 26.02.16.
 */
public class HomeFragment extends BaseFragment implements HomeView, SwipeRefreshLayout.OnRefreshListener {

    private static final String KEY_TEMP = "keyTemp";

    @Bind(R.id.temp_txt) TextView mTextView;
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout) SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.progress_bar) ProgressBar mProgressBar;

    @Inject HomeViewPresenter mHomeViewPresenter;
    @Inject BeatClipAdapter mBeatClipAdapter;

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
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mBeatClipAdapter);
        //mRecyclerView.addOnScrollListener(getOnScrollListener());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mProgressBar.setVisibility(View.VISIBLE);
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

    @Override
    public void showResult(List<BeatClip> beatClipList) {
        Log.d(getTagText(), "showResult - beatClipList.size(): " + beatClipList.size());
        List<BeatClipWrapper> beatClipWrappers = new ArrayList<>();
        BeatClipWrapper beatClipWrapper;
        for (BeatClip beatClip : beatClipList) {
            beatClipWrapper = new BeatClipWrapper(beatClip);
            beatClipWrappers.add(beatClipWrapper);
        }
        mBeatClipAdapter.addItems(beatClipWrappers);
    }

    @Override
    public void onRefresh() {

    }
}
