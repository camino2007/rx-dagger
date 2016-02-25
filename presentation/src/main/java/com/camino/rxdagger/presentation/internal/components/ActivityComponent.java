package com.camino.rxdagger.presentation.internal.components;

import android.app.Activity;

import com.camino.rxdagger.presentation.internal.PerActivity;
import com.camino.rxdagger.presentation.internal.modules.ActivityModule;

import dagger.Component;

/**
 * Created by robert on 25.02.16.
 * <p/>
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p/>
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link com.camino.rxdagger.presentation.internal.PerActivity}
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
