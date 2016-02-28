package com.camino.rxdagger.presentation.internal.di.components;

import com.camino.rxdagger.presentation.internal.di.PerActivity;
import com.camino.rxdagger.presentation.internal.di.modules.ActivityModule;
import com.camino.rxdagger.presentation.internal.di.modules.ApiModule;
import com.camino.rxdagger.presentation.view.fragment.HomeFragment;
import com.camino.rxdagger.presentation.view.fragment.MainFragment;

import dagger.Component;

/**
 * Created by robert on 24.02.16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, ApiModule.class})
public interface ApiComponent extends ActivityComponent {
    void inject(MainFragment mainFragment);

    void inject(HomeFragment homeFragment);

}
