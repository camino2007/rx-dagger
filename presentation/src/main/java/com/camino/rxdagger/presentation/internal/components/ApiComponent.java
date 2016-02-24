package com.camino.rxdagger.presentation.internal.components;

import com.camino.rxdagger.presentation.internal.modules.ApiModule;
import com.camino.rxdagger.presentation.internal.modules.AppModule;
import com.camino.rxdagger.presentation.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by robert on 24.02.16.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity mainActivity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
