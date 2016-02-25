package com.camino.rxdagger.presentation.internal.modules;

import com.camino.data.AccountLoader;
import com.camino.data.ApiLoader;
import com.camino.rxdagger.presentation.internal.PerActivity;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by robert on 24.02.16.
 */
@Module
public class ApiModule {

    private String mBaseUrl;
    private static final int TIME_OUT = 30;

    // Constructor needs one parameter to instantiate.
    public ApiModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

/*    // Dagger will only look for methods annotated with @Provides
    @Provides
    @PerActivity
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @PerActivity
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }



*/

    @Provides
    @PerActivity
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        return okHttpClient;
    }

    @Provides
    @PerActivity
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @PerActivity
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @PerActivity
    AccountLoader provideAccountApiLoader(Retrofit retrofit) {
        return new AccountLoader(retrofit);
    }


}
