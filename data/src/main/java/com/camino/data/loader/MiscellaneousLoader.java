package com.camino.data.loader;

import com.camino.data.api.MiscellaneousApiService;

import rx.Observable;

/**
 * Created by robert on 26.02.16.
 */
public class MiscellaneousLoader extends ApiLoader {

    private final MiscellaneousApiService mMiscellaneousApiService;


    public MiscellaneousLoader(MiscellaneousApiService miscellaneousApiService) {
        mMiscellaneousApiService = miscellaneousApiService;
    }

    public Observable getAndroidVersionObservable() {
        return null;
        // return mMiscellaneousApiService.
    }
}
