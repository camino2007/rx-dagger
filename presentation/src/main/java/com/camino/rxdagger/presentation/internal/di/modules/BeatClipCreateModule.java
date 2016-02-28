package com.camino.rxdagger.presentation.internal.di.modules;

import com.camino.data.MusicProvider;
import com.camino.rxdagger.presentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rxdroid on 2/28/16.
 */
@Module
public class BeatClipCreateModule {

    @Provides
    @PerActivity
    MusicProvider provideMusicLoader() {
        return new MusicProvider();
    }

}
