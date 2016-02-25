package com.camino.rxdagger.presentation.internal.components;

import com.camino.data.AccountLoader;
import com.camino.rxdagger.presentation.internal.PerActivity;
import com.camino.rxdagger.presentation.internal.modules.ActivityModule;
import com.camino.rxdagger.presentation.internal.modules.ApiModule;
import com.camino.rxdagger.presentation.view.fragment.MainFragment;
import com.google.gson.Gson;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by robert on 24.02.16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, ApiModule.class})
public interface ApiComponent extends ActivityComponent {
    void inject(MainFragment mainFragment);

    OkHttpClient getOkHttpClient();

    Gson getGson();

    AccountLoader getAccountLoader();

    Retrofit getRetrofit();

}
