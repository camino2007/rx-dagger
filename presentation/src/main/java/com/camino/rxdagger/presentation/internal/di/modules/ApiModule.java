package com.camino.rxdagger.presentation.internal.di.modules;

import com.camino.data.loader.AccountLoader;
import com.camino.data.loader.BeatClipLoader;
import com.camino.rxdagger.presentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by robert on 24.02.16.
 */
@Module
public class ApiModule {

    @Provides
    @PerActivity
    AccountLoader provideAccountApiLoader(Retrofit retrofit) {
        return new AccountLoader(retrofit);
    }

    @Provides
    @PerActivity
    BeatClipLoader provideBeatClipLoader(Retrofit retrofit) {
        return new BeatClipLoader(retrofit);
    }

}
