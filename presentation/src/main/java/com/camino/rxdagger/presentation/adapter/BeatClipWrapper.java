package com.camino.rxdagger.presentation.adapter;

import com.camino.data.model.BeatClip;

/**
 * Created by rxdroid on 2/28/16.
 */
public class BeatClipWrapper {

    private BeatClip mBeatClip;
    private boolean mIsFooter;

    public BeatClipWrapper(BeatClip beatClip) {
        mBeatClip = beatClip;

        mIsFooter =  beatClip == null;
    }


    public boolean isFooter() {
        return mIsFooter;
    }

    public BeatClip getBeatClip() {
        return mBeatClip;
    }
}
