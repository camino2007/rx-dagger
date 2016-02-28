package com.camino.rxdagger.presentation;

import android.app.Application;

import com.camino.rxdagger.presentation.internal.di.components.AppComponent;
import com.camino.rxdagger.presentation.internal.di.components.DaggerAppComponent;
import com.camino.rxdagger.presentation.internal.di.modules.AppModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by robert on 24.02.16.
 */
public class BaseApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
