package com.camino.rxdagger.presentation.internal.di.components;

import android.content.Context;

import com.camino.rxdagger.presentation.internal.di.modules.AppModule;
import com.camino.rxdagger.presentation.util.BeatclipShortDateTypeAdapter;
import com.camino.rxdagger.presentation.view.activity.BaseActivity;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by robert on 25.02.16.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    Context context();

    Cache cache();

    OkHttpClient okHttpClient();

    BeatclipShortDateTypeAdapter shortDateTypeAdapter();

    Gson gson();

    Retrofit retrofit();


}
