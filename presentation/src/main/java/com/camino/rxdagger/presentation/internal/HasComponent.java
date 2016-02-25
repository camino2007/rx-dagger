package com.camino.rxdagger.presentation.internal;

/**
 * Created by robert on 25.02.16.
 * <p/>
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
public interface HasComponent<C> {
    C getComponent();
}
