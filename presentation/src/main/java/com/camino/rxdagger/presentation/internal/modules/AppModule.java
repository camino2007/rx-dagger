package com.camino.rxdagger.presentation.internal.modules;

import android.content.Context;

import com.camino.data.AccountLoader;
import com.camino.data.ApiLoader;
import com.camino.rxdagger.presentation.BaseApplication;
import com.camino.rxdagger.presentation.internal.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    Context providesApplication() {
        return mBaseApplication;
    }


}
