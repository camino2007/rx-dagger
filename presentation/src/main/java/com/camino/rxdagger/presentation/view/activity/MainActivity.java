package com.camino.rxdagger.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.di.HasComponent;
import com.camino.rxdagger.presentation.internal.di.components.ApiComponent;
import com.camino.rxdagger.presentation.internal.di.components.DaggerApiComponent;
import com.camino.rxdagger.presentation.internal.di.modules.ApiModule;
import com.camino.rxdagger.presentation.view.fragment.MainFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements HasComponent<ApiComponent>, MainFragment.OnViewPageListener {

    @Bind(R.id.toolbar) Toolbar mToolbar;
   // @Bind(R.id.fab) FloatingActionButton mActionButton;

    private ApiComponent mApiComponent;
    private String[] mActionBarTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
/*        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            *//*    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
                mNavigator.navigateToCreateBeatClip(MainActivity.this);
            }
        });*/
        initializeInjector();
        mActionBarTitles = new String[]{
                getResources().getString(R.string.main_view_ab_title_home),
                getResources().getString(R.string.main_view_ab_title_explore),
                getResources().getString(R.string.main_view_ab_title_news),
                getResources().getString(R.string.main_view_ab_title_profile)
        };
    }

    @OnClick(R.id.fab)
    public void onActionButtonClicked(){
        //mNavigator.navigateToCreateBeatClip(this);
        Intent intentToLaunch = BeatClipCreateActivity.getCallingIntent(this);
        startActivity(intentToLaunch);
    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Log.d(MainActivity.class.getSimpleName(), "initializeActivity");
            addFragment(R.id.fragment_container, MainFragment.initMainFragment(0));
        } else {
           /* this.userId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_USER_ID);*/
        }
    }

    private void initializeInjector() {
        Log.d(MainActivity.class.getSimpleName(), "initializeInjector");
        mApiComponent = DaggerApiComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .apiModule(new ApiModule())
                .build();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initActionBar() {
        mToolbar.setTitle(getString(R.string.main_view_ab_title_home));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public ApiComponent getComponent() {
        return mApiComponent;
    }

    @Override
    public void onViewPageSelected(int position) {
        if (mToolbar != null) {
            mToolbar.setTitle(mActionBarTitles[position]);
        }
    }
}
