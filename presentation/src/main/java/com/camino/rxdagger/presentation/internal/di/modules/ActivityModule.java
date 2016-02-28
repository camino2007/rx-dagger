package com.camino.rxdagger.presentation.internal.di.modules;

import android.app.Activity;

import com.camino.rxdagger.presentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robert on 25.02.16.
 * <p/>
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
