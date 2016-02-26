package com.camino.rxdagger.presentation.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.camino.rxdagger.presentation.R;
import com.camino.rxdagger.presentation.internal.HasComponent;
import com.camino.rxdagger.presentation.internal.components.ApiComponent;
import com.camino.rxdagger.presentation.internal.components.DaggerApiComponent;
import com.camino.rxdagger.presentation.internal.modules.ApiModule;
import com.camino.rxdagger.presentation.view.fragment.MainFragment;

public class MainActivity extends BaseActivity implements HasComponent<ApiComponent> {

    private ApiComponent mApiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initializeActivity(savedInstanceState);
        initializeInjector();
    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new MainFragment());
        } else {
           /* this.userId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_USER_ID);*/
        }
    }

    private void initializeInjector() {
        mApiComponent = DaggerApiComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .apiModule(new ApiModule("http://stage.beatclip.com/api/"))
                .build();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
}
