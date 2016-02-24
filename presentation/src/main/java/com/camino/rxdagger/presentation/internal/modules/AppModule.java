package com.camino.rxdagger.presentation.internal.modules;

import android.app.Application;

import com.camino.rxdagger.presentation.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robert on 24.02.16.
 */
@Module
public class AppModule {

    private BaseApplication mBaseApplication;

    public AppModule(BaseApplication baseApplication) {
        mBaseApplication = baseApplication;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mBaseApplication;
    }
}