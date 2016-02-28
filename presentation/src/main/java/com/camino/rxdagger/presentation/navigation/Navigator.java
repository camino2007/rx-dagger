package com.camino.rxdagger.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.camino.rxdagger.presentation.view.activity.BeatClipCreateActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by rxdroid on 2/28/16.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToCreateBeatClip(Context context) {
        if (context != null) {
            Intent intentToLaunch = BeatClipCreateActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }
}
