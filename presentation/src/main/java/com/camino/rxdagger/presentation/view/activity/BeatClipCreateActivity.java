package com.camino.rxdagger.presentation.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.di.HasComponent;
import com.camino.rxdagger.presentation.internal.di.components.BeatClipCreateComponent;
import com.camino.rxdagger.presentation.internal.di.components.DaggerBeatClipCreateComponent;
import com.camino.rxdagger.presentation.internal.di.modules.BeatClipCreateModule;
import com.camino.rxdagger.presentation.view.fragment.BeatClipCreateFragment;

import butterknife.Bind;

/**
 * Created by rxdroid on 2/28/16.
 */
public class BeatClipCreateActivity extends BaseActivity implements HasComponent<BeatClipCreateComponent> {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) FloatingActionButton mActionButton;

    private BeatClipCreateComponent mBeatClipCreateComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, BeatClipCreateActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initializeInjector();
    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Log.d(BeatClipCreateActivity.class.getSimpleName(), "initializeActivity");
            addFragment(R.id.fragment_container, BeatClipCreateFragment.initFragment());
        } else {
           /* this.userId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_USER_ID);*/
        }
    }

    private void initializeInjector() {
        Log.d(BeatClipCreateActivity.class.getSimpleName(), "initializeInjector");
        mBeatClipCreateComponent = DaggerBeatClipCreateComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .beatClipCreateModule(new BeatClipCreateModule())
                .build();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_beatclip;
    }

    @SuppressLint("PrivateResource")
    @Override
    protected void initActionBar() {
        mToolbar.setTitle(getString(R.string.create_beatclip_view_ab_title));
        mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(BeatClipCreateActivity.this);
            }
        });
    }


    @Override
    public BeatClipCreateComponent getComponent() {
        return mBeatClipCreateComponent;
    }
}
