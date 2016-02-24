package com.camino.rxdagger.presentation;

import android.app.Application;

import com.camino.rxdagger.presentation.internal.components.ApiComponent;
import com.camino.rxdagger.presentation.internal.components.DaggerApiComponent;
import com.camino.rxdagger.presentation.internal.modules.ApiModule;
import com.camino.rxdagger.presentation.internal.modules.AppModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by robert on 24.02.16.
 */
public class BaseApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://api.github.com"))
                .build();

        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
