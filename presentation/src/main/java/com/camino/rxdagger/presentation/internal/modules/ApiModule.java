package com.camino.rxdagger.presentation.internal.modules;

import android.content.Context;

import com.camino.data.AccountLoader;
import com.camino.rxdagger.presentation.internal.PerActivity;
import com.camino.rxdagger.presentation.util.BeatclipShortDateTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
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

*/

    @Provides
    @PerActivity
    Cache provideOkHttpCache(Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(context.getCacheDir(), cacheSize);
    }

    @Provides
    @PerActivity
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }

    @Provides
    @PerActivity
    BeatclipShortDateTypeAdapter provideShortDateTypeAdapter() {
        return new BeatclipShortDateTypeAdapter();
    }

    @Provides
    @PerActivity
    Gson provideGson(BeatclipShortDateTypeAdapter typeAdapter) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        if (typeAdapter != null) {
            gsonBuilder.registerTypeAdapter(Date.class, typeAdapter);
        }
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
