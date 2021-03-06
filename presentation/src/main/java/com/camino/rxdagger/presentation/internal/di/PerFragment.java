package com.camino.rxdagger.presentation.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by robert on 25.02.16.
 * <p/>
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the fragment to be memorized in the
 * correct component.
 */
@Scope
@Retention(RUNTIME)
public @interface PerFragment {
}
