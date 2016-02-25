package com.camino.rxdagger.presentation.internal.components;

import android.content.Context;

import com.camino.rxdagger.presentation.internal.modules.AppModule;
import com.camino.rxdagger.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by robert on 25.02.16.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
