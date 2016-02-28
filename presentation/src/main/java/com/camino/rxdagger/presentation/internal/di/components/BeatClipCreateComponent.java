package com.camino.rxdagger.presentation.internal.di.components;

import com.camino.rxdagger.presentation.internal.di.PerActivity;
import com.camino.rxdagger.presentation.internal.di.modules.ActivityModule;
import com.camino.rxdagger.presentation.internal.di.modules.BeatClipCreateModule;
import com.camino.rxdagger.presentation.view.fragment.BeatClipCreateFragment;

import dagger.Component;

/**
 * Created by rxdroid on 2/28/16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, BeatClipCreateModule.class})
public interface BeatClipCreateComponent extends ActivityComponent {
    void inject(BeatClipCreateFragment beatClipCreateFragment);
}
