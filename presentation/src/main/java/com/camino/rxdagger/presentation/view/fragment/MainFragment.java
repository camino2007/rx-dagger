package com.camino.rxdagger.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.camino.data.model.User;
import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.components.ApiComponent;
import com.camino.rxdagger.presentation.presenter.MainViewPresenter;
import com.camino.rxdagger.presentation.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by robert on 25.02.16.
 */
public class MainFragment extends BaseFragment implements MainView {

    private static final String KEY_DESTINATION_FRAGMENT_INDEX = "keyDestinationFragmentIndex";
    private static final int MAX_COUNT = 4;

    @Bind(R.id.fragment_main_pager) ViewPager mViewPager;
    @Bind(R.id.sliding_tabs) TabLayout mTabLayout;

    @Inject MainViewPresenter mMainViewPresenter;

    public static MainFragment initMainFragment(int destinationIndex) {
        Bundle b = new Bundle();
        b.putInt(KEY_DESTINATION_FRAGMENT_INDEX, destinationIndex);
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(b);
        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ApiComponent.class).inject(this);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainViewPresenter.setMainView(this);
        Log.d(getTagText(), "onViewCreated");
        if (savedInstanceState == null) {
            mMainViewPresenter.initialize();
            int viewPagerIndex = getArguments().getInt(KEY_DESTINATION_FRAGMENT_INDEX);
            mViewPager.setCurrentItem(viewPagerIndex);
            mViewPager.setAdapter(new MainViewPageAdapter(getChildFragmentManager()));
            mViewPager.setOffscreenPageLimit(MAX_COUNT);
            mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            mTabLayout.setupWithViewPager(mViewPager);
            addTabsToTabLayout();
        }
    }

    private void addTabsToTabLayout() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.main_tab_home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.main_tab_explore);
        mTabLayout.getTabAt(2).setIcon(R.drawable.main_tab_news);
        mTabLayout.getTabAt(3).setIcon(R.drawable.main_tab_profile);
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

    private class MainViewPageAdapter extends FragmentStatePagerAdapter {

        public MainViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = HomeFragment.initHomeFragment(0);
                    break;
                case 1:
                    fragment = HomeFragment.initHomeFragment(1);
                    break;
                case 2:
                    fragment = HomeFragment.initHomeFragment(2);
                    break;
                case 3:
                    fragment = HomeFragment.initHomeFragment(3);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return MAX_COUNT;
        }

    }
}
