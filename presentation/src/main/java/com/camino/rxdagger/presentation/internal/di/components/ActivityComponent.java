package com.camino.rxdagger.presentation.internal.di.components;

import android.app.Activity;

import com.camino.rxdagger.presentation.internal.di.PerActivity;
import com.camino.rxdagger.presentation.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by robert on 25.02.16.
 * <p/>
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p/>
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
